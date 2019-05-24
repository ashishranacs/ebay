package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import helper.LoggerHelper;

public class WrapperMethods extends TestBase {
	
	private Logger log = LoggerHelper.getlogger(WrapperMethods.class);
	
	
	public void mouseOver(String locator) 
	{
		log.info("mouse hovering on "+locator);
		WebElement element = driver.findElement(By.xpath(locator));
		TestBase.action.moveToElement(element).build().perform();
		TestBase.test.log(LogStatus.INFO, "Hovering on Username: "+ element);	
	}
		
	public void click(String locator)
	{
		driver.findElement(By.xpath(locator)).click();
		log.info("Clicked on: "+locator);
		TestBase.test.log(LogStatus.INFO, "Clicking on: " + locator);
	}

	public void type(String locator, String value) 
	{
		driver.findElement(By.xpath(locator)).sendKeys(value);
		log.info("Typing in: "+ locator.toString() +" entered value "+value);
		TestBase.test.log(LogStatus.INFO, "Typing in: " + locator + " entered value: " + value);
	}
	
	public void mouseOverAndClick(String item, String subItem) 
	{
		mouseOver(item);
		click(subItem);
	}
	
	public void clickByLinkText(String name) 
	{
		driver.findElement(By.linkText(name));
	}
	
	
}
