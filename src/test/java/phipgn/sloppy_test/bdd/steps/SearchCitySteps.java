package phipgn.sloppy_test.bdd.steps;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import phipgn.sloppy_test.pages.HomePage;

public class SearchCitySteps extends BaseSteps {
	
	private HomePage homePage;
	
	@Before(order=1)
	public void beforeScenario() {
		initDriverAndLoadApplication();
		homePage = new HomePage(getDriver());
		waitUntilElementDisappears(homePage.loader, 10);
	}
	
	@After
	public void afterScenario() {
	    closeBrowser();
	}

	@Given("^User searches weather for (.+)$")
	public void user_searches_weather_for(String inputCityName) {
		homePage.searchCity(inputCityName);
		waitUntilElementVisible(homePage.searchDropdownOptions, 10);
	}
	
	@Then("^User should see a valid search dropdown menu for (.+)$")
	public void user_should_see_a_valid_search_dropdown_menu(String inputCityName) {
		Assert.assertTrue(isElementDisplayed(homePage.searchDropdownOptions));
		String error = homePage.verifySearchDropdownOptions(inputCityName);
		Assert.assertTrue(error.equals(""));
	}
}
