package com.jackson.controller;

import com.jackson.entity.User;
import com.jackson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> readAllUsers() {
        return userRepository.fetchALlUsers();
    }

//    @GetMapping("/users/{id}")
//    public List<User> getUserById(@PathVariable("id") long id){
//        return userRepository.findById(id).get();
//    }
}
