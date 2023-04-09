package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.commonActions;

public class FacebookloginPage extends commonActions{
	
	@FindBy(id="email")
	WebElement username;
	@FindBy(id="pass")
	WebElement password;
	@FindBy(name="login")
	WebElement loginbutton;
	
	WebDriver driver;
	
	public FacebookloginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterUsername(String textEnter)
	{
	//WebElement username =driver.findElement(By.id("email"));
	EnterAText(username, textEnter);
	}
	//test.log(LogStatus.INFO, "Username entered sucefully and enterd username is : "+"kumar.sathish189@gmail.com");
	
	public void EnterPassword(String pwd)
	{
	//WebElement password =driver.findElement(By.id("pass"));
	EnterAText(password, pwd);
	
	}
	//test.log(LogStatus.INFO, "password entered sucefully");
	
	public void ClickOnLoginButton()
	{
	//WebElement loginbutton =driver.findElement(By.name("login"));
	ClickOnButton(loginbutton);
	}

}
