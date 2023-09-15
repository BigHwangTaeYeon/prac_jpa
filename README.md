# 230912 오류

1.
    .vscode > launch.json
    파일이 없었으며, main method를 찾는다는 오류가 생김
    default로 C드라이브에서 JpaApplication.java의 경로를 찾고 있었고,
    "mainClass": "com.prac.jpa.JpaApplication" 이렇게 경로를 수정해주니 문제 해결.

2.
    계속 빌드 오류가 떠서 보니 자바와 부트 버전이 안맞아서 그렇다.
    1) 자바는 18로 세팅해둬서 부트와 그래들을 확인했다.
    2) 그래들 8.2.1에서 7.6.1로, 부트는 3.0에서 2.7로 변경하였다.
    java 18, boot 2.x, gradle 7.6.1
    plugins {
        id 'java'
        id 'org.springframework.boot' version '2.7.4'
        id 'io.spring.dependency-management' version '1.0.14.RELEASE'
    }

# 230915 정리

@Builder
public Users(long ID, String username){
    this.ID = ID;
    this.username = username;
}
위와같이 빌더패턴을 사용하면 빌더객체를 계속 생성하기에 원하는 값을 가져오기 위하여 편리하게 사용할 수 있다.

@Entity //@Entity가 붙은 클래스는 JPA가 관리하는 객체