package tests.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-reports", "json:target/cucumber.json" },
    features = "resources/",
    glue = {"tests.steps"}
    //monochrome = true,
    //tags = {"~@ignore", "~@manual"}
)
public class CommonRunnerTest {

}
