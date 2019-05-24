package helper;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WaitHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getlogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	/**
	 * This is implicitwait method
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		
		log.info("Implicit time is set to: "+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	/**
	 * This will help us to get webdriver wait object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMillisec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMillisec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMillisec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	/**
	 * This method will make sure element is presnet
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMillisec
	 */
	public void waitforElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMillisec) {
		
		log.info("waiting for "+element.toString()+" for"+ timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMillisec);
		wait.until(ExpectedConditions.invisibilityOf(element));
		log.info(element.toString()+" is visible now");
	}
	
	/**
	 * This method will make sure element is clickable
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitforElementClickable(WebElement element, int timeOutInSeconds) {
		
		log.info("waiting for "+element.toString()+" for"+ timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info(element.toString()+" is clickable now");
	}
	
	/**
	 * This method will make sure element is invisible
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitforElementNotPresent(WebElement element, int timeOutInSeconds) {
		
		log.info("waiting for "+element.toString()+" for"+ timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info(element.toString()+" is invisible now");
		return status;
	}
	
	/**
	 * This method will wait for frame to be available and then switch to it
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitforframeToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds) {
		
		log.info("waiting for "+element.toString()+" for"+ timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available now");
	}
	
	/**
	 * Returns the fluent wait object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMillisec
	 * @return
	 */
	private Wait<WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMillisec){
		
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMillisec));
		
		return fWait;
		
	}
	
	public void waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMillisec) {
		
		Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds, pollingEveryInMillisec);
		fwait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * PageLoad tiemout Method
	 * @param timeOutInSeconds
	 * @param unit
	 */
	public void waitForPageLoad(long timeOutInSeconds, TimeUnit unit) {
		
		driver.manage().timeouts().pageLoadTimeout(timeOutInSeconds, unit);
	}
	
}
