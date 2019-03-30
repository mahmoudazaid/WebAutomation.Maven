package Runner;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import Browser.Driver;

public class Hooks {
    @Before()
    public void Before(){
        Driver.OpenBrowser("CHROME");
    }

    @After
    public void After()
    {
        Driver.close();
    }
}
