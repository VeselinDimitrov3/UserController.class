package com.example.New.user.project.entity.controller;

import com.example.New.user.project.entity.User;
import com.example.New.user.project.entity.controller.service.UserNotFoundException;
import com.example.New.user.project.entity.controller.service.UserService;
import com.example.New.user.project.entity.model.UserRequest;
import com.example.New.user.project.entity.repositories.AddressRepository;
import com.example.New.user.project.entity.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.Instant;
import java.util.Optional;


@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String sayHello () {
        return "Hello from User";

    }
//    , @RequestParam String first_name
    @GetMapping(path = "/{id}")
    public User getUser (@PathVariable Long id) throws UserNotFoundException {
        return this.userService.findById(id);

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/add")
     public User saveUser (@Valid @RequestBody UserRequest userRequest) {

        User user = userRequest.convert();

        return userService.saveUsers(user);
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser (@PathVariable Long id) {
        this.userService.deleteById(id);
        return String.format("User with this id is deleted", id);
    }

}
