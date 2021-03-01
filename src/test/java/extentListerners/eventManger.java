package extentListerners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class eventManger {
	
	public static ExtentSparkReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static ExtentReports abc(String filename) {
		htmlreporter = new ExtentSparkReporter(filename);
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle("Test html  Reports");
		htmlreporter.config().setReportName("Automation testing reports");
		htmlreporter.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("Automation Tester", "Omkar");
		return reports;
		
	}
}
 