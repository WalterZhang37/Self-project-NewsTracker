package com.example.thetrue.controller;

import com.example.thetrue.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.thetrue.entity.UserLogin;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {
    @Autowired
    private UserLoginMapper userLoginMapper;
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody UserLogin user){
        String storedPassword = userLoginMapper.Checkpassword(user.getUsername());
        if(storedPassword!=null && storedPassword.equals(user.getPassword())){
            String userId = userLoginMapper.getId(user.getUsername());
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Login successful!");
            responseBody.put("userId", userId);
            return ResponseEntity.ok(responseBody);
        }else{
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Invalid username or password!");
            return ResponseEntity.badRequest().body(responseBody);
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<String> SignupUser(@RequestBody UserLogin user){
        String storedPassword = userLoginMapper.Checkpassword(user.getUsername());
        if(storedPassword!=null){
            return ResponseEntity.badRequest().body("Username already exists!");
        }else{
            userLoginMapper.save(user);
            return ResponseEntity.ok("Signup succussful!");
        }
    }
}
