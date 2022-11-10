package pages.android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PopupMenuPage {
    public PopupMenuPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()),this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE A POPUP!']")
    public MobileElement makePopupButton;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public MobileElement popupMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    public MobileElement searchButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WebView']")
    public MobileElement webViewButton;
}