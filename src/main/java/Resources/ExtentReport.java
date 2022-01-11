package Resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentReports extent;
	public static ExtentReports getExtentReportObject()
	{
	String path = System.getProperty("user.dir")+"\\Reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Practice Project Result");
	reporter.config().setDocumentTitle("ExtentReportTest");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("tester", "kavita");
	return extent;
	
	}
	

}
