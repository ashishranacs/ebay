package helper;

import org.apache.log4j.Logger;
import org.testng.Assert;



public class AssertionHelper {

	private static Logger log = LoggerHelper.getlogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("verifying " + s1 + " with " + s2);
		Assert.assertEquals(s1, s2);

	}

	public static void makeTrue() {
		log.info("making script pass..");
		Assert.assertTrue(true);
	}

	public static void makeTrue(String message) {
		log.info("making script pass " + message);
		Assert.assertTrue(true, message);
	}

	public static void makeFlase() {
		log.info("making script fail..");
		Assert.assertTrue(false);
	}

	public static void makeFalse(String message) {
		log.info("making script fail " + message);
		Assert.assertTrue(false, message);
	}

	public static void verifyTrue(boolean status) {

		Assert.assertTrue(status);
	}

	public static void verifyFalse(boolean status) {

		Assert.assertFalse(status);
	}

	public static void verifyNull(String s1) {
		log.info("verifying " + s1 + " is null");
		Assert.assertNull(s1);
	}

	public static void verifyNotNull(String s1) {
		log.info("verifying " + s1 + " is not null");
		Assert.assertNotNull(s1);
	}

}
