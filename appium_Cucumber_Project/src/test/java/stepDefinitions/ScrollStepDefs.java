package stepDefinitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import pages.Screens;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ScrollStepDefs {
    Screens screens = new Screens();

    @When("kullanici Switches butonun tiklasin")
    public void kullanici_switches_butonun_tiklasin() {
        List<MobileElement> list;
        do {
            list = screens.viewPage().switchesButton;
            Dimension dimension = Driver.getAppiumDriver().manage().window().getSize();
            int start_x = (int) (dimension.width * 0.5);
            int start_y = (int) (dimension.height * 0.8);

            int end_x = (int) (dimension.width * 0.5);
            int end_y = (int) (dimension.height * 0.2);

            TouchAction action = new TouchAction<>(Driver.getAppiumDriver());
            action.press(PointOption.point(start_x, start_y))
                    .moveTo(PointOption.point(end_x, end_y)).release().perform();
            // ReusableMethods.tapOn(screens.viewPage().switchesButton);
        } while (list.size() == 0);
        screens.viewPage().switchesButton.get(0).click();
    }

    @And("kullanici uiscrollable ile Switches button tiklasin")
    public void kullaniciUiscrollableIleSwitchesButtonTiklasin() {
        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");
        screens.viewPage().switchesButtonSingle.click();
        //((AndroidDriver<?>) Driver.getAppiumDriver())
        //                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");
    }

    @And("kullanici method ile Switches butununa tikladi")
    public void kullaniciMethodIleSwitchesButununaTikladi() {

        ReusableMethods.scrollWithUiScrollable("Switches");
    }
}
