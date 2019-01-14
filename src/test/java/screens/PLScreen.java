package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screensElements.PLScreenMap;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class PLScreen extends PLScreenMap
{
    private AppiumDriver<MobileElement> driver;

    public PLScreen(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 60, TimeUnit.SECONDS), this);
    }

    public void clickHeartIcon()
    {
        heartIcon.get(0).click();
        waitForAjaxPopUp();
    }

    private void waitForAjaxPopUp() {await().atMost(60, SECONDS).until(() -> addItemPopUp.isDisplayed());}

    public void selectItem()
    {
        for (int i = 0; i < selectSize.size(); i++)
        {
            selectSize.get(i).click();
            if (addToBag.isEnabled())
            {
                break;
            }
        }
    }

    public void clickAddToWishLBtn()
    {
        addToWishL.click();
        waitForAjaxConfirmationPopUp();
    }

    private void waitForAjaxConfirmationPopUp() {await().atMost(60, SECONDS).until(() -> itemAddedPopUp.isDisplayed());}

    public void clickBackFromWishLBtnFromWishListConfirmationPopUp()
    {
        backFromWishLButton.click();
    }
}