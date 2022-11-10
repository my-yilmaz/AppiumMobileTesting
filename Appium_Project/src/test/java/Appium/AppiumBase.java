package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumBase {
    public static AndroidDriver androidDriver() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Pixel_2");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "C:\\Users\\my\\IdeaProjects\\AppiumMobileTesting\\Appium_Project\\Apps\\apiDemos.apk");
       // capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
       // capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        return driver;
    }
}
