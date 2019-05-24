package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.TestBase;
import locators.LoginPageLocators;


public class LoginPage extends TestBase {


	public void login(String email, String password) {

		method.type(LoginPageLocators.emailId_xp, email);
		method.type(LoginPageLocators.password_xp, password);
		method.click(LoginPageLocators.loginBtn_xp);
	}
}
