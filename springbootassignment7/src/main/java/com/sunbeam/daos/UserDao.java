package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.User;

public interface UserDao {
    List<User> getAllUser();
    int addUser(User user);
    int updateUserInfo(User user);
    int changePassword(int id, String newPassword);
    int deleteUser(int id);
}

