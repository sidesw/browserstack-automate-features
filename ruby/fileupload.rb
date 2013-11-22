#!/usr/bin/env ruby

require 'rubygems'
require 'selenium-webdriver'

capabilities = Selenium::WebDriver::Remote::Capabilities.new
capabilities['os'] = 'Windows'
capabilities['os_version'] = '7'
capabilities['browser'] = 'firefox'

driver = Selenium::WebDriver.for(:remote,
  :url => "http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub", 
  :desired_capabilities => capabilities)

driver.navigate.to "http://www.fileconvoy.com/"
driver.find_element(:id, "upfile_0").send_keys("C:\\Users\\hello\\url.txt")
driver.find_element(:id, "readTermsOfUse").click
driver.find_element(:name, "form_upload").submit
sleep(5)
puts driver.find_element(:tag_name, "center").text
driver.quit
