package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.BaseClass;

public class TFWLoginPage extends BaseClass{
	

	public TFWLoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='userName']")
	private WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement Password;
	
	@FindBy(xpath="//button[text() = 'Sign In']")
	private WebElement Signin_button;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	private WebElement ForgotPassword;
	
	

	
	public void UserName(String username) throws InterruptedException {
		Thread.sleep(3000);
		Username.sendKeys(username);

	}
	
	public void PassWord(String password) throws InterruptedException {
		Thread.sleep(3000);
		Password.sendKeys(password);

	}
	
	public void SignInButton() throws InterruptedException {
		Thread.sleep(3000);
		Signin_button.click();

	}

}
