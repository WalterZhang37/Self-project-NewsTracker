package com.example.thetrue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.thetrue.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

import java.io.Serial;
@Mapper
public interface UserMapper extends BaseMapper<User> {
//    查詢用戶的追蹤記錄
    @Select("select * from user where id=#{id}")
    User selectById(int id);
    @Select("select * from user")
    @Results({
//            column=db中的字段，property=類中的字段
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "id",property = "orders",javaType = List.class,
                    many = @Many(select = "com.example.thetrue.mapper.OrderMapper.selectByUid"))
//          上行會將column=“id”傳給OrderMapper中的selectByUid這個方法（傳遞參數），並將訂單賦值給order屬性
    })
    List<User> selectAllUserAndOrders();
//    寫一個User類給plus會自動根據類找到user表並進行操作,因此以下的操作就省略了
//    @Select("select * from user")
////    此處的Select會去自動尋找properties中mydb進而查詢所有用戶，並自動把所有data放在list中
//    public List<User> find();
//
//    @Insert("insert into user values (#{id},#{username},#{password})")
//    public int insert(User user);
//
//    @Delete("delete from user where id=#{id}")
//    public int delete(int id);
// 以上為mybatis需要的寫法，升級為plus後簡化

}
