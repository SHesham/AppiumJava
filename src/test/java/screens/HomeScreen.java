package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screensElements.HomeScreenMap;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class HomeScreen extends HomeScreenMap
{
    private AppiumDriver<MobileElement> driver;

    public HomeScreen(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);
    }

    public void clickDiscoverMeBtn()
    {
        discoverMeButton.click();
    }

    public void clickDebugIcon()
    {
        debugIcon.click();
    }

    public void waitForDebugListToShow()
    {
        await().atMost(3, SECONDS).until(() -> debugList.isDisplayed());
    }

    public void clickProductListIcon()
    {
        productListIcon.click();
    }
}