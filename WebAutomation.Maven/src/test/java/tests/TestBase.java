package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public static void openBrowser(@Optional("Chrome") String browserName) {

        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserName.toUpperCase());
        }
        // maximize browser's window on start
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }


    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }

    // Take a screen when test case failed
    @AfterMethod
    public void screenShotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed");
            System.out.println("Taking screenshot...");
            utilities.Screenshot.captureScreenshot(driver,result.getName());
        }
    }
}
