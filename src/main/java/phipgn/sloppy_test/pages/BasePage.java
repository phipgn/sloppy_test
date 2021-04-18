package phipgn.sloppy_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public abstract class BasePage {
	
	protected abstract WebDriver getDriver();
	
	protected void log(String message) {
		System.out.println(message);
		Reporter.log(message);
	}
	
	private WebElement findElement(By by) {
		return getDriver().findElement(by);
	}
	
	protected void inputText(By by, String text) {
		WebElement element = findElement(by);
		log("Inputting '" + text + "' into " + by);
		element.clear();
		element.sendKeys(text);
	}
	
	protected void click(By by) {
		WebElement element = findElement(by);
		log("Clicking on " + by);
		element.click();
	}
	
	protected void click(WebElement element) {
		log("Clicking on " + element);
		element.click();
	}
	
}
