package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import locators.ProductDetailsPageLocators;

public class ProductDetailsPage extends TestBase{
	
	
//	public void selectQuantity(String value) 
//	{
//		WebElement element = driver.findElement(By.xpath(ProductDetailsPageLocators.qty));
//		dropdown.selectUsingVisibleText(element, value);
//	}
	public void buyProduct() 
	{
		method.click(ProductDetailsPageLocators.buyNow);
	}
	
	public void addToCart() 
	{
		method.click(ProductDetailsPageLocators.addToCart);
	}
	
	public void addToWishList() 															
	{
		method.click(ProductDetailsPageLocators.addtoWishList);
	}
}
	