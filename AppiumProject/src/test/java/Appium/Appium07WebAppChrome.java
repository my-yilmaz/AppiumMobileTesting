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

public class Appium07WebAppChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        //chrome driver versiyonunuzu burdan indirebilrisiniz
        //https://chromedriver.storage.googleapis.com/index.html
        //sonrasinda driver in absolute path bir alt satirda tanimliyorsunuz
        capabilities.setCapability("chromedriverExecutable","C:\\Users\\my\\IdeaProjects\\AppiumMobileTesting\\driver\\chromedriver.exe");
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext() + "<====app acildigindaki tur");
        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
        Set<String> contextName = driver.getContextHandles();
        for (String tur: contextName) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
            }
        }

        System.out.println(driver.getContext() + "<====app sonraki durumu");

        MobileElement logo = driver.findElementByXPath("//a[@id='nav-logo-sprites']");
        Assert.assertTrue(logo.isEnabled());
        System.out.println("Ana sayfadayiz....");
        Thread.sleep(7000);

        MobileElement signInButton = driver.findElementByXPath("//a[@id='nav-logobar-greeting']");
        signInButton.click();
        Thread.sleep(7000);

        MobileElement signInTitle = driver.findElementByXPath("//h2");
        Assert.assertTrue(signInTitle.isDisplayed());
        System.out.println("Sign in sayfasindayiz");

        Thread.sleep(20000);
        //close session
        driver.closeApp();
    }
}