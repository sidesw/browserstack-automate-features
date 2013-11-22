#!/usr/bin/perl

use Selenium::Remote::Driver; 

my $login = "BS_USERNAME";
my $key = "BS_AUTHKEY";

my $host = "$login:$key\@hub.browserstack.com";
my $browser = "firefox";
my $os = "WIN8";

my $driver = new Selenium::Remote::Driver(
        'remote_server_addr' => $host,
        'port' => '80',
        'browser_name' => $browser,
        'platform' => $os);

$driver->get('http://www.fileconvoy.com/');
$driver->find_element('upfile_0','id')->send_keys("C:\\Users\\hello\\url.txt");
$driver->find_element('readTermsOfUse','id')->click();
$driver->find_element('form_upload','name')->submit();

sleep(5);

print $driver->find_element('center','tag_name')->get_text() . "\n";

$driver->quit();
