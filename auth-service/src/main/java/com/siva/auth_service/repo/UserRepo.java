package com.siva.auth_service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.auth_service.Entity.User;


public interface UserRepo extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username) ;
}
