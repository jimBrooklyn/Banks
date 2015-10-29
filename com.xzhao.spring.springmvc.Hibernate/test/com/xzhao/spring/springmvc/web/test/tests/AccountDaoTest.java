package com.xzhao.spring.springmvc.web.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xzhao.spring.springmvc.web.dao.Account;
import com.xzhao.spring.springmvc.web.dao.AccountDao;
import com.xzhao.spring.springmvc.web.dao.User;
import com.xzhao.spring.springmvc.web.dao.UserDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {"classpath:com/xzhao/spring/springmvc/web/config/dao-context.xml", "classpath:com/xzhao/spring/springmvc/web/test/config/datasource.xml","classpath:com/xzhao/spring/springmvc/web/config/security-context.xml"} )
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountDaoTest {
	@Autowired
	private UserDao userDao;	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private DataSource dataSource;
	@Before
	public void init(){
		JdbcTemplate jdbc =new JdbcTemplate(dataSource);
		jdbc.execute("delete from accounts");			
		jdbc.execute("delete from users");	
	}
	
	@Test
	public void testCreateuser(){
		User user = new User("xzhao","123456", "jim zhao", "jim@yahoo.com", true, "ROLE_USER");
		userDao.create(user);
		
		List<User> users = userDao.getAllUsers();
	
		assertEquals("Number of users should be 1.", 1, users.size());
		
		Account account= new Account(user, 0, "checking", 0.05, 1500.2);

		accountDao.save(account);
		List<Account> accounts = accountDao.getAccount();
		
		assertEquals("Number of accounts should be 1.", 1, accounts.size());
		
	}
}