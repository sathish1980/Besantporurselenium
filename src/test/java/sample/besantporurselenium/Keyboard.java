package sample.besantporurselenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyboard {
	
	WebDriver driver;
	public void keyboardimplementation() throws AWTException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
	driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("https://www.facebook.com/");
	Actions mouseaction= new Actions(driver);
	mouseaction.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	Robot key= new Robot();
	key.keyPress(KeyEvent.VK_DOWN);
	key.keyRelease(KeyEvent.VK_DOWN);
	key.keyPress(KeyEvent.VK_DOWN);
	key.keyRelease(KeyEvent.VK_DOWN);
	key.keyPress(KeyEvent.VK_DOWN);
	key.keyRelease(KeyEvent.VK_DOWN);
	key.keyPress(KeyEvent.VK_DOWN);
	key.keyRelease(KeyEvent.VK_DOWN);
	key.keyPress(KeyEvent.VK_ENTER);
	key.keyRelease(KeyEvent.VK_ENTER);
	key.keyPress(KeyEvent.VK_TAB);
	key.keyRelease(KeyEvent.VK_TAB);
	key.keyPress(KeyEvent.VK_CONTROL);
	key.keyPress(KeyEvent.VK_V);
	key.keyRelease(KeyEvent.VK_CONTROL);
	key.keyRelease(KeyEvent.VK_V);
		
	}
	
	public void keyboardactioninapplication() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		Actions mouseaction= new Actions(driver);
		mouseaction.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").perform();
		mouseaction.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(1000);
		mouseaction.keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).perform();
		mouseaction.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
			
	}
	
	public static void main(String[] args) throws InterruptedException, AWTException
	{
		Keyboard k = new Keyboard();
		k.keyboardimplementation();
	}

}
