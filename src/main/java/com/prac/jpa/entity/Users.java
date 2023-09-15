package com.prac.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity //@Entity가 붙은 클래스는 JPA가 관리하는 객체
@Getter
@Setter
@Builder
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String username;

    // @Builder
    // public Users(long ID, String username){
    //     this.ID = ID;
    //     this.username = username;
    // }
    // 위와같이 빌더패턴을 사용하면 빌더객체를 계속 생성하기에 원하는 값을 가져오기 위하여 편리하게 사용할 수 있다.

}
