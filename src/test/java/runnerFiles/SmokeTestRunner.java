package runnerFiles;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
		tags = "", 
		features = "src/test/resources/features/Login.feature",
		glue = "stepDefinitions")
public class SmokeTestRunner extends AbstractTestNGCucumberTests {
 
}
