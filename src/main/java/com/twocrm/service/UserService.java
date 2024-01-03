package com.twocrm.service;

import com.twocrm.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public boolean authenticate(String username, String password) {
        return userMapper.countUserByUsernameAndPassword(username, password) > 0;
    }
}