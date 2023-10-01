package com.example.thetrue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.core.annotation.Order;

import java.util.List;

//@TableName("xxx")使用 這個注釋會讓這個類別自動去尋找這個表名並且進行操作
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
//    加入上行後，插入data的時候，這個用戶對象裡面就會這個主鍵打印出來（主鍵回顯）
//    @TableField解決類別和DB中字段屬性名稱不對應的問題
    private int id;
    private String username;
    private String password;
    //    描述用戶的訂單
    @TableField(exist = false)
    private List<Order> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                '}';
    }
}