package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.Screens;
import utilities.ReusableMethods;

public class ReusableMethodsStepDefs {
    @When("kullanici {string} butununa tikladi")
    public void kullanici_butununa_tikladi(String text) throws InterruptedException {
        ReusableMethods.clickOnElementWithText(text);
    }
}
