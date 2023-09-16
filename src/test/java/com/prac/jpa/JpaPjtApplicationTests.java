package com.prac.jpa;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.prac.jpa.entity.Users;
import com.prac.jpa.repository.UserRepository;
import com.prac.jpa.service.UserService;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Slf4j
public class JpaPjtApplicationTests {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserService userService;

    @BeforeEach
    void insertTestData() {
        // Users user = new Users();
        Users user = Users.builder().build();
        user.setUsername("kim ori");
        user.setId(01);
        userRepository.save(user);
        
        user = Users.builder().username("lee ori").id(02).build();
        userRepository.save(user);

        userService.updateUsersService("kim ori");
        
        user = Users.builder().build();
        user.setUsername("park ental");
        user.setId(03);
        userRepository.save(user);
        
        user = Users.builder().build();
        user.setUsername("sue ental");
        user.setId(04);
        userRepository.save(user);
        
        user = Users.builder().build();
        user.setUsername("hwang samuel");
        user.setId(05);
        userRepository.save(user);

        userRepository.delete(Users.builder().id(04).build());

    }

        @Test
        void findAllTest() {
            List<Users> userList = userRepository.findAll();
            for(Users u : userList) log.info("[FindAll] : " + u.getId() + " | " + u.getUsername());
        }

        @Test
        void find2ByNameTest() {
            List<Users> userList = userRepository.findFirst2ByUsernameLikeOrderByIdDesc("kim%");
            for(Users u : userList) log.info("[FindSome] : " + u.getId() + " | " + u.getUsername());
        }

}
