package phipgn.sloppy_test.drivers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class BrowserFactory {
	private WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null)
			throw new NullPointerException("The WebDriver browser instance was not initialized. You should first call the method InitBrowser.");
		return driver;
	}

	public void setDriver(WebDriver _driver) {
		driver = _driver;
	}

	public void initBrowser(String browserName) {
		switch (browserName) {
		case BrowserName.CHROME:
			ChromeDriverService chService = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("drivers/chromedriver.exe")).usingAnyFreePort().build();
			if (driver == null)
				driver = new ChromeDriver(chService);
			break;
		case BrowserName.FIREFOX:
			GeckoDriverService geckoService = new GeckoDriverService.Builder()
			.usingDriverExecutable(new File("drivers/geckodriver.exe")).usingAnyFreePort().build();
			if (driver == null)
				driver = new FirefoxDriver(geckoService);
			break;
		default:
			break;
		}
	}
	
	public void loadApplication(String url) {
		driver.navigate().to(url);
	}
	
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	public void closeDriver() {
		driver.close();
	}
	
	public void quitDriver() {
		driver.quit();
	}

}
