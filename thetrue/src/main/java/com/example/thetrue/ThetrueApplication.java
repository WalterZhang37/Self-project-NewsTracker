//package com.example.thetrue;
//
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ThetrueApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ThetrueApplication.class, args);
//    }
//
//}
package com.example.thetrue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.thetrue.mapper")
//掃描mapper包
public class ThetrueApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThetrueApplication.class, args);
    }
}