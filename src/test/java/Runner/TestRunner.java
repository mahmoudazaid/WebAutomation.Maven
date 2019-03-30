package Runner;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"StepDefinitions"},
        features="src/test/resources/features/",
        strict = true,
        monochrome = true)

public class TestRunner {
}
