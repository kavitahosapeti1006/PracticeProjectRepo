package Test.PracticeProject;

import java.io.IOException;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("driver is initialized");
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException {
		driver.get("http://www.qaclickacademy.com/");
		log.info("hitting URL");
		
		LandingPage LP = new LandingPage(driver);
		
		WebElement login = LP.clickOnLogin();
		login.click();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.userName().sendKeys(username);
		loginpage.Password().sendKeys(password);
		loginpage.Login().click();
		
		

	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][2];
		obj[0][0] = "user1";
		obj[0][1]= "pass1";
		obj[1][0] = "user2";
		obj[1][1]= "pass2";
		return obj;
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	

}
