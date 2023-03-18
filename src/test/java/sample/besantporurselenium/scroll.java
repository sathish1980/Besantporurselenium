package sample.besantporurselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class scroll {
	
	WebDriver driver;
	public void scrollimplementation() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(2000);
		//vertical scroll up
		js.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(2000);
		//Horizontal scroll right
		js.executeScript("window.scrollBy(750,0)", "");
		Thread.sleep(2000);
		//Horizontal scroll left
		js.executeScript("window.scrollBy(-750,0)", "");
		Thread.sleep(2000);
		//vertical scroll to page end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		//vertical scroll to page up
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
		WebElement startbutton=driver.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		scroll s = new scroll();
		s.scrollimplementation();
	}

}
