package utlity;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    
	public static ExtentReports getExtentReport() {

	String extentReportFilePath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
	ExtentSparkReporter sparkRepoter = new ExtentSparkReporter(extentReportFilePath);
	sparkRepoter.config().setReportName("TutorialsNija Automation Results");
	sparkRepoter.config().setDocumentTitle("TutorialsNija Test Automation Results");
	
	ExtentReports extentReport = new ExtentReports();
	extentReport.attachReporter(sparkRepoter);
	extentReport.setSystemInfo("selenium version", "4.4.0");
	extentReport.setSystemInfo("Operating system", "Windows 11");
	extentReport.setSystemInfo("Executed by", "Sunny babu");
	return extentReport;
	
	}
}
