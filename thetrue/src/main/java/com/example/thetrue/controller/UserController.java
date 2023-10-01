package com.example.thetrue.controller;

import com.example.thetrue.entity.User;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        System.out.println(id);
        return "根據ID獲取用戶信息";
    }
    @PostMapping("/user")
    public String save(User user){
        return "添加用戶";
    }
    @PutMapping("/user")
    public String update(User user){
        return "更新用戶";
    }
    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id){
        System.out.println(id);
        return "刪除用戶";
    }
}
