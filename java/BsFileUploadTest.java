import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BsFileUploadTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("os","Windows");
        capability.setCapability("os_version","7");
        capability.setCapability("browser", "firefox");
        
        WebDriver driver = new RemoteWebDriver(
                new URL("http://BS_USERNAME:BS_AUTHKEY@hub.browserstack.com/wd/hub"),
                capability);

        driver.get("http://www.fileconvoy.com/");
        driver.findElement(By.id("upfile_0")).sendKeys("C:\\Users\\hello\\url.txt");
        driver.findElement(By.id("readTermsOfUse")).click();
        driver.findElement(By.name("form_upload")).submit();
        
        System.out.println(driver.findElement(By.tagName("center")).getText());
        driver.quit();
    }
}

