package com.siva.api_test.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Control {
    @PostMapping("/hello")
    public ResponseEntity<Map<String,Object>> home(@RequestBody Map<String,String> data){
        return ResponseEntity.ok(Map.of("message","working bro"));
    }
}