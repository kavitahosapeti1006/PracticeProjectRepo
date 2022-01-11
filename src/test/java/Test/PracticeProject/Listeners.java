package Test.PracticeProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Resources.ExtentReport;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReport.getExtentReportObject(); //classname.methodname since method is declared as static no need to create object
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestStart(result);
		
		test = extent.createTest(result.getMethod().getMethodName()); //create a entry in report for that testcase
	
	//Used object of ExtentTest class (i.e., logger) in the remaining methods to write logs in the report.
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		test.fail(result.getThrowable());
	
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getScreenshot(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
		//flush() - to write or update test information to your report. and Flush method is used to erase any previous data on the report and create a new report.
	}

	
}
