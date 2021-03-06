package com.xzhao.spring.springmvc.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
@Component("userDao")
public class UserDao {

	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired(required=false)
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	

	@Transactional
	public void create(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}
	

	public boolean exist(String username) {
		Criteria crit = session().createCriteria(User.class);
		crit.add(Restrictions.eq("username", username));
		User user = (User)crit.uniqueResult();
		return user!=null;
	}
	

	@SuppressWarnings("unchecked")
	
	public List<User> getAllUsers() {		
		return session().createQuery("from User").list();
		//	return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
				
	}
	

}
