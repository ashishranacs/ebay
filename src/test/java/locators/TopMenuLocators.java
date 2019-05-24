package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuLocators {

	
	
	public static String signInLink = "//a[contains(.,'Sign in')]";
	public static String registerLink = "//a[contains(.,'register')]";
	public static String dailyDealsLink = "(//a[contains(.,'Daily Deals')])[1]";
	public static String notificationLink = "//i[contains(.,'Notification')]";
	public static String cartIcon = "//i[contains(@class,'gh-sprRetina ')]";
	public static String username = "//*[@id=\"gh-ug\"]";
	public static String signoutLink = "//a[contains(.,'Sign out')]";
	
//	@FindBy(xpath="//a[contains(.,'Sign in')]")
//	public WebElement signInLink;
//	
//	@FindBy(xpath = "//a[contains(.,'register')]")
//	public WebElement registerLink;
//	
//	@FindBy(xpath = "(//a[contains(.,'Daily Deals')])[1]")
//	public WebElement dailyDealsLink;
//	
//	@FindBy(xpath = "//i[contains(.,'Notification')]")
//	public WebElement notificationLink;
//	
//	@FindBy(xpath="//i[contains(@class,'gh-sprRetina ')]")
//	public WebElement cartIcon;
//	
//	@FindBy(xpath="//*[@id=\"gh-ug\"]")
//	public WebElement username;
//	
//	@FindBy(xpath = "//a[contains(.,'Sign out')]")
//	public WebElement signoutLink;
}
