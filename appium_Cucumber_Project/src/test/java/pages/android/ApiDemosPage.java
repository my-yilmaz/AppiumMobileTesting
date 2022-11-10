package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ApiDemosPage {
    public ApiDemosPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
    public AndroidElement apiDemosTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
    public AndroidElement preference;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    public AndroidElement views;

}
