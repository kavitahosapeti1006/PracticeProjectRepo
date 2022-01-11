package Test.PracticeProject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.LandingPage;
import Resources.Base;

public class UsingAssertion extends Base{

	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
	}
	@Test
	public void validation() throws IOException
	{
	
	LandingPage Lpage = new LandingPage(driver);
	String text1=Lpage.ValidateText().getText();
	SoftAssert softassert = new SoftAssert();
	softassert.assertEquals(text1, "FEATURED COURSE");
	//Assert.assertEquals(text1, "Featured Cources");
	System.out.println("testing softassert statement");
	softassert.assertAll();
	}
	
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}

}
