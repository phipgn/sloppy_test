package phipgn.sloppy_test.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import phipgn.sloppy_test.pages.HomePage;

/**
 * Unit test for simple App.
 */
public class SearchTest extends BaseTest
{
	private HomePage homePage;
	
	@BeforeTest
	public void beforeTest() {
		initDriverAndLoadApplication();
		homePage = new HomePage(getDriver());
		waitUntilElementDisappears(homePage.loader);
		waitUntilElementIsClickable(homePage.searchCityButton);
	}
	
	@AfterTest
	public void afterTest() {
		closeDriver();
	}

	@Test
	public void test_U001_SearchValidCities() {
		String error = "";
		homePage.searchCity("London");
		waitUntilElementVisible(homePage.searchDropdownMenu);
		
		homePage.selectRandomDropdownOption();
		waitUntilElementDisappears(homePage.loader);
		
		Assert.assertTrue(error.equals(""));
	}
	
	@Test
	public void test_U002_SearchInvalidCities() {
		homePage.searchCity("~~~");
		waitUntilElementVisible(homePage.searchNotFoundText);
		Assert.assertTrue(homePage.isSearchNotFoundTextDisplayed());
	}

	@Override
	protected int getExlicitTimeout() {
		return 5;
	}
}
