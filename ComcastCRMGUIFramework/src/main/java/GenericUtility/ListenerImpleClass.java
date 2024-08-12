package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpleClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	// if i want to use this report in every testcase make this variable as static
	public static ExtentReports report;
	public static ExtentTest test;

	@Override

	public void onStart(ISuite suite) {
		System.out.println("Report configuration");

		// extent report
		String time=new Date().toString().replace(" ","_").replace(":","_");
		spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		// extent report
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====>" + result.getMethod().getMethodName() + ">====start===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"====>STARTED<===");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====>" + result.getMethod().getMethodName() + ">====end===");
		test.log(Status.PASS,result.getMethod().getMethodName()+"====>COMPLETED<===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replace(":","_");
		test.addScreenCaptureFromBase64String(temp,testname+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"====>FAILED<===");
		test.log(Status.FAIL,result.getThrowable());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.FAIL,result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
