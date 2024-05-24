package genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass extends PropertyFile {
	public WebDriver driver;
	ITestResult result;

	
	@BeforeMethod
	public void Open() throws IOException {
		
		//opening a Chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(GetProperty("url1"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void Close() throws IOException {
		Screenshot s = new Screenshot();
		result = Reporter.getCurrentTestResult();
		int status = result.getStatus();
		System.out.println("Status: "+status);
		if(status>0) {
			s.TakeScreenshot(driver);
			System.out.println("case failed");
		}
		
		driver.close();
	}

}
