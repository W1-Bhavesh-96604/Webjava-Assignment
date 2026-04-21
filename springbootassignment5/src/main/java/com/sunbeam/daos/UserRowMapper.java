package com.sunbeam.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.User;

@Component
public class UserRowMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		String password = rs.getString("password");
		String role = rs.getString("role");
		Date birth = rs.getDate("birth");
		String addr = rs.getString("addr");
		User user = new User(id, name, email, password, role, birth, addr);
		return user;
	}

}
