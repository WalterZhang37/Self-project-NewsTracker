package com.example.thetrue.controller;

import com.example.thetrue.entity.Topic;
import com.example.thetrue.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private OrderMapper orderMapper;
    @GetMapping("/order/getAll")
    public List<Topic> find(){
        List orders = orderMapper.selectAllOrdersAndUser();
        return orders;
    }
}
