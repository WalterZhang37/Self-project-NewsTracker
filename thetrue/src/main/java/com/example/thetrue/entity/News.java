package com.example.thetrue.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("news")
public class News {
    private int userid;
    private String keyword;
    private String newstitle;

    @Override
    public String toString() {
        return "News{" +
                "userid=" + userid +
                ", keyword='" + keyword + '\'' +
                ", newstitle='" + newstitle + '\'' +
                ", description='" + description + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    private String description;
    private String URL;
}