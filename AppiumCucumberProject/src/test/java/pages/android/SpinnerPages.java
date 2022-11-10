package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SpinnerPages {
    public SpinnerPages() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Spinner[1]")
    public MobileElement color;
    @AndroidFindBy(xpath = "//android.widget.Spinner[2]")
    public MobileElement planet;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='blue']")
    public MobileElement blue;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Saturn']")
    public MobileElement saturn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='blue']")
    public MobileElement slectedBlue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saturn']")
    public MobileElement slectedSaturn;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public MobileElement toastMessage;


}
