package Runner;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/",
        glue = {"StepDefinitions"},
        strict = true,
        monochrome = true)

public class TestRunner {
}
