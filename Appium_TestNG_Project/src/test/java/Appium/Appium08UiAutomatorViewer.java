package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium08UiAutomatorViewer {
    @Test
    public void test() throws InterruptedException, MalformedURLException, MalformedURLException {

        /*
            install app
            do any mathematical operation
            and verify pre result and final result
        */

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\my\\IdeaProjects\\AppiumMobileTesting\\Apps\\Calculator.apk");

        //noReset
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //appium server url
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(3000);


        driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();


    }


}