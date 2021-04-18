package phipgn.sloppy_test.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private WebDriver driver;
	
	public HomePage(WebDriver _driver) {
		driver = _driver;
	}
	
//	By searchCityInput = By.cssSelector("input[placeholder='Search city']");
	public By searchCityInput = By.xpath("//input[@placeholder='Search city']");
	public By searchCityButton = By.cssSelector(".search button[type='submit']");
	public By searchNotFoundText = By.cssSelector(".sub.not-found.notFoundOpen");
	public By searchDropdownMenu = By.cssSelector(".search .search-dropdown-menu");
	public By searchDropdownOptions = By.cssSelector(".search .search-dropdown-menu li");
	public By loader = By.cssSelector(".owm-loader");
	
	public void searchCity(String cityName) {
		inputText(driver.findElement(searchCityInput), cityName);
		click(driver.findElement(searchCityButton));
	}
	
	public void selectRandomDropdownOption() {
		List<WebElement> searchDropdownItems = driver.findElements(searchDropdownOptions);
		if (searchDropdownItems.size() == 0) {
			log("Cannot find any dropdown items for " + searchDropdownOptions);
			return;
		}
		Random rand = new Random();
		int randomIndex = rand.nextInt(searchDropdownItems.size());
		click(searchDropdownItems.get(randomIndex));
	}
	
	public boolean isSearchNotFoundTextDisplayed() {
		return driver.findElements(searchNotFoundText).size() > 0;
	}
}
