package com.example.bookmanager.controller;

import com.example.bookmanager.Repository.UserRepository;
import com.example.bookmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/hello_world")
    public String helloWorld(
            @RequestParam String name,
            @RequestParam String email){

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userRepository.save(user);

        userRepository.findAll().forEach(
                u -> System.out.println(u.toString())
        );

        return "helloWorld";
    }
}
