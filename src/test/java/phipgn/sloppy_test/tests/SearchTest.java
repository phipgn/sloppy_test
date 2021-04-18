package phipgn.sloppy_test.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import phipgn.sloppy_test.helpers.StringHelper;
import phipgn.sloppy_test.pages.HomePage;

/**
 * Unit test for simple App.
 */
public class SearchTest extends BaseTest
{
	private HomePage homePage;
	
	@BeforeTest
	public void beforeTest() {
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		initDriverAndLoadApplication();
		homePage = new HomePage(getDriver());
		waitUntilElementDisappears(homePage.loader, 10);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			
		}
		closeBrowser();
	}
	
	@DataProvider(name="Valid cities")
	public Object[][] getValidCities() {
		return new Object[][] { 
//			{ "London" },
			{ "London, GB" },
//			{ "Haiphong" }, 
//			{ "Hanoi" } 
		};
	}

	@Test(dataProvider="Valid cities")
	public void test_U001_SearchValidCities(String inputCityName) {
		String error = "";
		homePage.searchCity(inputCityName);
		waitUntilElementVisible(homePage.searchDropdownOptions, 10);
		Assert.assertTrue(isElementDisplayed(homePage.searchDropdownOptions), "Search dropdown menu does not show up, text should be halted.");
		error += homePage.verifySearchDropdownOptions(inputCityName);
		
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
	
	@DataProvider(name="Invalid cities")
	public Object[][] getInvalidCities() {
		return new Object[][] { 
			{ "in flames" },
			{ "pod" }
		};
	}
	
	@Test(dataProvider="Invalid cities")
	public void test_U002_SearchInvalidCities(String inputCityName) {
		homePage.searchCity(inputCityName);
		waitUntilElementVisible(homePage.searchNotFoundText, 10);
		Assert.assertTrue(isElementDisplayed(homePage.searchNotFoundText));
	}
}
