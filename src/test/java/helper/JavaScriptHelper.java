package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class JavaScriptHelper {
	
	private WebDriver driver;
	private ExtentTest test;
	private Logger log = LoggerHelper.getlogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		log.info("JS Helper Object Created");
	}
	
	
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object...args) {
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script, args);
	}
	
	public void scrollToElement(WebElement element) {
		log.info("Scrolling to element: "+element.toString());
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement element) {
		
		scrollToElement(element);
		element.click();
		log.info(element.toString()+" clicked");
	}
	
	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		
	}
	
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info(element.toString()+" is clicked");
		
	}
	
	public void scrollDownVertically() {
		log.info("scrolling vertically downward");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollUpVertically() {
		log.info("scrolling vertically upward");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBy(0,-"+pixel+")");
	}
	
	public void zoomInBy100Percent() {
		executeScript("document.body.style.zoom='100%'");
	}
	
	public void zoomInBy60Percent() {
		executeScript("document.body.style.zoom='60%'");
	}
	
	public void clickElement(WebElement element) {
		
		executeScript("arguments[0].click();", element);
		test.log(LogStatus.INFO, "Hovering on: " + element.getText());
	}
}


