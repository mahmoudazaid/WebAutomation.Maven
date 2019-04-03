package Runner;

import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(

        glue = {"Runner","StepDefinitions"},
        features="src/test/resources/features/",
        strict = true,
        monochrome = true)

public class TestRunner {
    @Test(description = "Example of using TestNGCucumberRunner to invoke Cucumber")
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
}
