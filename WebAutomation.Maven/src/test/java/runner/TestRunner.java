package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefinitions.Hooks;

    @CucumberOptions(features = "src/test/java/features",
            glue = {"runner","stepDefinitions"},
            plugin = {"pretty", "html:target/cucumber-html-report"})
    public class TestRunner extends Hooks {

}
