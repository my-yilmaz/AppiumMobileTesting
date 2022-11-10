package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ViewPage {
    public ViewPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    public MobileElement viewsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
    public MobileElement dragDropButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Switches']")
    public List<MobileElement> switchesButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Date Widgets']")
    public MobileElement dateWidgets;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Switches']")
    public MobileElement switchesButtonSingle;
}