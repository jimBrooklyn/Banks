package com.xzhao.spring.springmvc.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xzhao.spring.springmvc.web.dao.Account;
import com.xzhao.spring.springmvc.web.dao.FormValidationGroup;
import com.xzhao.spring.springmvc.web.service.AccountService;

@Controller
public class AccountsController {

	private AccountService accountService;

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping("/accounts")
	public String showAccounts(Model model, Principal principal) {
		String username = principal.getName();
		List<Account> accounts = accountService.getAccount(username);
		model.addAttribute("accounts", accounts);
		model.addAttribute("username", username);
		return "accounts";
	}

	@RequestMapping("/createaccount")
	public String createAccount(Model model, Principal principal) {

		Account account = null;
		if (principal != null) {
			String username = principal.getName();
			if (accountService.getAccount(username).size() > 0) {
				account = accountService.getAccount(username).get(0);
			}
		}
		if (account == null) {
			account = new Account();
		}
		model.addAttribute("account", account);
		return "createaccount";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/docreate")
	public String doCreate(Model model, @Validated(value = FormValidationGroup.class) Account account, BindingResult rs,
			Principal principal, @RequestParam(value = "delete", required = false) String delete) {

		if (rs.hasErrors()) {
			return "createaccount";

		} else {

			if (delete == null) {
				String username = principal.getName();
				account.getUser().setUsername(username);
				accountService.save(account);
				return "accountcreated";
			} else {
				accountService.delete(account.getActid());
				return "accountdeleted";
			}

		}
	}
	

	@RequestMapping(method = RequestMethod.POST, value = "/dotransaction")
	public String doTransaction(int actId, double amount, String transtype) {

		if (transtype.equals("deposit")) {
			accountService.updateAccount(actId, amount);
			return "redirect:deposited";
		} else {
			amount = -amount;
			accountService.updateAccount(actId, amount);
			return "redirect:withdrawn";
		}
	}
}
