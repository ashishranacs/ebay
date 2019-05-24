package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	
	
	public static String emailId_xp = "//input[@name='userid']";
	public static String password_xp = "//input[@name='pass']";
	public static String loginBtn_xp = "//button[@type='submit']";
	
//	@FindBy(xpath="//input[@name='userid']")
//	public WebElement emailId;
//	
//	@FindBy(xpath="//input[@name='pass']")
//	public WebElement password;
//	
//	@FindBy(xpath="//button[@type='submit']")
//	public WebElement loginBtn;
}
