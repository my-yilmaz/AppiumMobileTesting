package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium15BrowserStackAndroid {
    @Test
    public void browserStackAndroid() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "maviblues_gM3yqK");
        caps.setCapability("browserstack.key", "UQ9mXQqzBJBYG8q5162H");

        // Set URL of the application under test
        caps.setCapability("app", "bs://fdffc9ab8f46f6e4a1184d1912a599970f94743c");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy Note 20");
        caps.setCapability("os_version", "10.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here
        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.touchboarder.android.api.demos:id/buttonDefaultPositive").click();

        driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
        Thread.sleep(3000);
        //preference butonuna tikladik
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        //preference dependencies butonuna bastik
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        System.out.println(isChecked + " <===========");
        if (isChecked.equals("false")) {
            driver.findElementById("android:id/checkbox").click();
            System.out.println("if calisti");
        }

        //check box check et

        Thread.sleep(3000);
//        driver.findElementById("android:id/checkbox").click();
        //wifi setting tikladik
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        //text penceresi acildigini gorduk
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementById("android:id/alertTitle").isDisplayed());
        //text yazdiralim
        driver.findElementById("android:id/edit").sendKeys("TextAppium");
        //ok butonuna bas
        driver.findElementById("android:id/button1").click();

        System.out.println("mission completed....");

        Thread.sleep(10000);
        //session kapat

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }
}