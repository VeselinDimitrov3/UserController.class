package com.example.New.user.project.entity.controller;

import com.example.New.user.project.entity.User;
import com.example.New.user.project.entity.repositories.AddressRepository;
import com.example.New.user.project.entity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@RequestMapping(path = "/users")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public String sayHello () {
        return "Hello from User";
    }
    @GetMapping("/get/{id}")
    public User getUser (@PathVariable Long id) {
        return userRepository.findById(id).get();
    }


}
