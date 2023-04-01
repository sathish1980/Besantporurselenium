package sample.besantporurselenium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandle {

	
	WebDriver driver;
	public void windowshandlingimplementation()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		String parentwindow=driver.getWindowHandle();
		System.out.println(parentwindow);
		driver.findElement(By.xpath("//*[text()='Open']//parent::button")).click();
		Set<String> AllWindow=driver.getWindowHandles();
		System.out.println(AllWindow);
		for(String childwindow:AllWindow)
		{
			if (!childwindow.equals(parentwindow))
			{
				driver.switchTo().window(childwindow);
				List<WebElement> eelementexist=driver.findElements(By.xpath("//*[@id='menuform:j_idt40']"));
				if (eelementexist.size()>0)
				{
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
					wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='menuform:j_idt40']")));
					
				driver.findElement(By.xpath("//*[@id='menuform:j_idt40']")).click();
				driver.findElement(By.xpath("//*[text()='Check Box']//parent::a")).click();
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")));
				driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")).click();
				driver.switchTo().window(parentwindow);
				driver.close();
				break;
				}
				else
				{
					driver.switchTo().window(parentwindow);
				}
			}
		}
	}

	public void multiwindow()
	{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://leafground.com/window.xhtml");
			String parentwindow=driver.getWindowHandle();
			System.out.println(parentwindow);
			driver.findElement(By.xpath("//*[text()='Open Multiple']//parent::button")).click();
			Set<String> AllWindow=driver.getWindowHandles();
			System.out.println(AllWindow);
			for(String childwindow:AllWindow)
			{
				if (!childwindow.equals(parentwindow))
				{
					driver.switchTo().window(childwindow);
					List<WebElement> eelementexist=driver.findElements(By.xpath("//*[@id='menuform:j_idt40']"));
					if (eelementexist.size()>0)
					{
						driver.manage().window().maximize();
						WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menuform:j_idt40']")));
					

					driver.findElement(By.xpath("//*[@id='menuform:j_idt40']")).click();
					driver.findElement(By.xpath("//*[text()='Check Box']//parent::a")).click();
					wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")));
					driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")).click();
					driver.switchTo().window(parentwindow);
					//driver.quit();
					break;
					}
					else
					{
						driver.switchTo().window(parentwindow);
					}
				}
			}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowsHandle W = new WindowsHandle();
		W.multiwindow();
	}

}
