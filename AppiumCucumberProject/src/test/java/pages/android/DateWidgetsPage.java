package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DateWidgetsPage {
    public DateWidgetsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }

    @AndroidFindBy(accessibility = "9")
    public MobileElement num9;

    @AndroidFindBy(accessibility = "15")
    public MobileElement num15;

    @AndroidFindBy(accessibility = "45")
    public MobileElement num45;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2. Inline']")
    public MobileElement inline;
}