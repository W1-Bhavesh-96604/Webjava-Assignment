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
	public List<User> getAllUser() {
		String sql = "SELECT * FROM users";
		List<User> list = jdbcTemplate.query(sql, userRowMapper);
		return list;
	}
	
	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO users(name,email,password,role,birth,addr) VALUES(?,?,?,?,?,?)";
		int cnt = jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole(), user.getBirth(), user.getAddr());
		return cnt;
	}
	
	@Override
    public int updateUserInfo(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, birth = ?, addr = ? WHERE id = ?";
        return jdbcTemplate.update(sql, 
            user.getName(), 
            user.getEmail(), 
            user.getBirth(), 
            user.getAddr(), 
            user.getId()
        );
    }

    @Override
    public int changePassword(int id, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        return jdbcTemplate.update(sql, newPassword, id);
    }

    @Override
    public int deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
