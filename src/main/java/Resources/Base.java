package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\java\\Resources\\chromedriver.exe" );
			 driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		return driver;
		
		
	}
	
	public void getScreenshot(String testMethodName, WebDriver driver) throws IOException
	{
		File fi = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\Reports\\" + testMethodName+".png";
		 
			FileUtils.copyFile(fi, new File(destinationFile));
	
	}

}
