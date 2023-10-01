package com.example.thetrue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.thetrue.entity.Topic;
import com.example.thetrue.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper extends BaseMapper<Topic> {
    @Select("select * from newstopics where uid=#{uid}")
    List<Topic> selectByUid(int uid);
    @Select("select * from newstopics")
    @Results({
            @Result(column = "TopicID",property = "TopicID"),
            @Result(column = "TopicName",property = "TopicName"),
            @Result(column = "TopicDescription",property = "TopicDescription"),
            @Result(column = "Uid",property = "user",javaType = User.class,
                    one = @One(select = "com.example.thetrue.mapper.UserMapper.selectById"))
    })
    List<Topic> selectAllOrdersAndUser();
}
