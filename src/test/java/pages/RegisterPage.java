package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.TestBase;
import locators.RegisterPageLocators;

public class RegisterPage extends TestBase {
	
	public RegisterPageLocators register;
	
	public RegisterPage() {
		
		register = new RegisterPageLocators();
		PageFactory.initElements(driver, this.register);
	}
	
	public void registration(String firstName, String lastName, String email, String password) {
		
		register.firstNameField.sendKeys(firstName);
		register.lastNameField.sendKeys(lastName);
		register.emailField.sendKeys(email);
		register.passwordField.sendKeys(password);
		wait.waitforElementClickable(register.createAccountBtn, 5);
		register.createAccountBtn.click();
	}
}
