package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLib.BaseClass;
import genericLib.PropertyFile;
import pomPages.TFWHomePage;
import pomPages.TFWLoginPage;

public class LoginPageCases extends BaseClass{
	
	
	@Test(priority = 0)
	public void LoginPositiveCase() throws IOException, InterruptedException {
		TFWHomePage hp = new TFWHomePage(driver);
		TFWLoginPage loginpage = new TFWLoginPage(driver);
		PropertyFile pf = new PropertyFile();
		hp.Click_PayRent_button();
		System.out.println("Pay rent button clicked");
		loginpage.UserName(pf.GetProperty("username_pos"));
		System.out.println("username entered");
		loginpage.PassWord(pf.GetProperty("password_pos"));
		System.out.println("password entered");
		loginpage.SignInButton();
		System.out.println("clicked signin button");
		Thread.sleep(3000);
		String expected_url = pf.GetProperty("expected_url");
		System.out.println("Expected url "+expected_url );
		String actual_url = driver.getCurrentUrl();
		System.out.println("Actual url "+actual_url);
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(actual_url, expected_url);
		s.assertAll();
	}
	
	@Test(priority = 1)
	public void LoginNegativeCase() throws IOException, InterruptedException {
		TFWHomePage hp = new TFWHomePage(driver);
		TFWLoginPage loginpage = new TFWLoginPage(driver);
		PropertyFile pf = new PropertyFile();
		hp.Click_PayRent_button();
		System.out.println("Pay rent button clicked");
		loginpage.UserName(pf.GetProperty("username_neg"));
		System.out.println("username enetered");
		loginpage.PassWord(pf.GetProperty("password_neg"));
		System.out.println("password entered");
		loginpage.SignInButton();
		System.out.println("clicked signin button");
		Thread.sleep(3000);
		String expected_url_neg = pf.GetProperty("expected_url");
		System.out.println("Expected url "+expected_url_neg );
		String actual_url_neg = driver.getCurrentUrl();
		System.out.println("Actual url "+actual_url_neg);
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(actual_url_neg, expected_url_neg);
		s.assertAll();
	}
	
	

}
