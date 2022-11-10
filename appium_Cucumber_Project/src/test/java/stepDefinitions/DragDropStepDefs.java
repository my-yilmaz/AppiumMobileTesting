package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Screens;
import utilities.Driver;

import static utilities.ReusableMethods.*;

public class DragDropStepDefs {
    Screens screens = new Screens();
    TouchAction action = new TouchAction<>(Driver.getAppiumDriver());

    @Then("kullanici Views butonuna tikladi")
    public void kullanici_views_butonuna_tikladi() {
        tapOn(screens.apiDemosPage().views);


    }

    @Then("kullanici Views ekraninda")
    public void kullanici_views_ekraninda() {
        Assert.assertTrue(screens.viewPage().viewsTitle.isDisplayed());
    }

    @Then("kullanici Drag and Drop butonuna tikladi")
    public void kullanici_drag_and_drop_butonuna_tikladi() {
        tapOn(screens.viewPage().dragDropButton);
    }

    @When("kullanici birinci topu ikici topun ustune brakti")
    public void kullanici_birinci_topu_ikici_topun_ustune_brakti() {
        action.longPress(ElementOption.element(screens.dragAndDropPage().firstDot))
                .moveTo(ElementOption.element(screens.dragAndDropPage().secondDot)).release().perform();
    }

    @Then("kullanici dorduncu top gorecek")
    public void kullanici_dorduncu_top_gorecek() {
        Assert.assertTrue(screens.dragAndDropPage().hiddenDot.isDisplayed());

    }

}
