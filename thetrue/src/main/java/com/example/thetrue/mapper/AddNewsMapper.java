package com.example.thetrue.mapper;

import com.example.thetrue.entity.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddNewsMapper {
    @Insert("INSERT INTO news(userid, keyword, newstitle, description, URL) VALUES(#{userid}, #{keyword}, #{newstitle}, #{description}, #{URL})")
    void insert (News news);
    @Select("SELECT COUNT(1) FROM news WHERE userid = #{userid} AND newstitle = #{newstitle}")
    int countByUserIDAndTitle(int userid,String news_title);

    @Select("SELECT * FROM news  WHERE userid=#{userid} AND keyword=#{keyword} ORDER BY newsid desc LIMIT 3")
    List<News> showTheNews(int userid,String keyword);
}
