package screensElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomeScreenMap
{
    @iOSFindBy(accessibility = "DISCOVER NOW")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"DISCOVER NOW\")")
    protected MobileElement discoverMeButton;

    @iOSFindBy(accessibility = "debugButton")
    protected MobileElement debugIcon;

    @iOSFindBy(accessibility = "DebugScreen")
    protected MobileElement debugList;

    @iOSFindBy(accessibility = "PRODUCT LIST")
    protected MobileElement productListIcon;

    @iOSFindBy(accessibility = "New")
    protected MobileElement newArrivalsIcon;

    @iOSFindBy(accessibility = "Designers")
    protected MobileElement designersIcon;

    @iOSFindBy(accessibility = "Search")
    protected MobileElement searchIcon;

    @iOSFindBy(accessibility = "Favorites")
    protected MobileElement wishListIcon;

    @iOSFindBy(accessibility = "Settings")
    protected MobileElement settingsIcon;
}