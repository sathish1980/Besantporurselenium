package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Commons.commonActions;

public class FacebooklogoutPage extends commonActions {
	
	WebDriver driver;
	final String LogoutDropdown="//span[text()='Log Out']";
	
	public FacebooklogoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ClickOnlogoutDropdown()
	{
		WebElement logoutdropdownbutton = driver.findElement(By.xpath("//*[local-name()='svg' and @aria-label='Your profile']"));
		WaitForElementToBeClickable(driver, logoutdropdownbutton);
		ClickOnButton(logoutdropdownbutton);
	}
	
	public void ClickOnLogout()
	{

		By logoutbutton = By.xpath(LogoutDropdown); 
		WaitForElementToBePresent(driver, logoutbutton);
		ClickOnButton(driver.findElement(logoutbutton));
	}
	
	
	public String VerifyLoginSucess()
	{
	final String profileElement="//*[text()='Sathish Ramakrishnan']";
	By profilename=By.xpath(profileElement);
	WaitForElementToBePresent(driver, profilename);
	String ProfileNameActual =driver.findElement(profilename).getText();
	System.out.println(ProfileNameActual);
	return ProfileNameActual;
	}
	
	public String VerifyLogoutSucess()
	{
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		return PageTitle;
	}
	//test.log(LogStatus.INFO, "You have sucessfully loged in as " +ProfileNameActual);



}
