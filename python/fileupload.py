import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

desired_cap = {
    'browserName': 'firefox',
    'javascriptEnabled': True,
    'platform': 'WIN8',
    'version': '', 
}

driver = webdriver.Remote(
	command_executor='http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub',
	desired_capabilities=desired_cap)

driver.get("http://www.fileconvoy.com/")
driver.find_element_by_id("upfile_0").send_keys("C:\\Users\\hello\\url.txt")
driver.find_element_by_id("readTermsOfUse").click()
driver.find_element_by_name("form_upload").submit()
time.sleep(5)
print(driver.find_element_by_tag_name("center").text)
driver.quit()

