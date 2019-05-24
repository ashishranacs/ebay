package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import locators.ProductsPageLocator;

public class ProductsPage extends TestBase {
	

	public void selectProduct(String locator) 
	{	
//		WebElement element = driver.findElement(By.xpath("//h3[contains(text(),"+locator+")]"));
////		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//jshelper.scrollDownVertically();
		//wait.waitForElement(element, 5, 500);
		method.click("//div[@class='b-visualnav__title'][contains(text(),'"+locator+"')]");
		
	}
	
//	public void gotoHomePage() {
//		
//	}
}

//li[@id='w12-items[Apple iPhone 4S Mobile Phone 8GB 16GB 32GB Sim Free Factory Unlocked Smartphone]']//h3

