package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium06NativeAppChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","org.chromium.chrome.browser.ChromeTabbedActivity");
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.get("https://www.facebook.com");

        System.out.println(driver.getContext() + "<====app acildigindaki tur");
        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
//        Set<String> butunturler = driver.getContextHandles();
//        for (String tur: butunturler) {
//            System.out.println(tur);
//            if (tur.contains("WEBVIEW_chrome")) {
//                driver.context(tur);
//            }
//        }
        Thread.sleep(20000);
        System.out.println(driver.getContext() + "<====degisimden sonraki tur");
        MobileElement homeScreenLogo = driver.findElement(By.xpath("//android.view.View[@text='facebook']"));

        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Ana sayfadayiz");

//        System.out.println(driver.getCurrentUrl() +"<========= url ");
        Thread.sleep(3000);
        MobileElement createButton = driver.findElement(By.xpath("//android.widget.Button[@text='Create New Account']"));
        createButton.click();
        Thread.sleep(15000);
        MobileElement joinText = driver.findElement(By.xpath("//android.view.View[@text='Join Facebook']"));

        Assert.assertEquals(joinText.getText(),"Join Facebook");

        System.out.println("test bittİ...");
        Thread.sleep(5000);
        //close session
        driver.closeApp();




    }
}