package Browser;

public class Driver {

    public static IWebDriver WebDriver;
    public static final String Firefox="Firefox";
    public static final String Chrome = "Chrome";

    public static IWebDriver OpenBrowser(String browserName)
    {
        WebDriver = null;
        switch (browserName)
        {
            case Firefox:

                if (WebDriver == null)
                {
                    WebDriver = new FirefoxDriver();
                }
                break;

            case Chrome:

                if (WebDriver == null)
                {
                    WebDriver = new ChromeDriver();
                }

                break;

        }
        WebDriver.manage().window().maximize();
        return WebDriver;
    }

    public static void Visit(String URL)
    {
        WebDriver.get(URL);
    }

    public static void CloseBrowser()
    {
        WebDriver.quite();
    }
}
