import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BsChromeDownloadTest {
  public static void main(String[] args) throws MalformedURLException, InterruptedException {
    DesiredCapabilities capability = DesiredCapabilities.chrome();
    capability.setCapability("browserstack.debug", "true");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("disable-improved-download-protection");

    capability.setCapability(ChromeOptions.CAPABILITY, options);

    WebDriver driver = new RemoteWebDriver(
        new URL("http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub"),
        capability);

    driver.get("http://www.browserstack.com/BrowserStackTunnel.jar");
    Thread.sleep(10000);

    driver.quit();
  }
}

