#!/usr/bin/env ruby

require 'rubygems'
require 'selenium-webdriver'

driver = Selenium::WebDriver.for(:remote,
  :url => "http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub", 
  :desired_capabilities => Selenium::WebDriver::Remote::Capabilities.firefox)

driver.navigate.to "http://www.google.com"
element = driver.find_element(:name, 'q')
element.send_keys "BrowserStack"
element.submit
driver.save_screenshot("screenshot.png")
puts "Screenshot saved to screenshot.png"
driver.quit
