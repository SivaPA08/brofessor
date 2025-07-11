package com.siva.auth_service.controller;

import java.util.Map;
import java.util.UUID;

import com.siva.auth_service.Entity.User;
import com.siva.auth_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Control {


    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody Map<String,String> data){
        String username=data.get("username");
        String password=data.get("password");

        if(username==null || password==null){
            return ResponseEntity.badRequest().body(Map.of("message","Invalid username or password"));
        }

        if(userService.usernameExists(username)) {
            ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(Map.of("message","Username already exists"));
        }

        User newUser=new User();
        newUser.setusername(username);
        newUser.setpassword(password);
        newUser.setsecurekey(UUID.randomUUID().toString());
        userService.savUser(newUser);
        return ResponseEntity.ok(Map.of("message", "done"));

    }
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> data){
        String username=data.get("username");
        String password=data.get("password");
        if(username==null || password==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message","Invalid username or password"));
        }
        if(!userService.usernameExists(username) && userService.getPassword(username).equals(password)){
            return ResponseEntity.ok(Map.of("message","login success"));
        }

        return ResponseEntity.badRequest().body(Map.of("message","Error"));
    }
}
