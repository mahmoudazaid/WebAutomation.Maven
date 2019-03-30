package StepDefinitions;

import cucumber.api.java.en.Given;

import static Browser.Driver.Visit;

public class MyStepdefs {
    @Given("I am on Home page")
    public void i_am_on_Home_page() {
        Visit("http://www.linkedin.com");
    }
}
