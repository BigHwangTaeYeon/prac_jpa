package com.prac.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prac.jpa.entity.Users;
import com.prac.jpa.repository.UserRepository;
import com.prac.jpa.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    private final UserRepository userRepository;
    
    @PostMapping(value = "/createUser")
    public String createUser(@RequestBody Users user){
        return userService.createUserService(user);
    }

    @GetMapping(value = "/getUser")
    public List<Users> getUser( @RequestParam(required = false, defaultValue = "") String name ){
        return userService.getUserService( name );
    }

    @GetMapping(value = "/updateUsers")
    public String updateUsers( @RequestParam(required = false, defaultValue = "") long id){
        String name;
        if(userRepository.findById(id).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + id + "이 존재하지 않습니다";
        } else {
            Optional<Users> getName = userRepository.findById(id);
            name = getName.get().getUsername();
            userRepository.save(Users.builder().username(name).ID(id).build());
            return name + "의 이름을 " + name + "로 변경 완료";
        }
        return userService.updateUsersService( name );
    }

    @PostMapping(value = "/deleteUser")
    public String deleteUser(@RequestBody Users user, @RequestParam(value = "name") String name){
        if(userRepository.findById(name).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + name + "이 존재하지 않습니다";
        } else {
            userRepository.delete(CrudEntity entity = CrudEntity.builder().name(name).build());
            return name + " 삭제 완료";
        }
        return userService.deleteUserService(user);
    }
}
