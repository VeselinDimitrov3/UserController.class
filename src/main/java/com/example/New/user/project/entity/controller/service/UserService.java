package com.example.New.user.project.entity.controller.service;

import com.example.New.user.project.entity.User;
import com.example.New.user.project.entity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUsers (User user) {
        return this.userRepository.save(user);
    }
    public User getById (Long id) {
        return this.userRepository.findById(id).get();
    }

}
