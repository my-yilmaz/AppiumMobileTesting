package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import pages.Screens;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.ReusableMethods.tapOn;


public class SwipeStepDefs {
    Screens screens = new Screens();

    @Given("kullanici Date Widgets butununa tikladi")
    public void kullanici_date_widgets_butununa_tikladi() {
        tapOn(screens.viewPage().dateWidgets);
    }

    @Given("kullanici {int}. Inline butununa tikladi")
    public void kullanici_inline_butununa_tikladi(Integer int1) {
        tapOn(screens.dateWidgetsPage().inline);
    }

    @Given("kullanici {int} tiklasin")
    public void kullanici_tiklasin(Integer int1) {
        tapOn(screens.dateWidgetsPage().num9);
    }

    @Given("kulanici {int} ten {int} e yesil topu kaydirsin")
    public void kulanici_ten_e_yesil_topu_kaydirsin(Integer int1, Integer int2) {
        TouchAction action = new TouchAction(Driver.getAppiumDriver());
        action.press(ElementOption.element(screens.dateWidgetsPage().num15))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(ElementOption.element(screens.dateWidgetsPage().num45)).perform();

    }
}
