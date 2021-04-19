package phipgn.sloppy_test.tests;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import cucumber.api.Scenario;
import phipgn.sloppy_test.drivers.BrowserFactory;
import phipgn.sloppy_test.helpers.ConfigFileHelper;
import phipgn.sloppy_test.helpers.ScreenshotHelper;

public abstract class BaseTest {
	protected void initDriverAndLoadApplication() {
		ConfigFileHelper config = new ConfigFileHelper();
		BrowserFactory.initBrowser(config.getProperty(ConfigFileHelper.KEY_BROWSER));
		BrowserFactory.maximize();
		BrowserFactory.loadApplication(config.getProperty(ConfigFileHelper.KEY_URL));
	}
	
	protected WebDriver getDriver() {
		return BrowserFactory.getDriver();
	}
	
	protected void closeBrowser(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE)
			ScreenshotHelper.takeScreenshot();
		BrowserFactory.closeDriver();
		BrowserFactory.setDriver(null);
	}
	
	protected void closeBrowser(Scenario result) {
		if (result.isFailed())
			ScreenshotHelper.takeScreenshot();
		BrowserFactory.closeDriver();
		BrowserFactory.setDriver(null);
	}
	
	protected void waitUntilElementDisappears(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	protected void waitUntilElementVisible(final By by, int timeout) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
	    wait.until(new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver t) {
				return getDriver().findElements(by).size() > 0;
			}
	    	
	    });
	}
	
	protected boolean isElementDisplayed(By by) {
		return getDriver().findElements(by).size() > 0;
	}
	
	protected WebElement findElement(By by) {
		return getDriver().findElement(by);
	}
}
