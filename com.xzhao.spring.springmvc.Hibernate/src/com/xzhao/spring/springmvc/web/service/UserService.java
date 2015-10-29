package com.xzhao.spring.springmvc.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.xzhao.spring.springmvc.web.dao.User;
import com.xzhao.spring.springmvc.web.dao.UserDao;

@Service("userService")
public class UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	


	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDao.create(user);
	}



	public boolean exist(String username) {
		
		return userDao.exist(username);
	}


	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}
	

}
