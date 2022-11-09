package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.List;

public class appium12 extends AppiumBase {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();
        System.out.println("App intstalled...");
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='5. Preferences from code']").click();
        Thread.sleep(3000);
        List<MobileElement> checkBox = driver.findElementsByXPath("(//android.widget.CheckBox)[1]");
        System.out.println("checkBox size := " + checkBox.size());
        System.out.println(checkBox.get(0).getAttribute("checked"));
        if (checkBox.get(0).getAttribute("checked").equals("false")) {
            checkBox.get(0).click();
        } else {
            Assert.assertEquals("true", checkBox.get(0).getAttribute("checked"));
        }
        driver.findElementByXPath("//android.widget.TextView[@text='Edit text preference']").click();
        Thread.sleep(3000);
        driver.findElement(By.id("android:id/edit")).sendKeys("test");
        Thread.sleep(3000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.quit();
    }
}
