<?php
  require "php-webdriver/lib/__init__.php";
  
  $web_driver = new RemoteWebDriver(
    "http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub", 
    array("platform"=>"WINDOWS", "browserName"=>"firefox")
  );
  $web_driver->get("http://google.com");
  print $web_driver->getTitle();

  $element = $web_driver->findElement(WebDriverBy::name("q"));
  if($element) {
    $element->sendKeys("BrowserStack");
    $element->submit();
  }
  $web_driver->takeScreenshot("screenshot.png");
  print "Srceenshot saved to screenshot.png\n";
  $web_driver->quit();
?>
