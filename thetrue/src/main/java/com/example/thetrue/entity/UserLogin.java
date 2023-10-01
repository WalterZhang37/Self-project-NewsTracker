package com.example.thetrue.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class UserLogin {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
