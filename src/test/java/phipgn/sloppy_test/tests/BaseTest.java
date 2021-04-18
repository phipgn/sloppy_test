package phipgn.sloppy_test.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import phipgn.sloppy_test.drivers.BrowserFactory;
import phipgn.sloppy_test.drivers.BrowserName;

public abstract class BaseTest {
	protected void initDriverAndLoadApplication() {
		BrowserFactory.initBrowser(BrowserName.CHROME);
		BrowserFactory.maximize();
		BrowserFactory.loadApplication("https://openweathermap.org/");
	}
	
	protected abstract int getExlicitTimeout();
	
	protected WebDriver getDriver() {
		return BrowserFactory.getDriver();
	}
	
	protected void closeDriver() {
		BrowserFactory.closeDriver();
	}
	
	protected void waitUntilElementDisappears(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), getExlicitTimeout());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	protected void waitUntilElementVisible(final By by) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(getExlicitTimeout()))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
	    wait.until(new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver t) {
				return getDriver().findElements(by).size() > 0;
			}
	    	
	    });
	}
	
	protected void waitUntilElementIsClickable(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), getExlicitTimeout());
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
}
