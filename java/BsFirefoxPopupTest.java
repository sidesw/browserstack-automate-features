import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BsFirefoxPopupTest {

  public static void main(String[] args) throws MalformedURLException, InterruptedException {
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    capability.setCapability("build", "automate_popup_test");
    capability.setCapability("browserstack.debug", true);
    
    FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("dom.disable_open_during_load", false);
    profile.setPreference("dom.popup_allowed_events", "select change input click dblclick mouseup reset submit keydown keypress keyup mousedown error");
    
    capability.setCapability(FirefoxDriver.PROFILE, profile);
    
    WebDriver driver = new RemoteWebDriver(
        new URL("http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub"),
        capability
        );
    driver.get("http://www.naukri.com");
    Thread.sleep(5000);
    driver.quit();
  }

}
