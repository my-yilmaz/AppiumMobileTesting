package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EC02Positive {
    /*
     1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
     2-Shop the items in the app by scrolling to specific Product and add to cart
     3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
     4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
     5-Validate Mobile gestures working for link (long press) and navigate to WebView
     6-Verify if user can do operations on Web view and navigate back to native app if needed.
     (go to google and search “appium” then navigate to NATIVE APP and verify it)
    */
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\my\\IdeaProjects\\AppiumMobileTesting\\AppiumProject\\Apps\\General-Store.apk");
        capabilities.setCapability("noReset", "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Thread.sleep(5000);
        //ulke secilsin
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"))");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();
        // isim girilsin
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anna");
        //female secilsin
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        //shop butonuna tiklayalim
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        //basarili giris yapildi
        Assert.assertTrue("sayfa basligi gorundu", driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        driver.quit();

    }
}
