package browser;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.LoadProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

//
public class Driver extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    static Properties environment = LoadProperties.loadProperties(System.getProperty("user.dir") + "/src/main/java/properties/Environment.properties");
    static String browserName = environment.getProperty("browserName");

    public static void openBrowser() {

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
        driver.manage().timeouts().implicitlyWait(Long.parseLong(environment.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        driver.navigate().to(environment.getProperty("URL"));
    }

    public static void Visit(String _url) {
        driver.get(_url);
    }

    public static void CloseBrowser() {
        driver.quit();
    }
}