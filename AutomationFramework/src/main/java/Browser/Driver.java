package Browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    static WebDriver driver;

    public Browser(){
//		this.setWebDriver(createInstance("Chrome"));
    }

    /**
     *
     * @return CHROME WebDriver
     */
    public static WebDriver createInstance() {
        return createInstance(null);
    }

    /**
     *
     * @param browserName
     *            firefox, IE, Chrome, Safari, HTMLUnit or HTMLUnitJS
     *
     * @return WebDriver
     */
    public static WebDriver createInstance(String browserName) {

        browserName = (browserName != null) ? browserName : "CHROME";

        switch (Browsers.valueOf(browserName.toUpperCase())) {
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            case IE:
//			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
                InternetExplorerDriverManager.getInstance().setup();
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                driver = new InternetExplorerDriver(caps);
                break;
            case CHROME:
//			System.setProperty("webdriver.chrome.driver", "chromedriver");
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case HTMLUNIT:
                driver = new HtmlUnitDriver();
                break;
            case HTMLUNITJS:
                driver = new HtmlUnitDriver(true);
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
        }
        // maximize browser's window on start
//		driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    private static enum Browsers {
        FIREFOX, CHROME, IE, HTMLUNIT, SAFARI, HTMLUNITJS;
    }
}