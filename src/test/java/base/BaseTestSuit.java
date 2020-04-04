package base;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestSuit {
	boolean logToConsol = true;
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestResult testResult) {
		Reporter.log("Executing method: " + testResult.getMethod().getMethodName(),logToConsol );

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult testResult) {
		String metodhName = testResult.getMethod().getMethodName();
		if (testResult.getStatus() == ITestResult.FAILURE) {
			Reporter.log("Method FAIL: " + metodhName, logToConsol);
		}
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			Reporter.log("Method PASS: " + metodhName, logToConsol);
		}
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("\nBaseTestSuit -> This runs once before suit");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("\nBaseTestSuit -> This runs once after suit");
	}

}
