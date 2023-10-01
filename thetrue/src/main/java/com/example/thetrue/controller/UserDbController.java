package com.example.thetrue.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.thetrue.entity.Topic;
import com.example.thetrue.entity.User;
import com.example.thetrue.mapper.OrderMapper;
import com.example.thetrue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@CrossOrigin
public class UserDbController {
    @Autowired
//       Autowired：spring功能，意思是自動將實例化的對象進行注入userMapper
    UserMapper userMapper;

    @GetMapping("/userdb/getall")
    public List<User> find(){
        return userMapper.selectAllUserAndOrders();
    }
//    @GetMapping("/userdb")
//    public List query(){
//
//        List<User> list = userMapper.selectList(null);
//        System.out.println(list);
//        return list;
//    }
    @PostMapping("/userdb")
    public String save(User user){
        int i = userMapper.insert(user);
        if (i>0){
            return "success";
        }else{
            return "fail";
        }
    }
    @GetMapping("/user/find")
    public List<User> findByCond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username","zhangbohan");
        return userMapper.selectList(queryWrapper);
    }
//    分頁查詢
    @GetMapping("/user/findpage")
    public IPage findByPage(){
//        從第幾條開始查，查幾條
        Page<User> page = new Page<>(0,2);
//        描述結果並封裝到ipage中
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }
//    @PostMapping("/userdbde")
//    public String delete(int id){
//        userMapper.delete(id);
//        return "success";
//    }
}
