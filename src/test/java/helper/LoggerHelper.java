package helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import utilities.Constants;



public class LoggerHelper {
	
	private static boolean root = false;
	
	
	public static Logger getlogger(Class cls) {
		if(root) {
			
			return Logger.getLogger(cls);
		}
		
		PropertyConfigurator.configure(Constants.log4JPath);
		root= true;
		
		return Logger.getLogger(cls);
		
	}
	
//	public static void main(String[] args) {
//			
//		Logger log = LoggerHelper.getlogger(LoggerHelper.class);
//		log.info("logger is configured");
//		log.info("logger is configured");
//		log.info("logger is configured");
//	}
}
