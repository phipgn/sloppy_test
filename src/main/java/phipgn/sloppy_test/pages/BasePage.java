package phipgn.sloppy_test.pages;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class BasePage {
	
	protected void log(String message) {
		Reporter.log(message);
	}
	
	protected void inputText(WebElement element, String text) {
		log("Inputting " + text + " into " + element);
		element.clear();
		element.sendKeys(text);
	}
	
	protected void click(WebElement element) {
		log("Clicking on " + element);
		element.click();
	}
	
}
