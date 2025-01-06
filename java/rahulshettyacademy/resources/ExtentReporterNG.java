package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter repor = new ExtentSparkReporter(path);
		repor.config().setReportName("Web Automation Results");
		repor.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(repor);
		extent.setSystemInfo("Tester", "Camilo Restrepo");
		
		return extent;
	}
}
