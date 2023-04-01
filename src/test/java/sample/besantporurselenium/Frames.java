package sample.besantporurselenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Frames {
	
	WebDriver driver;
	public void frameconcpet()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='Click' and text()='Click Me'])[1]")));
		List<WebElement> tagname=driver.findElements(By.tagName("iframe"));
		for (int abc=0;abc<tagname.size();abc++)
		{
			driver.switchTo().frame(abc);
			List<WebElement> elementexist=driver.findElements(By.xpath("(//*[@id='Click' and text()='Click Me'])[1]"));
			if (elementexist.size()>0)
			{
				driver.findElement(By.xpath("(//*[@id='Click' and text()='Click Me'])[1]")).click();
				driver.switchTo().defaultContent();
				break;
			}
			else
			{
				driver.switchTo().defaultContent();
			}
		}
	}
	
	public void frameinsideframeconcpet()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='Click' and text()='Click Me'])[1]")));
		List<WebElement> tagname=driver.findElements(By.tagName("iframe"));
		for (int abc=0;abc<tagname.size();abc++)
		{
			driver.switchTo().frame(abc);
			List<WebElement> innerframe=driver.findElements(By.tagName("iframe"));
			if(innerframe.size()>0)
			{
				driver.switchTo().frame("frame2");
	
			List<WebElement> elementexist=driver.findElements(By.xpath("(//*[@id='Click' and text()='Click Me'])[1]"));
			if (elementexist.size()>0)
			{
				driver.findElement(By.xpath("(//*[@id='Click' and text()='Click Me'])[1]")).click();
				driver.switchTo().defaultContent();
				break;
			}
			else
			{
				driver.switchTo().defaultContent();
			}
		}
			else
			{
				driver.switchTo().defaultContent();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frames F = new Frames();
		F.frameconcpet();
	}

}
