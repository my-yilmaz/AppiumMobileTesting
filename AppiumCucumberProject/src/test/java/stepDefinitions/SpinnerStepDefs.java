package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Screens;
import utilities.ReusableMethods;

public class SpinnerStepDefs {

    Screens screens=new Screens();
    @Given("kullanici color menusunden {string} secer")
    public void kullanici_color_menusunden_secer(String string) throws InterruptedException {
        screens.spinnerPages().color.click();
        ReusableMethods.tapOn(screens.spinnerPages().blue);
        Thread.sleep(3000);
    }
    @Given("kullanici planet menusunden {string} secer")
    public void kullanici_planet_menusunden_secer(String string) throws InterruptedException {
        screens.spinnerPages().planet.click();
        screens.spinnerPages().saturn.click();
    }

    @Then("blue sectigini dogrular")
    public void blue_sectigini_dogrular() {
        Assert.assertTrue(screens.spinnerPages().slectedBlue.isDisplayed());
    }

    @Then("Saturn sectigini dogrular")
    public void saturn_sectigini_dogrular() {
        Assert.assertTrue(screens.spinnerPages().slectedSaturn.isDisplayed());
    }

    @Then("toast mesaji dogrular")
    public void toastMesajiDogrular() {
        Assert.assertEquals("Spinner2: position=5 id=5", screens.spinnerPages().toastMessage.getAttribute("name"));
        System.out.println(screens.spinnerPages().toastMessage.getAttribute("name"));
    }
}
