package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

/**
 * Created by danggrianto.
 * Example tests for AWS Device Farm
 */
public class BasicTest {
    private static AppiumDriver<WebElement> driver;

    /**
     * Run before each method
     * @throws MalformedURLException
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<WebElement>(appiumURL, capabilities);
    }

    /**
     * Run After each test method
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void basicTest(){
        takeScreenshot("basicTest");
        assertTrue(true);
    }

    /**
     * Take Screenshot
     * @param name file name
     * @return true if successful
     */
    private boolean takeScreenshot(final String name) {
        String screenshotDirectory = System.getProperty("appium.screenshots.dir");
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }
}
