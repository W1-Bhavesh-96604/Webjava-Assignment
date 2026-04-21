package com.sunbeam.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.dtos.UserDto;
import com.sunbeam.entities.User;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ModelMapper modelMapper;
    
    public List<UserDto> getAllUser() {
        List<User> entities = userDao.getAllUser();
        List<UserDto> dtos = new ArrayList<>();
        for (User user : entities) {
            dtos.add(modelMapper.map(user, UserDto.class));
        }
        return dtos;
    }
    
    public int addUser(UserDto userDto) {
        User userEntity = modelMapper.map(userDto, User.class);
        return userDao.addUser(userEntity); 
    }
    
    public int updateUserInfo(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return userDao.updateUserInfo(user);
    }

    public int changePassword(int id, String newPassword) {
        return userDao.changePassword(id, newPassword);
    }

    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
