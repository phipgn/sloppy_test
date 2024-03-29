package phipgn.sloppy_test.bdd.steps;

import org.testng.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import phipgn.sloppy_test.helpers.StringHelper;
import phipgn.sloppy_test.pages.HomePage;
import phipgn.sloppy_test.tests.BaseTest;

public class SearchCitySteps extends BaseTest {

	private HomePage homePage;
	private String error;

	@Before(order = 1)
	public void beforeScenario() {
		error = "";
		setUp();
		homePage = new HomePage(ui.getDriver());
	}

	@After
	public void afterScenario(Scenario scenario) {
		ui.close(scenario);
	}

	@Given("^User waits for the loader to be disappeared$")
	public void user_waits_for_the_loader_to_be_disappeared() {
		ui.waitUntilElementDisappears(homePage.loader, 10);
	}

	@Given("^User searches weather for (.+)$")
	public void user_searches_weather_for(String inputCityName) {
		homePage.searchCity(inputCityName);
	}

	@Then("^User should see a valid search dropdown menu for (.+)$")
	public void user_should_see_a_valid_search_dropdown_menu(String inputCityName) {
		ui.waitUntilElementVisible(homePage.searchDropdownOptions, 10);
		Assert.assertTrue(ui.isElementDisplayed(homePage.searchDropdownOptions), "Search dropdown menu does not show up, test should be halted.");
		error += homePage.verifySearchDropdownOptions(inputCityName);
	}

	@Then("User selects a random dropdown option")
	public void user_selects_a_random_dropdown_option() {
		String sanitizedSelectedCityName = StringHelper.sanitizeText(homePage.selectRandomDropdownOption());
		String originalText = ui.findElement(homePage.cityNameText).getText();
		ui.waitUntilElementTextChanged(homePage.cityNameText, originalText, 10);
		
		String sanitizedCityName = StringHelper.sanitizeText(ui.findElement(homePage.cityNameText).getText());
		error += sanitizedSelectedCityName.contains(sanitizedCityName) ? ""
				: "City name is displaying incorrectly in content section: " + sanitizedSelectedCityName + ", "
						+ sanitizedCityName + ".\n";
	}

	@Then("Hourly Forecast section should be diplaying in content section")
	public void hourly_Forecast_section_should_be_diplaying_in_content_section() {
		error += ui.isElementDisplayed(homePage.hourlyForecastText) ? ""
				: "Hourly Forecast section is not displaying in content section.\n";
	}

	@Then("Eight-Day Forecast section should be diplaying in content section")
	public void eight_Day_Forecast_section_should_be_diplaying_in_content_section() {
		error += ui.isElementDisplayed(homePage.eightDayForecastText) ? ""
				: "8-Day Forecast section is not displaying in content section.\n";
	}

	@Then("Map should be displaying in content section")
	public void map_should_be_displaying_in_content_section() {
		error += ui.isElementDisplayed(homePage.mapSection) ? "" : "Map section is not displaying in content section.\n";
	}

	@Then("All the verifications should be passed")
	public void all_the_verifications_should_be_passed() {
		Assert.assertTrue("".equals(error));
	}

	@Then("^User should see search not found message$")
	public void user_should_see_search_not_found_message() {
		ui.waitUntilElementVisible(homePage.searchNotFoundText, 10);
		Assert.assertTrue(ui.isElementDisplayed(homePage.searchNotFoundText), "SearchNotFound text is supposed to be diplaying to user.");
	}
}
