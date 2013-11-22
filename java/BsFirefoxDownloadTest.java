import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BsFirefoxDownloadTest {
  public static void main(String[] args) throws MalformedURLException, InterruptedException {
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability("browser", "firefox");
    capability.setCapability("browserstack.debug", "true");

    FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("browser.download.folderList", 0);
    profile.setPreference("browser.download.manager.showWhenStarting", false);
    profile.setPreference("browser.download.manager.focusWhenStarting", false);
    profile.setPreference("browser.download.useDownloadDir", true);
    profile.setPreference("browser.helperApps.alwaysAsk.force", false);
    profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
    profile.setPreference("browser.download.manager.closeWhenDone", true);
    profile.setPreference("browser.download.manager.showAlertOnComplete", false);
    profile.setPreference("browser.download.manager.useWindow", false);
    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/java-archive,application/x-compressed);

    capability.setCapability(FirefoxDriver.PROFILE, profile);

    WebDriver driver = new RemoteWebDriver(
        new URL("http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub"),
        capability);

    driver.get("http://www.browserstack.com/BrowserStackTunnel.jar");
    Thread.sleep(5000);

    driver.quit();
  }
}

