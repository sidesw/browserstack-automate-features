using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Firefox;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            DesiredCapabilities capabilities = DesiredCapabilities.Firefox();
            capabilities.SetCapability("browserstack.user", "BS_USERNAME");
            capabilities.SetCapability("browserstack.key", "BS_AUTHKEY");
            capabilities.SetCapability("browserstack.debug", "true");

            FirefoxProfile profile = new FirefoxProfile();
            profile.SetPreference("browser.download.folderList", 0);
            profile.SetPreference("browser.download.manager.showWhenStarting", false);
            profile.SetPreference("browser.download.manager.focusWhenStarting", false);
            profile.SetPreference("browser.download.useDownloadDir", true);
            profile.SetPreference("browser.helperApps.alwaysAsk.force", false);
            profile.SetPreference("browser.download.manager.alertOnEXEOpen", false);
            profile.SetPreference("browser.download.manager.closeWhenDone", true);
            profile.SetPreference("browser.download.manager.showAlertOnComplete", false);
            profile.SetPreference("browser.download.manager.useWindow", false);
            profile.SetPreference("browser.helperApps.neverAsk.saveToDisk", "application/java-archive,application/x-compressed");

            capabilities.SetCapability(FirefoxDriver.ProfileCapabilityName, profile);

            IWebDriver driver = new RemoteWebDriver(new Uri("http://hub.browserstack.com/wd/hub/"), capabilities);

            driver.Navigate().GoToUrl("http://www.browserstack.com/BrowserStackTunnel.jar");

            System.Threading.Thread.Sleep(3000);

            driver.Quit();
        }
    }
}

