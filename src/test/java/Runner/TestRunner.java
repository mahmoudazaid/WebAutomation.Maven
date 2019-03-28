package Runner;

import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.CucumberOptions;
import org.testng.annotations.Test;


@CucumberOptions(plugin = {"html:target/cucumber-html-report","junit:target/cucumber-junit.xml",
        "json:target/cucumber.json","pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json"},
        glue = {"StepDefinitions", "runner"},
        features="src/test/resources/features/",
        strict = true,
        monochrome = true)

public class TestRunner {
}
