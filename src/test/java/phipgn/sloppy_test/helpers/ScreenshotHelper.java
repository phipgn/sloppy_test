package phipgn.sloppy_test.helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import phipgn.sloppy_test.drivers.BrowserFactory;

public class ScreenshotHelper {
	
	public static void takeScreenshot(WebDriver driver) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String fileName = DateTimeHelper.getCurrentDateTime() + ".png";
            FileUtils.copyFile(screenshot, new File("screenshots/" + fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
	}
}
