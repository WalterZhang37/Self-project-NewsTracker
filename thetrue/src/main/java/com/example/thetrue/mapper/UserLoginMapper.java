package com.example.thetrue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.thetrue.entity.UserLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserLoginMapper extends BaseMapper<UserLogin> {
    @Select("SELECT password from user WHERE username=#{username}")
    String Checkpassword(String username);

    @Insert("INSERT INTO user (username,password) VALUES(#{username},#{password})")
    void save(UserLogin user);

    @Select("SELECT id from user WHERE username=#{username}")
    String getId(String username);
}
