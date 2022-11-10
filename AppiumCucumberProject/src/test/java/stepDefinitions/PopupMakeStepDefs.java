package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Screens;

public class PopupMakeStepDefs {
    Screens screens = new Screens();

    @Given("kullanici Make A Popup butonuna tiklasin")
    public void kullanici_make_a_popup_butonuna_tiklasin() {
        screens.popupMenuPage().makePopupButton.click();
    }

    @Then("panelin ciktigini dogrulasin")
    public void panelin_ciktigini_dogrulasin() {
        Assert.assertTrue(screens.popupMenuPage().searchButton.isDisplayed());
    }

    @Then("Toast mesajda Add gectigini dogrular")
    public void toast_mesajda_add_gectigini_dogrular() {
        Assert.assertTrue(screens.popupMenuPage().popupMessage.getAttribute("name").contains("Add"));

    }
}
