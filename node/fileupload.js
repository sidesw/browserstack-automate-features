var webdriver = require('selenium-webdriver');

var capabilities = {
  'os' : 'Windows',
  'os_version' : '7',
  'browser' : 'firefox',
  'browserstack.user' : 'BS_USERNAME',
  'browserstack.key' : 'BS_AUTHKEY',
}

var driver = new webdriver.Builder().
  usingServer('http://hub.browserstack.com/wd/hub').
  withCapabilities(capabilities).
  build();

driver.get('http://www.fileconvoy.com/');
driver.findElement(webdriver.By.id('upfile_0')).sendKeys('C:\\Users\\hello\\url.txt');
driver.findElement(webdriver.By.id('readTermsOfUse')).click();
driver.findElement(webdriver.By.name('form_upload')).submit();

driver.sleep(5000).then(function() {
        driver.findElement(webdriver.By.tagName('center')).getText().then(function(text) {
            console.log(text);
            });
        });

driver.quit();
