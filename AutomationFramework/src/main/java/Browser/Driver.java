package Browser;

public class Driver {

    public static IWebDriver WebDriver;
    string Firefox="Firefox";
    string Chrome = "Chrome";

    public static IWebDriver OpenBrowser(string browserName)
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

    public static void Visit(string URL)
    {
        WebDriver.get(URL);
    }

    public static void CloseBrowser()
    {
        WebDriver.quite();
    }
}
