package extentReport;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public ExtentSparkReporter htmlreporter;
	public ExtentReports reports;
	public ExtentTest test;

	@BeforeTest
	public void report() {
		htmlreporter = new ExtentSparkReporter(".//Reports//repo.html");
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle("Origination");
		htmlreporter.config().setReportName("Automation Test Result");
		htmlreporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("Automation test", "Omkar");
	}

	@AfterTest
	public void endReport() {
		reports.flush();
	}

	@Test(priority = 1)
	public void login() {
		test = reports.createTest("testOne");
		System.out.println("passed");
	}

	@Test(priority = 2)
	public void anotherLogin() {
		test = reports.createTest("testTwo");
		Assert.fail("Failed");
	}

	@AfterMethod
	public void tt(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("abc");
			String sj = result.getMethod().getMethodName();
			String ltext = "<b>" + "Test Case: - " + sj.toUpperCase() + " Passed" + "</b>";
			Markup md = MarkupHelper.createLabel(ltext, ExtentColor.GREEN);
			test.pass(md);
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			String s = result.getMethod().getMethodName();
//			String text = "<b>" + "Test Case: - " + s + " Failed " + "</b>";
//			Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
			String error = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<Details>"+ "<Summary>" +"<b>"+ "<font color = " + "red>" +"Exception occured click to see" + "</font>"+"</b>"+"</Summary>"+error+"</Details>");
			String text = "<b>" + "Test Case: - " + s + " Failed " + "</b>";
			Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
			test.fail(m);
//			test.log(Status.FAIL, m);
}
}
}