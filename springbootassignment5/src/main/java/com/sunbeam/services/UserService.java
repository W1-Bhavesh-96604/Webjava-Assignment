package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public List<User> findById(int id){
		return userDao.findById(id);
	}
	
	public List<User> findByName(String name){
		return userDao.findByName(name);
	}
	
	public int addUser(User user) {
		return userDao.addUser(user);
	}
	
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	public int updateAddr(String newAddr, int id) {
		return userDao.updateAddress(newAddr, id);
	}
	
	public int deleteById(int id) {
		return userDao.deleteById(id);
	}
}
