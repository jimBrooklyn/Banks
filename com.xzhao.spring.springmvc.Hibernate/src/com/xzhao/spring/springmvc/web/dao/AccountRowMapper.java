package com.xzhao.spring.springmvc.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(true);
		user.setAuthority(rs.getString("authority"));
		user.setName(rs.getString("name"));

		Account account = new Account();
		account.setUser(user);
		account.setActid(rs.getInt("actid"));
		account.setActtype(rs.getString("acttype"));
		account.setBalance(rs.getDouble("balance"));
		account.setInrate(rs.getDouble("inrate"));
		return account;

	}

}
