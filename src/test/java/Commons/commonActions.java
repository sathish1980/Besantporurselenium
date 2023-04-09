package Commons;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonActions {
	
	public void EnterAText(WebElement textBox,String textToBeEneter)
	{
		if(textBox.isDisplayed())
		{
			textBox.sendKeys(textToBeEneter);
		}
	}
	
	public void ClearEnterAText(WebElement textBox,String textToBeEneter)
	{
		if(textBox.isDisplayed())
		{
			textBox.clear();
			textBox.sendKeys(textToBeEneter);
		}
	}
	
	public void ClickOnButton(WebElement button)
	{
		if(button.isDisplayed())
		{
			button.click();
		}
	}
	
	public void WaitForElementToBeVisible(WebDriver driver, WebElement waitElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(waitElement));
		
	}
	
	public void WaitForElementToBeClickable(WebDriver driver, WebElement waitElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(waitElement));
		
	}

	public void WaitForElementToBePresent(WebDriver driver, By waitElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(waitElement));
		
	}

}
