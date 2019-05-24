package listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtils;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

	public String messageBody;

	public void onTestStart(ITestResult result) {
		test = rep.startTest(result.getName().toUpperCase());

	}

	public void onTestSuccess(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASSED");
		test.log(LogStatus.PASS, test.addScreenCapture(TestUtils.screenShotName));
		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, result.getName().toUpperCase() + " FAILED with exception: " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtils.screenShotName));

		Reporter.log("Click to see..");
		Reporter.log("<a target=\"_blank\" href=" + TestUtils.screenShotName + ">Screenshot</a>");

		rep.endTest(test);
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		//test.log(LogStatus.SKIP, result.getName().toUpperCase() + " skipped the testcase as runmode is NO");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite suite) {

//		MonitoringMail mail = new MonitoringMail();
//		try {
//			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
//					+ ":8080/job/DataDrivenLiveProject/Extent_20Report";
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println(messageBody);
//
//		try {
//			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
