package browser;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.LoadProperties;

import java.util.concurrent.TimeUnit;

//
public class Driver extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    static String url = LoadProperties.environment.getProperty("URL");


    public static void openBrowser(String browserName) {

        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new ChromeDriver();
                break;
            case "OPERA":
                WebDriverManager.operadriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserName.toUpperCase());
        }
        // maximize browser's window on start
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    public static void Visit(String _url) {
        driver.get(_url);
    }

    public static void CloseBrowser() {
        driver.quit();

    }
}