package base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import helper.AssertionHelper;
import helper.DropDownHelper;
import helper.JavaScriptHelper;
import helper.LoggerHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import utilities.Constants;
import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.WrapperMethods;

public class TestBase {

	public static WebDriver driver;
	public static ExcelReader excel = new ExcelReader(Constants.dataSheet);
	public static ExtentReports rep = ExtentManager.getInsatnce();
	public static Logger log = LoggerHelper.getlogger(TestBase.class);
	public static ExtentTest test;
	public static String browser;
	public static WaitHelper wait;
	//public static TopMenu topmenu;
	public static AssertionHelper assertion;
	public static VerificationHelper verification;
	public static JavaScriptHelper jshelper;
	public static WrapperMethods method = new WrapperMethods();
	public static Actions action;
	//public DropDownHelper dropdown = new DropDownHelper(driver);

	public static void init() 
	{
		if (Constants.browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", Constants.chromePath);
			driver = new ChromeDriver();
			log.info("chrome launched");
		}

		else if (Constants.browser.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", Constants.firefoxPath);
			driver = new FirefoxDriver();
			log.debug("firefox launched");
		}

		else if (Constants.browser.equals("edge")) 
		{
			System.setProperty("webdriver.edge.driver", Constants.edgePath);
			driver = new EdgeDriver();
			log.debug("Edge browser launched");
		}

		driver.get(Constants.baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
		//topmenu = new TopMenu(driver);
		action = new Actions(driver);	
	}

	

	public static void quitBrowser() 
	{
		driver.quit();
	}
}
