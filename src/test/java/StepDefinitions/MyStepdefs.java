package StepDefinitions;

import Browser.Driver;
import cucumber.api.java.en.Given;

public class MyStepdefs {

    @Given("^I am on Home page$")
    public void given() throws Throwable {
        Driver.Visit("http://www.linkedin.com");
    }
}
