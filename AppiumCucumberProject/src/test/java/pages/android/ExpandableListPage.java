package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpandableListPage {
    public ExpandableListPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chuck']")
    public MobileElement chuck;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sample menu']")
    public MobileElement sampleMenu;
}
