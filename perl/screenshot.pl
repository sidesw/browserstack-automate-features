#!/usr/bin/perl

use Selenium::Remote::Driver; 
require MIME::Base64;
my $login = "BS_USERNAME";
my $key = "BS_AUTHKEY";

my $host = "$login:$key\@hub.browserstack.com";
my $browser = "firefox";
my $platform = "MAC";

my $driver = new Selenium::Remote::Driver(
        'remote_server_addr' => $host,
        'port' => '80',
        'browser_name' => $browser,
        'platform' => $platform
        );

$driver->get('http://www.google.com');
$driver->find_element('q','name')->send_keys("BrowserStack");
$driver->find_element('btnG','name')->submit();

open(FH,'>','screenshot.png');
binmode FH;
my $png_base64 = $driver->screenshot();
print FH MIME::Base64::decode_base64($png_base64);
close FH;
print "Screenshot saved to screenshot.png\n";

$driver->quit();
