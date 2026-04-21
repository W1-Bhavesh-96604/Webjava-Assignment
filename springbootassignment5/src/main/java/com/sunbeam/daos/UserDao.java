package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.User;

public interface UserDao {
	List<User> findAll();
	List<User> findById(int id);
	List<User> findByName(String name);
	int addUser(User user);
	int updateUser(User user);
	int updateAddress(String newAddr, int id);
	int deleteById(int id);
}
