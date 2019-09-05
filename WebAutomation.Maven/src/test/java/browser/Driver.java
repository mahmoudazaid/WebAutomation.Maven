//package browser;
//
//public class Driver {
//
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
//    public static void Visit(String _url) {
//        driver.get(_url);
//    }
//
//    public static void CloseBrowser() {
//        driver.quit();
//
//    }
//}