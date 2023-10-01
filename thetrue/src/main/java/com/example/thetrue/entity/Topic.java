package com.example.thetrue.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;
@TableName("newstopics")
public class Topic {
    @TableId(type = IdType.AUTO)
    private int TopicID;
    private String TopicName;
    private String TopicDescription;
    @TableField(exist = false)
    private User user;
    public int getTopicID() {
        return TopicID;
    }

    public void setTopicID(int topicID) {
        TopicID = topicID;
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String topicName) {
        TopicName = topicName;
    }

    public String getTopicDescription() {
        return TopicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        TopicDescription = topicDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "TopicID=" + TopicID +
                ", TopicName='" + TopicName + '\'' +
                ", TopicDescription='" + TopicDescription + '\'' +
                ", user=" + user +
                '}';
    }
}
