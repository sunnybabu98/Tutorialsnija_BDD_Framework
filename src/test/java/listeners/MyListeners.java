package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utlity.ExtentReport;

public class MyListeners implements ITestListener {
	ExtentReports extentReport = ExtentReport.getExtentReport();
	ExtentTest extentText;
	@Override
	public void onTestStart(ITestResult result) {
		 extentText = extentReport.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
     
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
	
	
	
	

}
