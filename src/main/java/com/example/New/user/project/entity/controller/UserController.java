package com.example.New.user.project.entity.controller;

import com.example.New.user.project.entity.User;
import com.example.New.user.project.entity.controller.service.UserService;
import com.example.New.user.project.entity.repositories.AddressRepository;
import com.example.New.user.project.entity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String sayHello () {
        return "Hello from User";

    }
    @GetMapping(path = "/{id}")
    public User getUser (@PathVariable Long id) {
        return this.userService.getById(id);
    }
    @PostMapping(path = "/add")
    public User createUser (@RequestBody User user) {
        return userService.saveUsers(user);


    }


}
