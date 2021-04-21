package phipgn.sloppy_test.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import phipgn.sloppy_test.helpers.FileHelper;
import phipgn.sloppy_test.helpers.StringHelper;
import phipgn.sloppy_test.pages.HomePage;

public class SearchTest extends BaseTest
{
	private HomePage homePage;
	
	@BeforeTest
	public void beforeTest() { }
	
	@BeforeMethod
	public void beforeMethod() {
		initDriverAndLoadApplication();
		homePage = new HomePage(getDriver());
		waitUntilElementDisappears(homePage.loader, 10);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		closeBrowser(result);
	}
	
	@DataProvider(name = "U001")
	public Object[][] u001_Data() { return FileHelper.getDataProvider("U001", testDataDir, this.getClass()); }
	@DataProvider(name = "U002")
	public Object[][] u002_Data() { return FileHelper.getDataProvider("U002", testDataDir, this.getClass()); }
	
	@Test(dataProvider = "U001", description = "As a user, I want to search weather with valid city names")
	public void U001(String query) {
		String error = "";
		homePage.searchCity(query);
		waitUntilElementVisible(homePage.searchDropdownOptions, 10);
		Assert.assertTrue(isElementDisplayed(homePage.searchDropdownOptions), "Search dropdown menu does not show up, test should be halted.");
		error += homePage.verifySearchDropdownOptions(query);
		
		String sanitizedSelectedCityName = StringHelper.sanitizeText(homePage.selectRandomDropdownOption());
		waitUntilElementDisappears(homePage.loader, 10);
		
		error += isElementDisplayed(homePage.cityNameText) ? "" : "City name is not displaying in content section.\n";
		String sanitizedCityName = StringHelper.sanitizeText(findElement(homePage.cityNameText).getText());
		error += sanitizedSelectedCityName.contains(sanitizedCityName) ? "" : "City name is displaying incorrectly in content section: " + sanitizedSelectedCityName + ", " + sanitizedCityName + ".\n";
		
		error += isElementDisplayed(homePage.hourlyForecastText) ? "" : "Hourly Forecast section is not displaying in content section.\n";
		error += isElementDisplayed(homePage.minuteForecastText) ? "" : "Minute Forecast section is not displaying in content section.\n";
		error += isElementDisplayed(homePage.eightDayForecastText) ? "" : "8-Day Forecast section is not displaying in content section.\n";
		error += isElementDisplayed(homePage.mapSection) ? "" : "Map section is not displaying in content section.\n";
		
		Assert.assertTrue(error.equals(""), "Found some errors: " + error);
	}
	
	@Test(dataProvider="U002", description = "As a user, I want to search weather with invalid city names")
	public void U002(String query) {
		homePage.searchCity(query);
		waitUntilElementVisible(homePage.searchNotFoundText, 10);
		Assert.assertTrue(isElementDisplayed(homePage.searchNotFoundText), "SearchNotFound text is supposed to be diplaying to user.");
	}
}
