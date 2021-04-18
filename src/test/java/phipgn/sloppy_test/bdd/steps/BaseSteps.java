package phipgn.sloppy_test.bdd.steps;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import phipgn.sloppy_test.drivers.BrowserFactory;
import phipgn.sloppy_test.helpers.ConfigFileHelper;

public class BaseSteps {
	protected void initDriverAndLoadApplication() {
		ConfigFileHelper config = new ConfigFileHelper();
		BrowserFactory.initBrowser(config.getProperty(ConfigFileHelper.KEY_BROWSER));
		BrowserFactory.maximize();
		BrowserFactory.loadApplication(config.getProperty(ConfigFileHelper.KEY_URL));
	}
	
	protected WebDriver getDriver() {
		return BrowserFactory.getDriver();
	}
	
	protected void closeBrowser() {
		BrowserFactory.closeDriver();
		BrowserFactory.setDriver(null);
	}
	
	protected void waitUntilElementDisappears(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
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
}
