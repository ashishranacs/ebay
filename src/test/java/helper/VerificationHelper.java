package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class VerificationHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getlogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public boolean isDisplayed(WebElement element) {
		
		try {
			element.isDisplayed();
			log.info(element.getText()+" element is present");
			return true;
		}
		catch(Exception e) {
			log.error("element is not present "+e.getCause());
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element) {
		
		try {
			element.isDisplayed();
			log.info(element.getText()+" element is present");
			return false;
		}
		catch(Exception e) {
			log.info(element.getText()+" element is not present");
			return true;
		}
	}
	
	public String readValueFromElement(WebElement element) {
		
		if(null == element) {
			log.info(element.toString()+" Webelement is null");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status) {
			
			return element.getText();
		}
		else {
			return null;
		}
	}
	
	public String getText(WebElement element) {
		
		if(null == element) {
			log.info(element.toString()+" Webelement is null");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status) {
			
			return element.getText();
		}
		else {
			return null;
		}
	}
}
