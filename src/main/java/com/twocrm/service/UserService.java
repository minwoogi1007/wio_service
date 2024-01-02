package com.twocrm.service;

import com.twocrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twocrm.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public boolean checkUserIdExists(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }
}