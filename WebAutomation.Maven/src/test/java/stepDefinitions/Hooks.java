package stepDefinitions;

import browser.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.LoadProperties;

import static browser.Driver.driver;

public class Hooks extends AbstractTestNGCucumberTests {

    @BeforeSuite
    @Parameters({"browser"})
    public static void openBrowser(@Optional("Chrome") String browserName) {
        Driver.openBrowser(browserName);
    }

    @AfterSuite
    public void closeBrowser() {
        Driver.CloseBrowser();
    }

    @AfterMethod
    public void screenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking screenshot...");
            utilities.Screenshot.captureScreenshot(driver, result.getName());
        }
    }
}
