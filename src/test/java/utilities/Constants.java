package utilities;

public class Constants {
	
	/**
	 * File Paths
	 */
	
	public static String log4JPath = System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties";
	public static String dataSheet = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testData.xlsx";
	public static String chromePath = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
	public static String firefoxPath = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe";
	public static String edgePath = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe";
	public static final String videoFolder = System.getProperty("user.dir")+"\\src\\test\\resources\\videos";
	
	
	/**
	 * Config Files
	 */
	
	public static String browser = "chrome";
	public static String baseUrl = "https://www.ebay.com/";
	
	
	public static long implicitWait = 10;
}

