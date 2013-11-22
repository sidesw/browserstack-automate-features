using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Remote;

namespace ConsoleApplication1
{
  class Program
  {
    static void Main(string[] args)
    {
      DesiredCapabilities capabilities = DesiredCapabilities.Firefox();
      capabilities.SetCapability("os", "windows");
      capabilities.SetCapability("os_version", "8");
      capabilities.SetCapability("browserstack.user", "BS_USERNAME");
      capabilities.SetCapability("browserstack.key", "BS_AUTHKEY");

      IWebDriver driver = new RemoteWebDriver(new Uri("http://hub.browserstack.com/wd/hub/"), capabilities);

      driver.Navigate().GoToUrl("http://www.fileconvoy.com/");

      driver.FindElement(By.Id("upfile_0")).SendKeys("C:\\Users\\hello\\url.txt");
      driver.FindElement(By.Id("readTermsOfUse")).Click();
      driver.FindElement(By.Name("form_upload")).Submit();

      Console.Out.WriteLine(driver.FindElement(By.TagName("center")).Text);

      driver.Quit();
    }
  }
}

