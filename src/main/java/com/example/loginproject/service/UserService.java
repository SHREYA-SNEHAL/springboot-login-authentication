package com.example.loginproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginproject.entity.User;
import com.example.loginproject.repository.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        return userRepository.save(user);
    }

}
