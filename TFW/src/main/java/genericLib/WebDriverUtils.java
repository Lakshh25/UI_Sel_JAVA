package genericLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {
	
	public void Dropdown(WebElement dropdown_path , String dropdown_value) {
		Select s = new Select(dropdown_path);
		s.selectByValue(dropdown_value);
	}
	//All other actions will be added here like pop-up handling, scrolling etc
	

}
