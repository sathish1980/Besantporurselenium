package Testcase;



import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.Browser;
import Commons.commonActions;
import Pages.FacebookloginPage;
import Pages.FacebooklogoutPage;
import utils.ExcelfileTest;
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
	
	@Test(priority=0,dataProvider="testdata",dataProviderClass=dataproviders.class)
	public void FacebookLoginandLogout(String urname,String psword) throws InterruptedException
	{
		FacebookloginPage FP = new FacebookloginPage(driver);
		FP.EnterUsername(urname);
		FP.EnterPassword(psword);
		FP.ClickOnLoginButton();
		FacebooklogoutPage FL = new FacebooklogoutPage(driver);
		FL.VerifyLoginSucess();
		FL.ClickOnlogoutDropdown();
		FL.ClickOnLogout();
		Thread.sleep(3000);
		Assert.assertEquals("Facebook – log in or sign up", FL.VerifyLogoutSucess());
	//test.log(LogStatus.PASS, "You have sucessfully LOGIN AND lOGOUT in as ");
		
	}
	
	
	@Test(priority=1)
	public void FacebookInvalidLogin() throws InterruptedException
	{
		By uname = By.id("email");
		CA.WaitForElementToBePresent(driver, uname);
		WebElement username =driver.findElement(uname);
		CA.EnterAText(username, "324235345456565");
		WebElement loginbutton =driver.findElement(By.name("login"));
		CA.ClickOnButton(loginbutton);	
		By login_container = By.id("email_container");
		CA.WaitForElementToBePresent(driver, login_container);
		Thread.sleep(3000);
		By Errormessage = By.xpath("//*[@id='email_container']//div[2]");
		CA.WaitForElementToBePresent(driver, Errormessage);
		
		String ErrorMessage =driver.findElement(Errormessage).getText();
		System.out.println(ErrorMessage);
		String actualMessage= "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		Assert.assertEquals(ErrorMessage, actualMessage);
		//test.log(LogStatus.PASS, "iNVALID USERNAME IS VALIDATED SUCESSFULLY ");
		
}
	

	
	@AfterSuite
	public void TearDown()
	{
		report.flush();
		driver.quit();
	}
	
}
