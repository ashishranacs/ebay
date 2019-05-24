package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageLocators {
	
	
	@FindBy(xpath="//input[@name='firstname']")
	public WebElement firstNameField;
	
	@FindBy(xpath="//input[@name='lastname']")
	public WebElement lastNameField;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement emailField;
	
	@FindBy(xpath="//input[@name='PASSWORD']")
	public WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit'][contains(.,'Create account')]")
	public WebElement createAccountBtn;
	
}
