package phipgn.sloppy_test.pages;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import phipgn.sloppy_test.helpers.StringHelper;

public class HomePage extends BasePage {

	private WebDriver driver;
	
	public HomePage(WebDriver _driver) {
		driver = _driver;
	}
	
	@Override
	protected WebDriver getDriver() {
		return driver;
	}
	
	/* Search container */
	public By searchCityInput = By.xpath("//input[@placeholder='Search city']");
	public By searchCityButton = By.cssSelector(".search button[type='submit']");
	public By searchNotFoundText = By.cssSelector(".sub.not-found.notFoundOpen");
	public By searchDropdownMenu = By.cssSelector(".search .search-dropdown-menu");
	public By searchDropdownOptions = By.cssSelector(".search .search-dropdown-menu li");
	public By loader = By.cssSelector(".owm-loader");
	
	/* Content section */
	public By cityNameText = By.cssSelector(".section-content h2");
	public By hourlyForecastText = By.xpath("//div[@id='weather-widget']/div[@class='section-content']//h3[text()='Hourly forecast']");
	public By minuteForecastText = By.xpath("//div[@id='weather-widget']/div[@class='section-content']//h3[text()='Minute forecast']");
	public By eightDayForecastText = By.xpath("//div[@id='weather-widget']/div[@class='section-content']//h3[text()='8-day forecast']");
	public By mapSection = By.cssSelector(".map-section");
	
	public void searchCity(String cityName) {
		inputText(searchCityInput, cityName);
		click(searchCityButton);
	}
	
	public String selectRandomDropdownOption() {
		List<WebElement> searchDropdownItems = driver.findElements(searchDropdownOptions);
		if (searchDropdownItems.size() == 0) {
			log("Cannot find any dropdown items for " + searchDropdownOptions);
			return null;
		}
		Random rand = new Random();
		int randomIndex = rand.nextInt(searchDropdownItems.size());
		
		WebElement element = searchDropdownItems.get(randomIndex);
		String selectedCityName = getCityName(element);
		click(element);
		return selectedCityName;
	}
	
	private String getCityName(WebElement dropdownOption) {
		String optionText = dropdownOption.getText();
		String[] segments = optionText.split("\n");
		return segments[0];
	}
	
	public String verifySearchDropdownOptions(String inputCityName) {
		String error = "";
		List<WebElement> dropdownOptions = getDriver().findElements(searchDropdownOptions);
		error += dropdownOptions.size() > 0 ? "" : "There's no items in search dropdown menu.\n";
		
		for (WebElement option : dropdownOptions) {
			String optionText = option.getText();
			String[] segments = optionText.split("\n");
			
			String cityName = segments[0];
			String sanitizedCityName = StringHelper.sanitizeText(cityName);
			String sanitizedInputCityName = StringHelper.sanitizeText(inputCityName);
			String temperature = segments[1];
			String latLong = segments[2];
			
			error += isValidCityName(cityName) ? "" : "'" + cityName + "' is not a valid city name.\n";
			error += sanitizedCityName.contains(sanitizedInputCityName) ? "" : "'" + cityName + "' seems not to be related to the input search text ('" + inputCityName + "')\n";
			error += isValidTemperature(temperature) ? "" : "'" + temperature + "' seems not to be in the correct format.\n";
			error += isValidLatLong(latLong) ? "" : "'" + latLong + "' seems not to be in the correct format.\n";
		}
		
		return error;
	}
	
	private boolean isValidCityName(String text) {
		Pattern p = Pattern.compile("^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸÐĐ ]+, ?[A-Z]{2}$");
		Matcher m = p.matcher(text);
		return m.find();
	}
	
	private boolean isValidTemperature(String text) {
		Pattern p = Pattern.compile("^-?\\d+°[FC]{1}$");
		Matcher m = p.matcher(text);
		return m.find();
	}
	
	private boolean isValidLatLong(String text) {
		Pattern p = Pattern.compile("^(-?\\d{1,3}.\\d{1,3}(, )?){2}$");
		Matcher m = p.matcher(text);
		return m.find();
	}
}
