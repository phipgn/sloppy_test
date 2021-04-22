package phipgn.sloppy_test.drivers;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import cucumber.api.Scenario;
import phipgn.sloppy_test.helpers.ScreenshotHelper;
import phipgn.sloppy_test.helpers.StringHelper;

public class BrowserFactory {
	private WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null)
			throw new NullPointerException("The WebDriver browser instance was not initialized. You should first call the method InitBrowser.");
		return driver;
	}

	public void initBrowser(String browserName) {
		switch (browserName) {
		case BrowserName.CHROME:
			ChromeDriverService chService = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("drivers/chromedriver.exe")).usingAnyFreePort().build();
			if (driver == null) {
				System.out.println("Initializing Chrome driver...");
				driver = new ChromeDriver(chService);				
			}				
			break;
		case BrowserName.FIREFOX:
			GeckoDriverService geckoService = new GeckoDriverService.Builder()
			.usingDriverExecutable(new File("drivers/geckodriver.exe")).usingAnyFreePort().build();
			if (driver == null) {
				System.out.println("Initializing Gecko driver...");
				driver = new FirefoxDriver(geckoService);
			}
			break;
		default:
			break;
		}
	}
	
	public void loadApplication(String url) {
		driver.get(url);
	}
	
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	public void close(Scenario result) {
		if (result.isFailed())
			ScreenshotHelper.takeScreenshot(driver);
		System.out.println("Closing driver...");
		driver.close();
		driver = null;
	}
	
	public void close(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE)
			ScreenshotHelper.takeScreenshot(driver);
		System.out.println("Closing driver...");
		driver.close();
		driver = null;
	}
	
	public void quitDriver() {
		driver.quit();
	}

	public void waitUntilElementDisappears(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));		
	}

	public void waitUntilElementVisible(final By by, int timeout) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
	    wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver t) {
				return driver.findElements(by).size() > 0;
			}	    	
	    });
	}
	
	public void waitUntilElementTextChanged(final By by, String _originalText, int timeout) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
	    wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver t) {
				String actualText = StringHelper.sanitizeText(driver.findElement(by).getText());
				String originalText = StringHelper.sanitizeText(_originalText);
				return !originalText.equals(actualText);
			}	    	
	    });
	}
	
	public boolean isElementDisplayed(By by) {
		return driver.findElements(by).size() > 0;
	}
	
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
}
