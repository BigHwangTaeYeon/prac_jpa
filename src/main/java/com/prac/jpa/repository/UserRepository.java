package com.prac.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prac.jpa.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    
    List<Users> findFirst2ByUsernameLikeOrderByIdDesc(String name);

    Optional<Users> findAllById(Long id);
    
    List<Users> findAll();

    //void deleteAllByIdInBatch(Long id);

}
