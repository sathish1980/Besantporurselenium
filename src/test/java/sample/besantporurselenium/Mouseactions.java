package sample.besantporurselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mouseactions {
	WebDriver driver;
	
	public void mouseactionpart1() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Actions mouseaction= new Actions(driver);
		mouseaction.moveToElement(driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"))).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Computers and tablets'])[1]")));
		mouseaction.moveToElement(driver.findElement(By.xpath("(//a[text()='Computers and tablets'])[1]"))).click().perform();
	}
	
	public void mouseactionpart2()
	{

		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		Actions mouseaction= new Actions(driver);
		mouseaction.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}
	
	public void draganddrop()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		Actions mouseaction= new Actions(driver);
		mouseaction.moveToElement(driver.findElement(By.id("form:drag_content"))).dragAndDrop(driver.findElement(By.id("form:drag_content")), driver.findElement(By.id("form:drop_content"))).perform();
	}
	
	public void progressbar()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement startbutton=driver.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
		driver.findElement(By.xpath("//*[text()='Start']//parent::button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@class='ui-progressbar-label']")),"100%"));
		String progresstext=driver.findElement(By.xpath("//*[@class='ui-growl-title']")).getText();
		System.out.println(progresstext);
		
	}
	
	public void Slider()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement startbutton=driver.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
		Actions mouse= new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]"))).dragAndDropBy(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]")), -80, 0).perform();
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]"))).dragAndDropBy(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]")), 80, 0).perform();
	}

	public static void main(String[] args) throws InterruptedException
	{
		Mouseactions m = new Mouseactions();
		m.Slider();
	}

}
