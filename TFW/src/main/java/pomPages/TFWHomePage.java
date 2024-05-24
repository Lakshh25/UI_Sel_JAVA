package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.BaseClass;

public class TFWHomePage extends BaseClass {
	
	public TFWHomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[text()='Pay Rent']")
	private WebElement PayRent_button;
	
	

	public void Click_PayRent_button() throws InterruptedException {
		Thread.sleep(3000);
		PayRent_button.click();
	}

}
