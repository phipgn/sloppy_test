package phipgn.sloppy_test.bdd.runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	features = "src/test/java/phipgn/sloppy_test/bdd/features", 
	glue = { "phipgn.sloppy_test.bdd.steps" }, 
	monochrome = true, 
	dryRun = false,
	plugin = { "pretty",
			"html:target/cucumber-reports",
			"junit:target/cucumber-reports/Cucumber.xml",
			"json:target/cucumber-reports/Cucumber.json"},
	tags = { "@searchCity" }
)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {
}
