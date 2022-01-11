package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user_email")
	WebElement username;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(name = "commit")
	WebElement login;
	
	public WebElement userName()
	{
		return username;
	}

	public WebElement Password()
	{
		return password;
	}
	
	public WebElement Login()
	{
		return login;
	}
}


