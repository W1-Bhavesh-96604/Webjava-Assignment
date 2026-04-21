package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.UserDto;
import com.sunbeam.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserDto> getAllUsers(){
		List<UserDto> list = userService.getAllUser();
		return list;
	}
	
	@PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        int result = userService.addUser(userDto);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add user");
        }
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<String> updateUserInfo(@PathVariable int id, @RequestBody UserDto userDto) {
        userDto.setId(id); 
        int count = userService.updateUserInfo(userDto);
        return count > 0 ? ResponseEntity.ok("User info updated successfully") 
                         : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    
    @PatchMapping("/{id}/password")
    public ResponseEntity<String> changePassword(@PathVariable int id, @RequestParam String newPassword) {
        int count = userService.changePassword(id, newPassword);
        return count > 0 ? ResponseEntity.ok("Password updated successfully") 
                         : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        int count = userService.deleteUser(id);
        return count > 0 ? ResponseEntity.ok("User deleted successfully") 
                         : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
