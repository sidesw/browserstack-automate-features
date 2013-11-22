#!/usr/bin/perl

use Selenium::Remote::Driver; 

my $login = "BS_USERNAME";
my $key = "BS_AUTHKEY";

my $host = "$login:$key\@hub.browserstack.com";
my $browser = "firefox";

my $driver = new Selenium::Remote::Driver(
  'remote_server_addr' => $host,
  'port' => '80',
  'browser_name' => $browser,
  'extra_capabilities' => {
    'firefox_profile' => {
      'browser.download.folderList' => 0,
      'browser.download.manager.showWhenStarting' => 0,
      'browser.download.manager.focusWhenStarting' => 0,
      'browser.download.useDownloadDir' => 1,
      'browser.helperApps.alwaysAsk.force' => 0,
      'browser.download.manager.alertOnEXEOpen' => 0,
      'browser.download.manager.closeWhenDone' => 1,
      'browser.download.manager.showAlertOnComplete' => 0,
      'browser.download.manager.useWindow' => 0,
      'browser.helperApps.neverAsk.saveToDisk' => "application/java-archive,application/x-compressed"
    }
  }
);

$driver->get('http://www.browserstack.com/BrowserStackTunnel.jar');

sleep(5);

$driver->quit();
