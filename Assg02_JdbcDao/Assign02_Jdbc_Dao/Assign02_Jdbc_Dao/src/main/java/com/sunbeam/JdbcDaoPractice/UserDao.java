package com.sunbeam.JdbcDaoPractice;

import java.util.List;

public interface UserDao extends AutoCloseable {

	User findById(int userId) throws Exception;
	List<User> findAll() throws Exception;
	User findByEmaii(String email) throws Exception;
	int save(User user) throws Exception;
	int update(User user)throws Exception;
	int changePassword(int userId, String password) throws Exception;
	int deleteById(int userId) throws Exception;
	
}
