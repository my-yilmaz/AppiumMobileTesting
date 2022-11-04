package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06NativeChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // https://chromedriver.storage.googleapis.com/index.html?path=74.0.3729.6/ chrome version bilgisi
        // https://chromedriver.chromium.org/downloads butn versionlar
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("chromedriverExecutable", "C:\\Users\\mrs\\IdeaProjects\\AppiumMobile\\driver\\chromedriver.exe");
        capabilities.setCapability("noReset", "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }

        System.out.println("app yuklendi");
        driver.get("https://www.amazon.com");
        System.out.println(driver.getContext() + "<====app acildigindaki tur");
        // https://developer.chrome.com/docs/devtools/remote-debugging/ remote device on chrome
        // hrome://inspect#devices on chrome browser
        driver.findElementById("nav-logobar-greeting").click();
        MobileElement welcome = driver.findElementById("outer-accordion-signin-signup-page");
        Assert.assertTrue(welcome.isDisplayed());

        System.out.println(driver.getContext() + "<====app acildigindaki tur");
        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
        Set<String> butunturler = driver.getContextHandles();
        for (String tur : butunturler) {
            System.out.println(tur);
          //  if (tur.contains("WEBVIEW_chrome")) {
          //      driver.context(tur);
          //  }
        }

        System.out.println(driver.getContext() + "<====degisimden sonraki tur");
        Thread.sleep(7000);

       // driver.quit();

    }
}