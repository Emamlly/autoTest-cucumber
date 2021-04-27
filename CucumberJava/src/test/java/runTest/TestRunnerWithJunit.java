package runTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * junit 运行Cucumber.class
 * 根据features运行用例
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Features"
		,glue = {"stepDefinition"}
		,plugin = {"pretty","json:target/cucumber-report/json-files/cucumber.json","html:target/cucumber-report/cucumber.html"}
		,monochrome = true
		)
public class TestRunnerWithJunit {
	
}
