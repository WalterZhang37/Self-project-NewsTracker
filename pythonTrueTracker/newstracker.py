import requests
import time
import pymysql
import sys
import os
connection = pymysql.connect(
    host='localhost',
    user='root',
    password='123456',
    database='userdata'
)

API_KEY = 'a9e8c1753e4849bda2e3885a44f22e73'

stop_file = "stop_crawler.txt"

def should_stop():
    return os.path.exists(stop_file)

def fetch_news(id,keyword):
    ENDPOINT_SOURCES = "https://newsapi.org/v2/everything?q={}&language=zh&pageSize=3&sortBy=publishedAt&apiKey={}".format(keyword, API_KEY)
    response = requests.get(ENDPOINT_SOURCES)
    data = response.json()
    news_list = []
    if data['status'] == 'ok':
        for article in data['articles']:
            news_item = {
                "id": id,
                "keyword": keyword,
                "title": article['title'],
                "description": article['description'],
                "article_url": article['url'],
            }
            news_list.append(news_item)
            # title = article['title']
            # description = article['description']
            # article_url = article['url']
            # newsimage_url = article['urlToImage']
            # news_list.append((id, keyword, title, description, article_url, newsimage_url))
            # 打印或保存提取到的信息
            print("Title:", news_item['title'])
            print("Description:", news_item['description'])
            print("URL:", news_item['article_url'])
            print("-----------------------------")
        return news_list
    else:
        print("Error:", data['message'])


# 判斷新聞是否重複出現，用新聞標題來判斷
def news_exists(id,title):
    with connection.cursor() as cursor:
        sql = "SELECT 1 FROM News WHERE user_id = %s AND news_title = %s LIMIT 1"
        cursor.execute(sql, (id,title,))
        result = cursor.fetchone()
        return result is not None

def save_to_sql(news_item):
    with connection.cursor() as cursor:
        sql = "INSERT INTO News (user_id, keyword, news_title, description, URL)" \
              "VALUES (%s, %s, %s, %s, %s)"
        params = (news_item["id"], news_item["keyword"], news_item["title"], news_item["description"], news_item["article_url"])
        cursor.execute(sql, params)
        # cursor.execute(sql,news_item)
    connection.commit()
# def notify_springboot():
#     SPRINGBOOT_ENDPOINT = "http://localhost:8080/notify-updates"
#     requests.post(SPRINGBOOT_ENDPOINT)



# def send_to_springboot(news_list):
#     SPRINGBOOT_ENDPOINT = "http://localhost:8088/receive-news"
#     response = requests.post(SPRINGBOOT_ENDPOINT, json=news_list)
#     if response.status_code == 200:
#         print("Successfully sent news to Spring Boot!")
#     else:
#         print("Failed to send news to Spring Boot. Status code:", response.status_code)


id = int(sys.argv[1])
keyword = sys.argv[2]
time = sys.argv[3]
while not should_stop():
    news_list = fetch_news(id, keyword)
    for news_item in news_list:
        if not news_exists(news_item["id"], news_item["title"]):
            save_to_sql(news_item)
    time.sleep(int(time) * 60)
# news_list = fetch_news(id,keyword)
# # send_to_springboot(news_list)
# for news_item in news_list:
#     if not news_exists(news_item["id"],news_item["title"]):
#         save_to_sql(news_item)
