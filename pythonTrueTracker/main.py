from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome("./chromedriver.exe")
driver.get("https://news.google.com/")



input = driver.find_element(By.CSS_SELECTOR,".Ax4B8.ZAGvjd")
input.send_keys("天氣")
try:
    close_popup = driver.find_element(By.XPATH, '//button[@aria-label="保持登出狀態"]')
    close_popup.click()
except:
    pass

search = driver.find_element(By.CSS_SELECTOR,".gb_ze")
# CSS_SELECTOR中，class使用.,id使用#
search.click()


newlists = driver.find_elements(By.CSS_SELECTOR,".lBwEZb BL5WZb GndZbb div")
for new in newlists:
    print(new.find_element(By.CSS_SELECTOR,"a").get_attribute("href"))
# driver.sleep(10)
# driver.quit()
# KEY = a9e8c1753e4849bda2e3885a44f22e73