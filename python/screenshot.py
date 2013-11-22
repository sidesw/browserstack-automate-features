import os
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

desired_cap = {
    'browserName': 'FIREFOX',
    'javascriptEnabled': True,
    'platform': 'ANY',
    'version': '',
}

driver = webdriver.Remote(
	command_executor='http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub',
	desired_capabilities=desired_cap)

driver.get("http://www.google.com")
elem = driver.find_element_by_name("q")
elem.send_keys("BrowserStack")
elem.submit()
driver.get_screenshot_as_file(os.getcwd() + '/screenshot.png')
print('Screenshot saved to screenshot.png')
driver.quit()
