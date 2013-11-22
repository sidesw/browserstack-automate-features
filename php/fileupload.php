<?php
  require "php-webdriver/lib/__init__.php";
  
  $web_driver = new RemoteWebDriver(
    "http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub", 
    array("platform"=>"WIN8", "browserName"=>"firefox")
  );
  $web_driver->get("http://www.fileconvoy.com/");

  $web_driver->findElement(WebDriverBy::id("upfile_0"))->sendKeys("C:\\Users\\hello\\url.txt");
  $web_driver->findElement(WebDriverBy::id("readTermsOfUse"))->click();
  $web_driver->findElement(WebDriverBy::name("form_upload"))->submit();
  sleep(5);
  print $web_driver->findElement(WebDriverBy::tagName("center"))->getText() . "\n";
  $web_driver->quit();
?>
