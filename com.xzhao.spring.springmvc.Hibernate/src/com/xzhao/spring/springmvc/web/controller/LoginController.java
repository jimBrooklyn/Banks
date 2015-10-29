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

import com.xzhao.spring.springmvc.web.dao.Account;
import com.xzhao.spring.springmvc.web.dao.FormValidationGroup;
import com.xzhao.spring.springmvc.web.dao.User;
import com.xzhao.spring.springmvc.web.service.AccountService;
import com.xzhao.spring.springmvc.web.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/loggedout")
	public String showLogout() {
		return "loggedout";
	}
	
	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}
	
	@RequestMapping("/deposited")
	public String showDeposited() {
		return "deposited";
	}
	@RequestMapping("/withdrawn")
	public String showWithDrawn() {
		return "withdrawn";
	}	
	@RequestMapping("/admin")
	public String showAdmin(Model model)	{
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin";
	}
	
	@RequestMapping("/allaccounts")

		public String showAllaccounts(Model model, Principal principal)	{				
			List<Account> accounts = accountService.getCurrent();
			model.addAttribute("accounts", accounts);
			
			boolean hasAccount = false;
			if(principal !=null){
				hasAccount = accountService.hasAccount(principal.getName());
			}
			
			model.addAttribute("hasAccount", hasAccount);
		return "allaccounts";
	}

	@RequestMapping("/newuser")
	public String showNewUser(Model model) {
		model.addAttribute("user", new User());
		return "newuser";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createuser")
	public String doCreate(Model model, @Validated(value=FormValidationGroup.class) User user, BindingResult rs) {

		if (rs.hasErrors()) {
			return "newuser";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		if (userService.exist(user.getUsername())) {
			rs.rejectValue("username", "DuplicateKey.user.username");
			return "newuser";
		}
		userService.createUser(user);
		return "usercreated";
	}
}
