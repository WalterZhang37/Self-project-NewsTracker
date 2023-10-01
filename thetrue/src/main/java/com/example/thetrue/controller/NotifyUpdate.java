package com.example.thetrue.controller;

import com.example.thetrue.entity.News;
import com.example.thetrue.mapper.AddNewsMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class NotifyUpdate {
    @Resource
    private AddNewsMapper addNewsMapper;
    @Transactional
    public ResponseEntity<List<News>> shownews(int userid, String keyword) {
        List<News> newsList = addNewsMapper.showTheNews(userid, keyword);
        return ResponseEntity.ok(newsList);
    }
    Process pythonProcess;
    /*@Transactional
    public void saveNews(News news) {
        int count = addNewsMapper.countByUserIDAndTitle(news.getUser_id(), news.getNews_title());
        if(count == 0) {
            addNewsMapper.insert(news);
        }
    }*/
    String readFromInputStream(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }
        return result.toString();
    }

    @PostMapping("/start-crawler")
    public ResponseEntity<List<News>> startCrawler(@RequestBody Map<String, String> params) throws InterruptedException, IOException {
        String id = params.get("id");
        String keyword = params.get("keyword");
        String time = params.get("time");
        int idInt = Integer.parseInt(id);
        File stopFile = new File("stop_crawler.txt");
        if (stopFile.exists()) {
            stopFile.delete();
        }
        ProcessBuilder processBuilder = new ProcessBuilder("C:\\Users\\user\\anaconda3\\python.exe","newstracker.py",id,keyword,time);
        try{
//            Process process = processBuilder.start();
//            process.waitFor();
            pythonProcess = processBuilder.start();
            return shownews(idInt, keyword);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PostMapping("/stop-crawler")
    public ResponseEntity<String> stopCrawler() {
        File stopFile = new File("stop_crawler.txt");
        try {
            stopFile.createNewFile();
            if (pythonProcess != null) {
                pythonProcess.destroy();
            }
            return ResponseEntity.ok("Crawler stopped");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error stopping crawler");
        }
    }
//    @PostMapping("/receive-news")
//    public ResponseEntity<String> handleReceivedNews(@RequestBody List<Map<String, Object>> newsList) {
//        int userId = Integer.parseInt((String) newsList.get(0).get("id"));
//        for(Map<String,Object> newsItem : newsList){
//            News news = new News();
//            news.setUser_id(Integer.parseInt((String) newsItem.get("id")));
//            news.setKeyword((String) newsItem.get("keyword"));
//            news.setNews_title((String) newsItem.get("title"));
//            news.setDescription((String) newsItem.get("description"));
//            news.setURL((String) newsItem.get("article_url"));
////            news.setNewsimage_url((String) newsItem.get("newsimage_url"));
//
//            saveNews(news);
//
//
//        }
////        shownews(userId);
//
//        return ResponseEntity.ok("News received and processed");
//
//
//    }


}
