package testScenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import screens.Header;
import screens.HomeScreen;
import screens.PLScreen;
import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;

public class IOSBrowserStackTest extends BaseTest {

    @Inject
    private Header header;
    @Inject
    private HomeScreen home;
    @Inject
    private PLScreen plp;

    @BeforeMethod
    @Override
    @Parameters({"PLATFORM"}) // Run the platform passed from TestNG.xml file
    public void setup(@Optional("iOS") String platform) throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","iOS");
        caps.setCapability("device", "iPhone 7 Plus");
        caps.setCapability("os_version", "11.4");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("bundleId","com.mytheresa.rnapp");

        driver = new AppiumDriver<MobileElement>(new URL("http://" + "X1GqPnQscZGjdJNWUsfb" + ":" + "sarahhesham1" + "@hub-cloud.browserstack.com/wd/hub"), caps);
    }

    public void browserStack()
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
        //lickBackBtnFromAndroidDevice();
        driver.quit();
    }
}
