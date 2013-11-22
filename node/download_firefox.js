var webdriver = require('selenium-webdriver');
var FirefoxProfile = require('firefox-profile');

var profile = new FirefoxProfile();
profile.setPreference("browser.download.folderList", 0);
profile.setPreference("browser.download.manager.showWhenStarting", false);
profile.setPreference("browser.download.manager.focusWhenStarting", false);
profile.setPreference("browser.download.useDownloadDir", true);
profile.setPreference("browser.helperApps.alwaysAsk.force", false);
profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
profile.setPreference("browser.download.manager.closeWhenDone", true);
profile.setPreference("browser.download.manager.showAlertOnComplete", false);
profile.setPreference("browser.download.manager.useWindow", false);
profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/java-archive,application/x-compressed");

var capabilities = new webdriver.Capabilities();
capabilities.set('browserName', 'firefox');
capabilities.set('browserstack.user', 'BS_USERNAME');
capabilities.set('browserstack.key', 'BS_AUTHKEY');
capabilities.set('browserstack.debug', 'true');

profile.encoded(function(encodedProfile) {
  capabilities.set('firefox_profile', encodedProfile);

  var driver = new webdriver.Builder().
    usingServer('http://hub.browserstack.com/wd/hub').
    withCapabilities(capabilities).
    build();

  driver.get('http://www.browserstack.com/BrowserStackTunnel.jar');

  driver.sleep(5000).then(function() {
    driver.quit();
  });
});
