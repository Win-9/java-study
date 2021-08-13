package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
        User user1=new User("Baek","Baek@naver.com");
        User user2=new User("Choi","Choi@naver.com");
        userRepository.saveAll(Lists.newArrayList(user1,user2));

        List<User> users=userRepository.findAll();
        users.forEach(System.out::println);
    }
}
