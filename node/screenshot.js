var webdriver = require('selenium-webdriver');
var fs = require("fs");

var capabilities = {
  'browserName' : 'firefox',
  'browserstack.user' : 'BS_USERNAME',
  'browserstack.key' : 'BS_AUTHKEY',
  'browserstack.debug' : 'true'
}

var driver = new webdriver.Builder().
  usingServer('http://hub.browserstack.com/wd/hub').
  withCapabilities(capabilities).
  build();

driver.get('http://www.google.com');
driver.findElement(webdriver.By.name('q')).sendKeys('BrowserStack');
driver.findElement(webdriver.By.name('btnG')).click();

driver.takeScreenshot().then(function(pngB64) {
  var buf = new Buffer(pngB64, 'base64');
  fs.writeFile('screenshot.png', buf, function(err) {
    if(err) throw err;
    console.log('Screenshot saved to screenshot.png');
  });
});

driver.quit();

