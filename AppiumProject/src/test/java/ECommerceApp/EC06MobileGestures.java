package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class EC06MobileGestures {
    /*
    1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    2- Shop the items in the app by scrolling to specific Product and add to cart
    3- Validate if the items selected in the page 2 are matching with the items displayed in check out page
    4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
    5- Validate Mobile gestures working for link (long press) and navigate to WebView
    6- Verify if user can do operations on Web view and navigate back to native app if needed.
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

        Thread.sleep(4000);
        //ulke secilsin
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
        // isim girilsin
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anna");
        //female secilsin
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        //shop butonuna tiklayalim
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        //basarili giris yapildi
        Assert.assertTrue("sayfa basligi gorundu", driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());
        //birinci urun sec
        driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
        Thread.sleep(2000);
        //2. urune kadar scroll yapildi
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"Jordan Lift Off\"))");

        List<MobileElement> urunler = driver.findElementsById("com.androidsample.generalstore:id/productName");
        //urun adi uzerinden add to cart butonuna ulasiyoruz
        for (int i = 0; i < urunler.size(); i++) {
            if (urunler.get(i).getText().equals("Jordan Lift Off")) {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);

        //sepette ol
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        //ilk urunun adi Air Jordan 4 Retro
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText(), "Air Jordan 4 Retro");

        //ikinci urun adi = Air Jordan 1 Mid SE
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Jordan Lift Off']").getText(), "Jordan Lift Off");
        Thread.sleep(2000);

        //sepeeteki iki urunun toplami ile genel toplami karsilastirma
        List<MobileElement> urunFiyatlari = driver.findElementsById("com.androidsample.generalstore:id/productPrice");
        String firstProductPrice = urunFiyatlari.get(0).getText();
        System.out.println("firstProductPrice = " + firstProductPrice); //$160.97
        String secondProductPrice = urunFiyatlari.get(1).getText();
        System.out.println("secondProductPrice = " + secondProductPrice); //$115.0

        //urunlerin fiyat toplamlari
        String firstProduct = firstProductPrice.substring(1);
        String secondProduct = secondProductPrice.substring(1);
        double firstDouble = Double.parseDouble(firstProduct);
        System.out.println("birinci urunun fiyati = " + firstDouble); //160.97
        double secondDouble = Double.parseDouble(secondProduct);
        System.out.println("ikinci urunun fiyati, = " + secondDouble);//115.0

        String total = String.valueOf(firstDouble + secondDouble);
        System.out.println("iki urunun toplam fiyatı = " + total); //275.97

        //sepetteki toplam fiyat
        MobileElement totalPrice = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl");
        String totalActual = totalPrice.getText().substring(1);

        String totalPriceDouble = String.valueOf(Double.parseDouble(totalActual));
        System.out.println("Sepetteki iki urunun toplam fiyati = " + totalPriceDouble);

        //iki total fiyatin ayni oldugunu dogrulama

        Assert.assertEquals("iki urunun toplam fiyati ile sepetteki toplam fiyat ayni", totalPriceDouble, total);

        // term of conditons gormek icin long press yapilmali
     MobileElement checkBox=driver.findElement(By.className("android.widget.CheckBox"));
     MobileElement termsOfCondButton= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
     MobileElement visitWebsiteButton= driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
        TouchAction action=new TouchAction<>(driver);
        //tab
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkBox))).perform();
        // long press
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(termsOfCondButton))).release().perform();

        //popup assert
        MobileElement popUpTitle= driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle"));
        MobileElement closeButton= driver.findElement(By.id("android:id/button1"));
        Assert.assertTrue(popUpTitle.isDisplayed());

        //close button
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(closeButton))).perform();

        System.out.println(driver.getContext() + "<====visit website button tap etmeden once");
        //visit website button
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(visitWebsiteButton))).perform();

        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
        Thread.sleep(5000);
        Set<String> contextName = driver.getContextHandles();
        for (String tur: contextName) {
            System.out.println(tur);
            Thread.sleep(3000);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
                Thread.sleep(3000);
            }
        }

        System.out.println(driver.getContext() + "<====visit website button tap ettikten sonra");

    }
}