package stepDefinitions;

import browser.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import static browser.Driver.driver;

public class Hooks extends AbstractTestNGCucumberTests {
    static String browserName="Chrome";

    @Before
    public static void openBrowser() {
        Driver.openBrowser();
    }

    @After
    public void closeBrowser() {
        Driver.CloseBrowser();
    }

    @AfterClass
    public void screenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking screenshot...");
            utilities.Screenshot.captureScreenshot(driver, result.getName());
        }
    }
}
