package com.prac.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.jpa.entity.Users;
import com.prac.jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    @Autowired(required=true)
    private final UserRepository userRepository;

    public String createUserService(Users user){
         userRepository.save(user); // User Insert 쿼리 수행
         return "등록 완료";
    }

    public List<Users> getUserService(String name){
        if(name.isBlank()) // name 파라미터가 Null이면 전체 user를 리턴
            return userRepository.findAll();
        else  // name 이 존재를 하면, Like 쿼리로 2개만 리턴
            return userRepository.findFirst2ByUsernameLikeOrderByIdDesc(name);
    }

    public List<Users> updateUsersService(String name){
        if(name.isBlank()) // name 파라미터가 Null이면 전체 user를 리턴
            return userRepository.findAll();
        else  // name 이 존재를 하면, Like 쿼리로 2개만 리턴
            return userRepository.findFirst2ByUsernameLikeOrderByIdDesc(name);
    }

}