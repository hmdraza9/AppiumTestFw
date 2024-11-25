import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        System.out.println("Setting up caps:");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android"); // W3C standard capability
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:app", "/Users/hmdraza9/Documents/GitClones/MyProjectNew/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);
        caps.setCapability("appium:fullReset", false);
        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:unicodeKeyboard", true);
        caps.setCapability("appium:resetKeyboard", true);
        caps.setCapability("appium:skipDeviceInitialization", true);
        caps.setCapability("appium:skipServerInstallation", true);


        System.out.println("Setting up caps DONE: "+caps);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),caps);
    }

    @Test
    public void click_App_Button(){
        //
        System.out.println("driver.getStatus(): "+driver.getStatus());
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"standard_user\"]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys("TestFinal");
//        driver.findElement(By.xpath("//android.widget.TextView[@text=\"standard_user\"]")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@text=\"standard_user\"]")).click();
    }

    @AfterTest
    public void tearDown(){
        if(null!=driver){
            driver.quit();
        }
    }

}




















