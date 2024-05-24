package genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot extends BaseClass{
	
	public void TakeScreenshot(WebDriver driver) throws IOException {
		
		//Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot =(TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		File dest = new File("C:\\Users\\Lakshmikanth B\\eclipse-workspace\\TFW\\Screenshots\\Screenshot.png");
		FileUtils.copyFile(source, dest);
		System.out.println("Screenshot is captured");

	}

}
