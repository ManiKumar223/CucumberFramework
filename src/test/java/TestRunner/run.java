package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Feature./Customer.feature",glue = "StepDefinition",
        dryRun = false,monochrome = true,plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
)
public class run {
}
