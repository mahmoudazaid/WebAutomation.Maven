package tests;

import okio.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public static void startDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterSuite
    public void stopDriver(){
        driver.quit();
    }
}
