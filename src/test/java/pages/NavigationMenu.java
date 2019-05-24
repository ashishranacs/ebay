package pages;
import base.TestBase;
import locators.NavigationMenuLocators;

public class NavigationMenu extends TestBase 
{

	public void selectCategory(String item) 
	{
		method.click(NavigationMenuLocators.shopByCategory);
		method.click("//a[@class='scnd'][contains(text(),'"+item+"')]");
		//return new ProductsPage();
	}
}
