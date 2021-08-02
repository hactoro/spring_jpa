package com.example.bookmanager.domain;

import com.example.bookmanager.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest extends Object {
    @Autowired
    UserRepository userRepository;

    @Test
    void test(){
        User user = new User();
        user.setEmail("hactoro@nate.com");
        user.setName("hsd");

        userRepository.save(user);

        System.out.println("-------Test------");
        userRepository.findAll().forEach(
                u -> System.out.println(u.toString())
        );

        System.out.println(">>>" + user);
    }


}