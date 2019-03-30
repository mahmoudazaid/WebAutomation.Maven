package Browser;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    static WebDriver driver;

    public Driver(){
//		this.setWebDriver(createInstance("Chrome"));
    }
    private static enum Browsers {
        FIREFOX, CHROME, SAFARI;
    }

    public static WebDriver OpenBrowser(String browserName) {

        browserName = (browserName != null) ? browserName : "CHROME";

        switch (Browsers.valueOf(browserName.toUpperCase())) {
            case FIREFOX:
                FirefoxDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                ChromeDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
        }
        // maximize browser's window on start
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void Visit(String _url)
    {
        driver.get(_url);
    }

    public static void Close() {
        driver.quit();

    }
}
