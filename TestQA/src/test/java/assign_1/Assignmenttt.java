package assign_1;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import generLib.Baseclass;

public class Assignmenttt extends Baseclass{
	
	
	@Test
	public void Assignment_1() throws InterruptedException, AWTException, IOException {
		//hovering on MEN's option
		WebElement ele = driver.findElement(By.xpath("//span[@aria-label='MEN']"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		
		//hovering on BRAND's option
		WebElement ele1 = driver.findElement(By.xpath("(//a[text()='BRANDS'])[1]"));
		a.moveToElement(ele1).perform();
		
		//clicking on GAP brand
		WebElement ele2 = driver.findElement(By.xpath("(//a[text()='GAP'])[1]"));
		ele2.click();
		
		//clicking on sort by button
		WebElement ele3 = driver.findElement(By.xpath("//select[@id='sortBy']"));
		ele3.click();
		
		//Clicking on low to high
		WebElement ele4 = driver.findElement(By.xpath("//option[text()='Price (lowest first)']"));
		ele4.click();
		Thread.sleep(5000);
		
		//Expanding SIZE filter option
		WebElement ele5 = driver.findElement(By.xpath("//span[text()='size & fit']"));
		ele5.click();
		
		//Selecting M size
		WebElement ele6 = driver.findElement(By.xpath("//label[@for='M']"));
		ele6.click();
		Thread.sleep(5000);
		
		//Scrolling and clicking the 15th product
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement ele7 = driver.findElement(By.xpath("//div[text()='Cotton Boxers with Logo Waistband']"));
		System.out.println(ele7.getLocation().getX());;
		System.out.println(ele7.getLocation().getY());;
		jse.executeScript("window.scrollBy(722,2030)");
		ele7.click();
		
		//Switching to different window and capturing the price of the product
		Set<String> handles = driver.getWindowHandles();
		for(String h: handles) {
			if(h.equals(driver.getWindowHandle())) {
				continue;
			}
			else {
				driver.switchTo().window(h);
			}
		}
		WebElement ele8 = driver.findElement(By.xpath("(//div[text()='₹360'])[1]"));
		String price = ele8.getText();
		System.out.println("The price of the product is: "+ele8.getText());
		
		//Taking screenshot of the product page
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Lakshmikanth B\\eclipse-workspace\\TestQA\\Screenshot\\ScreenShot.png");
		FileUtils.copyFile(src, dest);
		
		//Adding the product of size M to the cart
		WebElement ele9 = driver.findElement(By.xpath("(//div[@data-index='2'])[3]"));
		ele9.click();
		WebElement ele10 = driver.findElement(By.xpath("//div[@class='btn-gold']"));
		ele10.click();
		Thread.sleep(3000);
		
		//navigating to Bag/cart
		WebElement ele11 = driver.findElement(By.xpath("//div[@class='btn-cart ']"));
		ele11.click();
		Thread.sleep(2000);
		
		//comparing the product price with the order total
		WebElement ele12 = driver.findElement(By.xpath("//span[text()='₹459']"));
		String order_total = ele12.getText();
		System.out.println("The product price is: "+price+", and the order total price is: "+order_total);
		if(price.equals(order_total)) {
			System.out.println("Prices are same");
		}
		else {
			System.out.println("Prices are different");
		}
		
		//Report captured using testng and related report is found in TestQA\test-output\emailable-report.html
		driver.quit();
		
	}
	
	@Test
	public void Assignmenttt_2() throws InterruptedException {
		
		//Typing Levis t-shirt and searching the same
		WebElement ele1 = driver.findElement(By.xpath("//input[@placeholder='Search AJIO']"));
		ele1.sendKeys("Levis t-shirt");
		WebElement ele2 = driver.findElement(By.xpath("//span[@class='ic-search']"));
		ele2.click();
		Thread.sleep(3000);
		
		//Apllying color filter Black
		WebElement ele3 = driver.findElement(By.xpath("//span[text()='colors']"));
		ele3.click();
		WebElement ele4 = driver.findElement(By.xpath("//label[@For='Black']"));
		ele4.click();
		Thread.sleep(3000);
		
		//Applying Size filter
		WebElement ele5 = driver.findElement(By.xpath("//span[text()='size & fit']"));
		ele5.click();
		WebElement ele6 = driver.findElement(By.xpath("//label[@For='M']"));
		ele6.click();
		Thread.sleep(3000);
		
		//Removing Black applied filter
		ele4.click();
		
		//Scrolling to 20th product
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement ele7 = driver.findElement(By.xpath("//img[@alt='Product image of LEVIS Men Slim Fit Crew-Neck T-Shirt']"));
		System.out.println(ele7.getLocation().getX());
		System.out.println(ele7.getLocation().getY());
		jse.executeScript("window.scrollBy(599,330)");
		
		//Hovering on 20th product and clicking on QUICK VIEW
		Actions act = new Actions(driver);
		act.moveToElement(ele7).perform();
		WebElement ele8 = driver.findElement(By.xpath("(//div[@aria-label='Quick View'])[20]"));
		ele8.click();

	}

}
