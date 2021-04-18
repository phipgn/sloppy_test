package phipgn.sloppy_test.drivers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BrowserFactory {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null)
			throw new NullPointerException("The WebDriver browser instance was not initialized. You should first call the method InitBrowser.");
		return driver;
	}

//	public void setDriver(WebDriver _driver) {
//		driver = _driver;
//	}

	public static void initBrowser(BrowserName browserName) {
		switch (browserName) {
		case CHROME:
			ChromeDriverService chService = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("drivers/chromedriver.exe")).usingAnyFreePort().build();
			if (driver == null)
				driver = new ChromeDriver(chService);
			break;
		case FIREFOX:
			break;
		default:
			break;
		}
	}
	
	public static void loadApplication(String url) {
		driver.navigate().to(url);
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void closeDriver() {
		driver.close();
		driver.quit();
	}

}
