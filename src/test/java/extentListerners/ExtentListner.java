package extentListerners;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListner implements ITestListener{

	eventManger e = new eventManger();
	Date d = new Date();
String filename ="Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
	public ExtentReports reports = eventManger.abc(filename);
	public void onTestStart(ITestResult result) {
		eventManger.test = eventManger.reports.createTest(result.getClass().getName().toUpperCase() + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		String s = result.getMethod().getMethodName();
		String text = "Test Case : "+s;
		Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
		eventManger.test.pass(m);
	}

	public void onTestFailure(ITestResult result) {
		String s = result.getMethod().getMethodName();
		String text = "Test Case : "+s;
		Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
		eventManger.test.fail(m);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		eventManger.reports.flush();
		
	}

}
