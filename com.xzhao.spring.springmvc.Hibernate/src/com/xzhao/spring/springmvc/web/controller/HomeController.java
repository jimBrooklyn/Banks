package com.xzhao.spring.springmvc.web.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xzhao.spring.springmvc.web.dao.Account;
import com.xzhao.spring.springmvc.web.service.AccountService;

@Controller
public class HomeController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/")
	public String showHome(Model model, Principal principal)	{	
		
		List<Account> accounts = accountService.getCurrent();
		model.addAttribute("accounts", accounts);
		
		boolean hasAccount = false;
		if(principal !=null){
			hasAccount = accountService.hasAccount(principal.getName());
		}		
		model.addAttribute("hasAccount", hasAccount);
		
		return "home";
	}

}

