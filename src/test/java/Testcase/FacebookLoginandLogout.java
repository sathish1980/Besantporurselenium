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
import BrowserDriver.OldBrowser;
import Commons.commonActions;
import Pages.FacebookloginPage;
import Pages.FacebooklogoutPage;
import utils.ExcelfileTest;
import utils.propertyfileconcept;

public class FacebookLoginandLogout extends Browser
{
	propertyfileconcept ps = new propertyfileconcept();
	commonActions CA = new commonActions();
	
	/*@BeforeSuite
	public void browserlaunch() throws IOException
	{
		String browserName = ps.propertyconcepts().getProperty("browser");
	
	}*/

	@Parameters("browser")
	@BeforeTest
	public void EnterURL(String browser) throws IOException
	{
		launch(browser);
		getdriver().manage().window().maximize();
		String actualURL = ps.propertyconcepts().getProperty("URL");
		getdriver().get(actualURL);
		//getdriver().get("https://www.facebook.com/");
	}
	
	@Test(priority=0,dataProvider="testdata",dataProviderClass=dataproviders.class)
	public void FacebookLoginandLogout(String urname,String psword) throws InterruptedException
	{
		try
		{
		FacebookloginPage FP = new FacebookloginPage(getdriver());
		FP.EnterUsername(urname);
		test.log(LogStatus.INFO, "Username is entered");
		FP.EnterPassword(psword);
		test.log(LogStatus.INFO, "password is entered");
		FP.ClickOnLoginButton();
		test.log(LogStatus.INFO, "Login is clicked sucessfully");
		FacebooklogoutPage FL = new FacebooklogoutPage(getdriver());
		FL.VerifyLoginSucess();
		FL.ClickOnlogoutDropdown();
		String filepath = takescreenshot(getdriver());
		FL.ClickOnLogout();
		test.log(LogStatus.INFO, "Log out done scusssfully");
		Thread.sleep(3000);
		Assert.assertEquals("Facebook – log in or sign up", FL.VerifyLogoutSucess());
		test.log(LogStatus.PASS, "You have sucessfully LOGIN AND lOGOUT in as ",test.addScreenCapture(filepath));
		}
		catch(Exception e) 
		{
			test.log(LogStatus.FAIL, e);
			
		}
	}
	
	
	@Test(priority=1)
	public void FacebookInvalidLogin() throws InterruptedException
	{
		By uname = By.id("email");
		CA.WaitForElementToBePresent(getdriver(), uname);
		WebElement username =getdriver().findElement(uname);
		CA.EnterAText(username, "324235345456565");
		WebElement loginbutton =getdriver().findElement(By.name("login"));
		CA.ClickOnButton(loginbutton);	
		By login_container = By.id("email_container");
		CA.WaitForElementToBePresent(getdriver(), login_container);
		Thread.sleep(3000);
		By Errormessage = By.xpath("//*[@id='email_container']//div[2]");
		CA.WaitForElementToBePresent(getdriver(), Errormessage);
		
		String ErrorMessage =getdriver().findElement(Errormessage).getText();
		System.out.println(ErrorMessage);
		String actualMessage= "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		Assert.assertEquals(ErrorMessage, actualMessage);
		//test.log(LogStatus.PASS, "iNVALID USERNAME IS VALIDATED SUCESSFULLY ");
		
}
	

	
	@AfterSuite
	public void TearDown()
	{
		report.flush();
		getdriver().quit();
	}
	
}
