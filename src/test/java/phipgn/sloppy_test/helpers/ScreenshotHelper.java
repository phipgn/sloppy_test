package phipgn.sloppy_test.helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {
	
	public static void takeScreenshot(WebDriver driver) {
		System.out.println("Test failed. Taking a screenshot...");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String fileName = DateTimeHelper.getCurrentDateTime() + ".png";
			String filePath = "screenshots/" + fileName;
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screen has been saved at: " + filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
	}
}
