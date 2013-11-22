#!/usr/bin/env ruby

require 'rubygems'
require 'selenium-webdriver'

profile = Selenium::WebDriver::Firefox::Profile.new
profile['browser.download.folderList'] = 0
profile['browser.download.manager.showWhenStarting'] = false
profile['browser.download.manager.focusWhenStarting'] = false
profile['browser.download.useDownloadDir'] = true
profile['browser.helperApps.alwaysAsk.force'] = false
profile['browser.download.manager.alertOnEXEOpen'] = false
profile['browser.download.manager.closeWhenDone'] = true
profile['browser.download.manager.showAlertOnComplete'] = false
profile['browser.download.manager.useWindow'] = false
profile['browser.helperApps.neverAsk.saveToDisk'] = "application/java-archive,application/x-compressed"

capabilities = Selenium::WebDriver::Remote::Capabilities.firefox(:firefox_profile => profile)
capabilities['browserstack.debug'] = "true"

driver = Selenium::WebDriver.for(:remote,
  :url => "http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub", 
  :desired_capabilities => capabilities)

driver.navigate.to "http://www.browserstack.com/BrowserStackTunnel.jar"
sleep(5)
driver.quit

