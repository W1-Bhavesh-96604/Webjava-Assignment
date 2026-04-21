package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.User;
import com.sunbeam.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public List<User> findById(@PathVariable int id){
		return userService.findById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<User> findByName(@PathVariable String name){
		return userService.findByName(name);
	}
	
	@PostMapping("/details")
	public int addUser(@RequestBody User user) {
		int cnt = userService.addUser(user);
		return cnt;
	}
	
	@PutMapping("/update")
	public int updateUser(@RequestBody User user) {
		int cnt = userService.updateUser(user);
		return cnt;
	}
	
	@PutMapping("/updateAddr/{id}/{newAddr}")
	public int updateAddr(@PathVariable String newAddr, @PathVariable int id) {
		int cnt = userService.updateAddr(newAddr, id);
		return cnt;
	}
	
	@DeleteMapping("/delete/{id}")
	public int deleteById(@PathVariable int id) {
		int cnt = userService.deleteById(id);
		return cnt;
	}
}
