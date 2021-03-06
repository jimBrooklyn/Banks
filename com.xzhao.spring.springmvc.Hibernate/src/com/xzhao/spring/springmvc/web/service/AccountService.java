package com.xzhao.spring.springmvc.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.xzhao.spring.springmvc.web.dao.Account;
import com.xzhao.spring.springmvc.web.dao.AccountDao;
import com.xzhao.spring.springmvc.web.dao.User;

@Service("accountService")
public class AccountService {
	
	private AccountDao accountDao;
	
	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public List<Account> getUserAccounts(String username){
		return accountDao.getAccount(username);
	}
	
	public List<Account> getCurrent(){
		return accountDao.getAccount();
	}

	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public void createAccount(Account account) {
		accountDao.save(account);	
	}

	public boolean hasAccount(String name) {
		if(name==null)		return false;
		List<Account> accounts = accountDao.getAccount(name);
		if(accounts.size()>0) return true;
		return false;
	}

	public void delete(int actid) {
		
		accountDao.deleteAccount(actid);
	}

	public void save(Account account) {
			accountDao.save(account);
	}

	public List<Account> getAccount(String username) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(username);
	}

	public void updateAccount(int actId, double amount) {
		// TODO Auto-generated method stub
		accountDao.updateAccount(actId, amount);
	}
}
