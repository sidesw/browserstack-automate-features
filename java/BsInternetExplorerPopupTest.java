import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BsInternetExplorerPopupTest {
  
  public static void main(String[] args) throws MalformedURLException, InterruptedException {
    DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
    capability.setCapability("build", "automate_popup_test");
    capability.setCapability("browserstack.debug", true);
    capability.setJavascriptEnabled(true);
    capability.setCapability("ignoreProtectedModeSettings", true);
    capability.setCapability("unexpectedAlertBehaviour", "ignore");
    
    WebDriver driver = new RemoteWebDriver(
      new URL("http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub"),
      capability
    );
    driver.get("http://www.naukri.com");
    Thread.sleep(5000);
    driver.quit();
  }
}
