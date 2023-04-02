package Testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import BrowserDriver.Browser;
import Commons.commonActions;
import utils.propertyfileconcept;

public class FacebookLoginandLogout extends Browser
{
	propertyfileconcept ps = new propertyfileconcept();
	commonActions CA = new commonActions();
	
	@BeforeSuite
	public void browserlaunch() throws IOException
	{
		String browserName = ps.propertyconcepts().getProperty("browser");
		launch(browserName);
	}

	@BeforeTest
	public void EnterURL() throws IOException
	{
		driver.manage().window().maximize();
		String actualURL = ps.propertyconcepts().getProperty("URL");
		driver.get(actualURL);
	}
	
	@Test(priority=0)
	public void FacebookLoginandLogout()
	{
		WebElement username =driver.findElement(By.id("email"));
		CA.EnterAText(username, "kumar.sathish189@gmail.com");
		WebElement password =driver.findElement(By.id("pass"));
		CA.EnterAText(password, "Test");
		WebElement loginbutton =driver.findElement(By.name("login"));
		CA.ClickOnButton(loginbutton);			
	}
	
	@AfterSuite
	public void TearDown()
	{
		driver.quit();
	}
	
}
