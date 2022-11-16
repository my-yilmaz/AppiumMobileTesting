package Appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium16BSSauceApp {
    @Test
    public void BSSauceAppTest() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "muhammedyilmaz_z2ESQg");
        caps.setCapability("browserstack.key", "3bkUAidAmV76PRQ3evFD");

        // Set URL of the application under test
        caps.setCapability("app", "bs://d64ae42a1f52a3cb9fc29e7cc796f318179e1d2c");

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

        // Write your test case statements here
        driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
        driver.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");
        driver.findElementByAccessibilityId("test-LOGIN").click();
        Assert.assertEquals("PRODUCTS",driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='PRODUCTS']")).getText());
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}