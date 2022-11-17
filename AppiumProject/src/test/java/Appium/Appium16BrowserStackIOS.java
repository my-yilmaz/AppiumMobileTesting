package Appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium16BrowserStackIOS {
    @Test
    public void bsIOStEST() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "maviblues_gM3yqK");
        caps.setCapability("browserstack.key", "UQ9mXQqzBJBYG8q5162H");

        // Set URL of the application under test
        caps.setCapability("app", "bs://03b32fa6afd579304aa0b99e1f64347883324e8b");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
        Thread.sleep(2000);
        // Write your test case statements here
        driver.findElementByAccessibilityId("Text Button").click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("Text Input").sendKeys("IOS testing");
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("Return").click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElementByAccessibilityId("Text Output").isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"UI Elements\"])[1]")).click();
        Assert.assertEquals("UI Elements", driver.findElement(
                By.xpath("//XCUIElementTypeOther[@name=\"UI Elements\"]")).getText());
        Thread.sleep(2000);

        driver.findElementByAccessibilityId("Alert").click();
        Thread.sleep(2000);
        Assert.assertEquals("Alert", driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Alert\"]")).getText());
        driver.findElementByAccessibilityId("OK").click();
        Thread.sleep(2000);
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
