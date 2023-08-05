


package browserStackCloud;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserStack_Install_Application {
    
    
    WebDriver driver;
    public static final String USERNAME = "";
    public static final String AUTOMATE_KEY = "rPvwzmLSQB7NEbvY7Cws";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    //@Parameters({"browser", "browser_version", "os", "os_version"})
    @BeforeMethod
    public void setUp() throws Exception {

        
        String browserName = "chrome";
        String os = "chrome";
        String os_version = "chrome";
        String browser_version = "chrome";
        
        System.out.println("browser name is : " + browserName);
        //String methodName = name.getName();
        
        DesiredCapabilities caps = new DesiredCapabilities();
        
//      caps.setCapability("os", os);
//      caps.setCapability("os_version", os_version);
//      caps.setCapability("browser_version", browser_version);
        
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 3a");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        caps.setCapability(MobileCapabilityType.APP, "bs://946dde4f6b2bf0c2166058e0fbaa11fe28a188be");
        
        caps.setCapability("build", "chrome browser script");
        caps.setCapability("name", "Coforge ----- Run chrome on device - NOP comm Test on cloud");

        driver = new RemoteWebDriver(new URL(URL), caps);

    }

    
    @Test
    public void LaunchNOPCommApp() throws Exception {
        Thread.sleep(3000);
        driver.get("https://hub-cloud.browserstack.com:443/wd/hubsession/bca9d5631ade891c75f653d2bcdb80710b1238d4");
        Thread.sleep(3000);
        
        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("admin");
        
        driver.findElement(By.cssSelector("input#RememberMe")).click();
        
        driver.findElement(By.tagName("button")).click();
        
        Thread.sleep(5000);
        
        
    }
    
  
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
    
    
    

}
