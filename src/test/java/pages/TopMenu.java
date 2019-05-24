package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import locators.TopMenuLocators;
import utilities.WrapperMethods;

public class TopMenu extends TestBase {
	
//	private WebDriver driver; 
//	
//	public TopMenu(WebDriver driver) {
//		this.driver = driver;
//	}

	public LoginPage gotoLoginPage() 
	{
		method.click(TopMenuLocators.signInLink);
		return new LoginPage();
	}

	public RegisterPage gotoRegisterPage() 
	{
		method.click(TopMenuLocators.registerLink);
		return new RegisterPage();
	}

	public DailydealsPage gotoDailyDealsPage() 
	{
		TestBase.method.click(TopMenuLocators.dailyDealsLink);
		return new DailydealsPage();
	}

	public CartPage gotoCartPage() 
	{
		method.click(TopMenuLocators.cartIcon);
		return new CartPage();
	}

	public void logout() 
	{
		method.mouseOver(TopMenuLocators.username);
		method.click(TopMenuLocators.signoutLink);
	}
}
