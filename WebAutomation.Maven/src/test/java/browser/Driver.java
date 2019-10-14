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
//                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "CHROME":
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
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

//    public static WebDriver driver;
//
//    private static enum Browsers {
//        FIREFOX, CHROME, SAFARI;
//    }
//
//    public static WebDriver OpenBrowser(String browserName) {
//        browserName = (browserName != null) ? browserName : "CHROME";
//
//        switch (Browsers.valueOf(browserName.toUpperCase())) {
//            case FIREFOX:
//                FirefoxDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case CHROME:
//                //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//                ChromeDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case SAFARI:
//                driver = new SafariDriver();
//                break;
//        }
//        // maximize browser's window on start
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        return driver;
//    }
//
}