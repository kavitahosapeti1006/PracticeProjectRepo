package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;
	By login = By.cssSelector("a[href*='sign_in']");
	By text = By.xpath("//div[@class='text-center']/h2");
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement clickOnLogin()
	{
		return driver.findElement(login);
		
	}
	
	public WebElement ValidateText()
	{
		return driver.findElement(text);
	}
	
}
