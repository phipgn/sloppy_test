package phipgn.sloppy_test.bdd.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/phipgn/sloppy_test/bdd/features", 
		glue = { "phipgn.sloppy_test.bdd.steps" })
public class TestRunner {

}
