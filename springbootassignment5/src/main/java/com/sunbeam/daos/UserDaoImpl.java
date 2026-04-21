package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRowMapper userRowMapper;
	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> list = jdbcTemplate.query(sql, userRowMapper);
		return list;
	}
	@Override
	public List<User> findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, id);
		return list;
	}
	@Override
	public List<User> findByName(String name) {
		String sql = "SELECT * FROM users WHERE name LIKE ?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper,"%" + name + "%");
		return list;
	}
	
	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO users(name,email,password,role,birth,addr) VALUES(?,?,?,?,?,?)";
		int cnt = jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole(), user.getBirth(), user.getAddr());
		return cnt;
	}
	
	@Override
	public int updateUser(User user) {
		String sql =  "UPDATE users SET name=?, password=?, email=?, addr=?, role=?, birth=? WHERE id=?";
		int cnt = jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getEmail(), user.getAddr(), user.getRole(), user.getBirth(), user.getId());
		return cnt;
	}
	
	@Override
	public int updateAddress(String newAddr, int id) {
		String sql =  "UPDATE users SET addr=? WHERE id=?";
		int cnt = jdbcTemplate.update(sql, newAddr, id);
		return cnt;
	}
	
	@Override
	public int deleteById(int id) {
		String sql =  "DELETE FROM users WHERE id=?";
		int cnt = jdbcTemplate.update(sql, id);
		return cnt;
	}

	
	
}
