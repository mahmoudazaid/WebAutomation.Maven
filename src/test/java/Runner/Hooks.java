package Runner;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import Browser.Driver;

public class Hooks {
    String browserName = System.getProperty("BROWSER");

    @Before()
    public void Before(){
        Driver.OpenBrowser(browserName);
    }

    @After
    public void After()
    {
        Driver.CloseBrowser();
    }
}
