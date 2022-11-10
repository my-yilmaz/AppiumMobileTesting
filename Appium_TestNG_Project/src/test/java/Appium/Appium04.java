package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\my\\IdeaProjects\\AppiumMobileTesting\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //asadidaki kod tel kilitli ise acmamizi sagliyor

        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }

        System.out.println("app yuklendi");

        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        System.out.println("add gesture butonuna tiklandi");
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("test");
        Thread.sleep(3000);
        System.out.println("bilgi gonderildi");
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(2000);
        MobileElement test=driver.findElementByXPath("//android.widget.TextView[@text='test']");
        Assert.assertTrue(test.isDisplayed());
        System.out.println("verinin olusturuldugu dogrulandi");
    }
}