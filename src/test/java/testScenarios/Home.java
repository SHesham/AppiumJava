package testScenarios;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.Header;
import screens.HomeScreen;
import screens.PLScreen;
import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class Home extends BaseTest
{
    @Inject
    private Header header;
    @Inject
    private HomeScreen home;
    @Inject
    private PLScreen plp;

    @BeforeMethod
    @Override
    @Parameters({"PLATFORM"}) // Run the platform passed from TestNG.xml file
    public void setup(@Optional("iOS") String platform) throws MalformedURLException, FileNotFoundException
    {
        super.setup(platform);
    }

    @Test
    public void openPLScreen() throws InterruptedException
    {
        driver.switchTo().alert().accept();
        home.clickDebugIcon();
        home.waitForDebugListToShow();
        home.clickProductListIcon();
        //home.clickDiscoverMeBtn();
        //changeAppContextToWeb(driver);
        changeAppContextToNative(driver);
        waitForScreenWebViewElementToLoad();
        plp.clickHeartIcon();
        plp.selectItem();
        plp.clickAddToWishLBtn();
        plp.clickBackFromWishLBtnFromWishListConfirmationPopUp();
        changeAppContextToNative(driver);
        header.clickBackIcon();
        //clickBackBtnFromAndroidDevice();
    }
}