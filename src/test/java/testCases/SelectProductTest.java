package testCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.NavigationMenu;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import pages.TopMenu;
import utilities.TestUtils;

public class SelectProductTest {
	
	LoginPage loginpage;
	NavigationMenu navigation = new NavigationMenu();
	ProductsPage productsPage = new ProductsPage();
	TopMenu topmenu = new TopMenu();
	ProductDetailsPage product = new ProductDetailsPage();
	
	@Test(dataProviderClass=TestUtils.class, dataProvider="dp")
	public void login(Hashtable<String,String> data) 
	{
//		if(data.get("RunMode").equalsIgnoreCase("N")) 
//		{
//			throw new SkipException("Skipping Testcase as runmode is NO");
//		}
		
		TestBase.init();
		loginpage = topmenu.gotoLoginPage();
		loginpage.login(data.get("Email"), data.get("Password"));
	}
	
	@Test(dependsOnMethods= {"login"},dataProviderClass=TestUtils.class, dataProvider="dp")
	public void selectProduct(Hashtable<String,String> data) 
	{
		 navigation.selectCategory(data.get("Item"));
		 productsPage.selectProduct(data.get("Product"));
		 
		 
		 //product.selectQuantity(data.get("Quantity"));
		 //product.addToCart();
	}
}
