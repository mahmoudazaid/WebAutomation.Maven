package Runner;
import cucumber.api.CucumberOptions;


@CucumberOptions(
        glue = {"StepDefinitions"},
        features="src/test/resources/features/",
        strict = true,
        monochrome = true)

public class TestRunner {
}
