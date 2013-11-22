import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.opera.core.systems.OperaProfile;

public class BsOperaPopupTest {
  
  public static void main(String[] args) throws MalformedURLException, InterruptedException {
    DesiredCapabilities capability = DesiredCapabilities.opera();
    capability.setCapability("build", "automate_popup_test");
    capability.setCapability("browserstack.debug", true);
    
    OperaProfile profile = new OperaProfile();
    profile.preferences().set("User Prefs", "Ignore Unrequested Popups", true);
    
    capability.setCapability("opera.profile", profile);
    
    WebDriver driver = new RemoteWebDriver(
      new URL("http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub"),
      capability
    );
    driver.get("http://www.naukri.com");
    Thread.sleep(5000);
    driver.quit();
  }

}
