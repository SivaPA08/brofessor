package com.siva.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.siva.auth_service.Entity.User;
import com.siva.auth_service.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Cacheable(cacheNames = "userExists",key = "#username")
    public boolean usernameExists(String username){
        return userRepo.existsByUsername(username);
    }
    @Cacheable(cacheNames = "usersByName",key = "#username")
    public User findByUsername(String username){
        return userRepo.findByUsername(username).orElse(null);
    }
    @CachePut(cacheNames = {"userExists","usersByName"},key = "#user.username")
    public User savUser(User user){
        return userRepo.save(user);
    }
    public String getPassword(String username){
        User user=findByUsername(username);
        return (user!=null ?user.getPassword():null);
    }

}
