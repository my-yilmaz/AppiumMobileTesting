package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SwitchPage {
    public SwitchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "android:id/checkbox")
    public MobileElement checkBox;

    @AndroidFindBy(xpath = "(//android.widget.Switch)[1]")
    public MobileElement firstSwitch;

    @AndroidFindBy(xpath = "(//android.widget.Switch)[2]")
    public MobileElement secondSwitch;


}