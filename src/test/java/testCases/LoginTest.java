package testCases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.TopMenu;
import utilities.TestUtils;

public class LoginTest {
	
	TopMenu topmenu = new TopMenu();
	LoginPage loginpage;
		
	
	
	@Test(dataProviderClass=TestUtils.class, dataProvider="dp")
	public void login(Hashtable<String,String> data) {
		
//		if(data.get("RunMode").equalsIgnoreCase("N")) {
//			throw new SkipException("Skipping Testcase as runmode is NO");
//		}
		
		TestBase.init();
		loginpage = topmenu.gotoLoginPage();
		loginpage.login(data.get("Email"), data.get("Password"));
		
	}
	
	
	@AfterMethod
	public void logout() {
		
		if(TestBase.driver != null) {
			topmenu.logout();
			TestBase.quitBrowser();
		}
	}
	
}
