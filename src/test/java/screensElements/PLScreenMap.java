package screensElements;

import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PLScreenMap
{
    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"heartIcon\"]")
    //@FindBy(xpath=".//a[@class='add-to-wishlist icon-heart']")
    protected List<WebElement> heartIcon;

    @iOSFindBy(accessibility = "popUpWindow")
    //@FindBy(xpath=".//div[contains(@class,'visible')]")
    protected WebElement addItemPopUp;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"itemSizes\"]")
    //@FindBy(xpath=".//div[contains(@class,'visible')]//li")
    protected List <WebElement> selectSize;

    @iOSFindBy(accessibility = "addToCartBtn")
    //@FindBy(xpath=".//div[contains(@class,'visible')]//button[contains(@id,'add-to-cart-button')]")
    protected WebElement addToBag;

    @iOSFindBy(accessibility = "addToWishListBtn")
    //@FindBy(xpath=".//div[contains(@class,'visible')]/button[contains(@id,'button-add-to-wishlist')]")
    protected WebElement addToWishL;

    @FindBy(className="vex-content")
    protected WebElement itemAddedPopUp;

    @FindBy(xpath=".//a[text()='back to shop']")
    protected WebElement backFromWishLButton;
}