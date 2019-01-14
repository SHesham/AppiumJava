package testScenarios;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.yaml.snakeyaml.Yaml;
import utilities.InjectScreen;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseTest
{
    AppiumDriver<MobileElement> driver;

    private static DesiredCapabilities createCapabilities(String value) throws FileNotFoundException
    {
        FileReader file = new FileReader("src/test/java/utilities/platforms.yml");
        Map<String, Object> platforms = (Map<String, Object>) new Yaml().load(file);
        Map<String, Object> platform = (Map<String, Object>) platforms.get(value);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (String key : platform.keySet())
        {
            capabilities.setCapability(key, platform.get(key));
        }
        return capabilities;
    }

    @BeforeMethod
    @Parameters({"PLATFORM"}) // Run the platform passed from TestNG.xml file
    public void setup(@Optional("iOS") String platform) throws MalformedURLException, FileNotFoundException
    {
        String url= "http://0.0.0.0:4723/wd/hub";
        String platformProperty = System.getProperty("PLATFORM");  //TO Load Android or iOS
        platform = (platformProperty != null) ? platformProperty : platform;
        DesiredCapabilities capabilities = createCapabilities(platform);

        driver = new AppiumDriver<MobileElement>(new URL(url), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        InjectScreen.injectFields(this, driver);
    }

    static void changeAppContextToWeb(AppiumDriver<MobileElement> driver) throws InterruptedException
    {
        // Switch to WebView
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        System.out.println(contextNames.size());
        for (String contextName : contextNames)
        {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW"))
            {
                driver.context(contextName);
            }
        }
    }

    static void changeAppContextToNative(AppiumDriver<MobileElement> driver)
    {
        driver.context("NATIVE_APP");
       //driver.execute(DriverCommand.SWITCH_TO_CONTEXT, ImmutableMap.of("name", "NATIVE_APP");
    }

    void clickBackBtnFromAndroidDevice()
    {
        ((AndroidDriver<?>)driver).pressKeyCode(AndroidKeyCode.BACK);
    }

    void screenScrollUp()
    {
        driver.executeScript("mobile: scroll", ImmutableMap.of("direction","up"));
    }

    void waitForScreenWebViewElementToLoad()
    {
        try
        {
            Thread.sleep(1000);
            (new WebDriverWait(driver,10))
                    .until(driver->(JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
        }
        catch (Throwable error)
        {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException
    {
        if (ITestResult.FAILURE == testResult.getStatus())
        {
           System.out.println(String.format("Test result is %s", testResult.isSuccess() ? "passed" : "failed"));
           File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(scrFile, new File("./errorScreenshots/" + testResult.getName() + "-" +
                   Arrays.toString(testResult.getParameters()) + ".jpg"));
           System.out.println("screen shot is taken");
        }
        driver.quit();
    }
}