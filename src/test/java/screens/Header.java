package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screensElements.HeaderMap;
import java.util.concurrent.TimeUnit;

public class Header extends HeaderMap
{
    private AppiumDriver<MobileElement> driver;

    public Header(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);
    }

    public void clickBackIcon()
    {
        backIcon.click();
    }
}