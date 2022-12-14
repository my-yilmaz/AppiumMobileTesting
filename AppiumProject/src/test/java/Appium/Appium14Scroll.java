package Appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;

public class Appium14Scroll extends AppiumBase {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        Dimension dimension = driver.manage().window().getSize(); // cihazın ekran olcularını inc olarak aldik
        TouchAction action = new TouchAction(driver);

// scroll up
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.2);


            Thread.sleep(3000);
            action.press(PointOption.point(start_x, start_y))
                    .moveTo(PointOption.point(end_x, end_y))
                    .release().perform();

  // scroll down

        int start_x1 = (int) (dimension.width * 0.5);
        int start_y1 = (int) (dimension.height * 0.2);

        int end_x1 = (int) (dimension.width * 0.5);
        int end_y1 = (int) (dimension.height * 0.8);


        Thread.sleep(3000);
        action.press(PointOption.point(start_x1, start_y1))
                .moveTo(PointOption.point(end_x1, end_y1))
                .release().perform();

    }
}
