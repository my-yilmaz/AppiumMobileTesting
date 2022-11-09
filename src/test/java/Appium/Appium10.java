package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Pixel_2");
        capabilities.setCapability("automationName", "UiAutomator2");
        // capabilities.setCapability("app", "C:\\Users\\my\\IdeaProjects\\AppiumMobileTesting\\Apps\\apiDemos.apk");
        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:localhost:4723/wd/hub"), capabilities);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("android:id/checkbox")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("android:id/edit")).sendKeys("test");
        Thread.sleep(4000);
        driver.findElement(By.id("android:id/button1")).click();
    }
}
