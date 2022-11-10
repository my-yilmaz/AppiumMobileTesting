package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Screens;
import utilities.ReusableMethods;

public class ExpandablelistStepDefs {
    Screens screens = new Screens();

    @Given("{string} saniye bekle")
    public void saniye_bekle(String time) {
        ReusableMethods.wait(Integer.parseInt(time));

    }

    @Given("kullanici {string} butununa uzun basti")
    public void kullanici_butununa_uzun_basti(String element) {
        ReusableMethods.longPressOnElement(screens.expandableListPage().chuck);

    }

    @Then("kullanici popup ekranin ciktigini dogrular")
    public void kullanici_popup_ekranin_ciktigini_dogrular() {
        Assert.assertTrue(screens.expandableListPage().sampleMenu.isDisplayed());
    }

}
