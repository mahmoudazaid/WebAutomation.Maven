package stepDefinitions;

import browser.Driver;
import io.cucumber.java.Before;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import stepDefinitions.Hooks;

@CucumberOptions(features = "src/test/java/features",
        glue = {"runner","stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-html-report"})
public class TestRunner extends Hooks {

    @Before
    public static void openBrowser(@Optional("Chrome") String browserName) {
        Driver.openBrowser(browserName);
    }

}
