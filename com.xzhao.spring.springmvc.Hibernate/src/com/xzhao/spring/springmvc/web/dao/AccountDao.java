package com.xzhao.spring.springmvc.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("accountDao")
public class AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	public void save(Account account) {
		session().save(account);
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAccount() {
		Criteria crit = session().createCriteria(Account.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAccount(String username) {
		Criteria crit = session().createCriteria(Account.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}

	public boolean deleteAccount(int actid) {
		Query query = session().createQuery("delete from Account where actid=:actid");
		query.setLong("actid", actid);
		return query.executeUpdate() == 1;
	}

	public Account getAccount(int actid) {
		Criteria crit = session().createCriteria(Account.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.idEq(actid));
		return (Account)crit.uniqueResult();
	}

	public void update(Account account) {

		session().save(account);
	}

	public void updateAccount(int actid, double amount) {
		// TODO Auto-generated method stub
		Query query = session().createQuery("update Account set balance=balance+:amount where actid=:actid");
		query.setLong("actid", actid);
		query.setDouble("amount", amount);
		int result= query.executeUpdate();
	}


}
