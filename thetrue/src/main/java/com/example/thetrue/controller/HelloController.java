package com.example.thetrue.controller;

import com.example.thetrue.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

//    http://www.google.com/s/xx 協議+域名+路徑
//    本地運行：http://localhost:8080/hello 因為tomcat會默認在8080
//    @GetMapping("/hello")
//  代表browser會發送一個Get請求來訪問這個方法,並且訪問這個方法需要一個明確的鏈接地址，就是hello
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
//  @GetMappint("/hello")
//    http://localhost:8080/hello?nickname=zhangsan參數傳遞
    public String hello(String nickname,String time){
        return "HI" + nickname + time;
    }
    @RequestMapping(value = "/getTest",method = RequestMethod.GET)
    public String getTest(String cato,String hours,String title){
        return cato + "+" +hours+ "+" +title;
    }
    @RequestMapping(value="/getTest2",method = RequestMethod.GET)
    public String getTest2(@RequestParam("nickname")String name){
        return name;
//requestParam的使用：作為映射，將nickname映射為name，當使用requestparam時，nickname就變成必須條件
    }
    @RequestMapping(value="/postTest1",method = RequestMethod.POST)
    public String postTest1(String hours,String title){
        System.out.println(hours);
        System.out.println(title);
        return "post success";
    }
    @RequestMapping(value="/postTest2",method = RequestMethod.POST)
    public String postTest2(User ok){
        System.out.println(ok);
        return "post success";
    }
    @RequestMapping(value="/postTest3",method = RequestMethod.POST)
    public String postTest3(@RequestBody User ok){
//        Body：用於接受Json格式
        System.out.println(ok);
        return "post success";
    }
    @GetMapping("/test/**")
    public String test(){
        return "通配符";
    }
}
