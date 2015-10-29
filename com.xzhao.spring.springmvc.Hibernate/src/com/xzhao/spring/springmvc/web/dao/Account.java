package com.xzhao.spring.springmvc.web.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Entity
@Table(name="accounts")
public class Account {
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	@Id
	@Column(name="actid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actid;
	
	private String acttype;
	
	private double balance;
	
	@DecimalMax(value = "10",groups={FormValidationGroup.class})
	@DecimalMin(value= "0.0", groups={FormValidationGroup.class})
	private double inrate;
	
	
	public Account(){
		this.user= new User();
	}

	public Account(User user, int actid, String acttype, double balance, double inrate) {
		this.user = user;
		this.actid = actid;
		this.acttype = acttype;
		this.balance = balance;
		this.inrate = inrate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername(){
		return user.getUsername();
	}

	public int getActid() {
		return actid;
	}

	public void setActid(int actid) {
		this.actid = actid;
	}

	public String getActtype() {
		return acttype;
	}

	public void setActtype(String acttype) {
		this.acttype = acttype;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInrate() {
		return inrate;
	}

	public void setInrate(double inrate) {
		this.inrate = inrate;
	}

	@Override
	public String toString() {
		return "Account [user=" + user + ", actid=" + actid + ", acttype=" + acttype + ", balance=" + balance
				+ ", inrate=" + inrate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acttype == null) ? 0 : acttype.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(inrate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (acttype == null) {
			if (other.acttype != null)
				return false;
		} else if (!acttype.equals(other.acttype))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (Double.doubleToLongBits(inrate) != Double.doubleToLongBits(other.inrate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



}
