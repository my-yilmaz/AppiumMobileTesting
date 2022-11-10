package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import pages.Screens;
import utilities.Driver;
import utilities.ReusableMethods;

public class ApiDemosSteps extends ReusableMethods {
    Screens screens = new Screens();

    @Given("App yuklensin")
    public void app_yuklensin() {
        Driver.getAppiumDriver();
    }

    @Given("kullanici ana ekranda")
    public void kullanici_ana_ekranda() {
        Assert.assertTrue(isElementPresent(screens.mainPage().mainScreenTitle));
    }

    @Given("kullanici API Demos butununa tikladi")
    public void kullanici_api_demos_butununa_tikladi() {
        tapOn(screens.mainPage().apiDemos);

    }

    @Then("kullanici API Demos ekraninda")
    public void kullanici_api_demos_ekraninda() {
        Assert.assertEquals("API Demos", screens.apiDemosPage().apiDemosTitle.getText());

    }

    @Then("kullanici Preference butununa tikladi")
    public void kullanici_preference_butununa_tikladi() {
        tapOn(screens.apiDemosPage().preference);
    }

    @Then("kullanici Preference ekraninda")
    public void kullanici_preference_ekraninda() {
        Assert.assertEquals("Preference", screens.preferencePage().preferenceScreenTitle.getText());
    }

    @Then("kullanici Preference dependencies tikladi")
    public void kullanici_preference_dependencies_tikladi() {
        tapOn(screens.preferencePage().preferenceDependencies);
    }

    @Then("kullanici WiFi check box secmis olacak")
    public void kullanici_wi_fi_check_box_secmis_olacak() {
        if (screens.preferenceDependenciesPage().checkBox.getAttribute("checked").equals("false")) {
            tapOn(screens.preferenceDependenciesPage().checkBox);
        }

    }

    @Then("kullanici WiFi Settings tikladi")
    public void kullanici_wi_fi_settings_tikladi() {
        tapOn(screens.preferenceDependenciesPage().wifiSettings);
    }

    @Then("WiFi setting popup geldi")
    public void wi_fi_setting_popup_geldi() {
        Assert.assertTrue(isElementPresent(screens.preferenceDependenciesPage().cancelButton));
    }

    @Then("kullanici {string} yazdi")
    public void kullanici_yazdi(String text) {
        enterText(screens.preferenceDependenciesPage().textBox, text);

    }

    @Then("kullanci ok butonuna tikladi")
    public void kullanci_ok_butonuna_tikladi() {
        tapOn(screens.preferenceDependenciesPage().okButton);
    }

    @And("kullanici app kapatsin")
    public void kullaniciAppKapatsin() {
        Driver.quitAppiumDriver();
    }

    @And("kullanici Switches butununa tikladi")
    public void kullaniciSwitchesButununaTikladi() {
        tapOn(screens.preferencePage().switchButton);
    }

    @And("kullanici check box tikladi")
    public void kullaniciCheckBoxTikladi() {
        tapOn(screens.switchPage().checkBox);
    }

    @And("kulanici switch butonuna tikladi")
    public void kulaniciSwitchButonunaTikladi() {
    }

    @And("check box secili olmali")
    public void checkBoxSeciliOlmali() {
        if (screens.preferenceDependenciesPage().checkBox.getAttribute("checked").equals("false")) {
            tapOn(screens.switchPage().checkBox);

        }
    }

    @And("ilk switch butonu kapali")
    public void ilkSwitchButonuKapali() {
        if (screens.switchPage().firstSwitch.getText().equals("ON")) {
            tapOn(screens.switchPage().firstSwitch);
        }
    }

    @And("ikici switch butonu acik")
    public void ikiciSwitchButonuAcik() {
        if (screens.switchPage().secondSwitch.getText().equals("OFF")) {
            tapOn(screens.switchPage().secondSwitch);
        }
    }
}
