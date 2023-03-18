package sample.besantporurselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class verificationandvalidation {
	
	WebDriver driver;
	public void checkboximplementation() throws InterruptedException
	{

		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/dashboard.xhtml");
		driver.findElement(By.xpath("//*[@id='menuform:j_idt40']")).click();
		driver.findElement(By.xpath("//*[text()='Check Box']//parent::a")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")));
		//validation commands
		boolean checkboxstatus=driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")).isSelected();
		boolean checkboxstatusdisplayed=driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")).isDisplayed();
		boolean checkboxstatusenabled=driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")).isEnabled();
		
		
		System.out.println("isselected or not: "+checkboxstatus);
		System.out.println("displayed or not : "+checkboxstatusdisplayed);
		System.out.println("enabled or not: "+checkboxstatusenabled);
		if (checkboxstatus==false)
		{
	
		driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")).click();
	
		}
		Thread.sleep(1000);
		boolean checkboxstatusafter=driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")).isSelected();
		System.out.println(checkboxstatusafter);
		
		System.out.println("********** disabled field **********");
		// disabled field
		boolean checkboxstatusd=driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']//*[contains(@class,'ui-chkbox-box')]")).isSelected();
		boolean checkboxstatusdisplayedd=driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']//*[contains(@class,'ui-chkbox-box')]")).isDisplayed();
		boolean checkboxstatusenabledd=driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']//*[contains(@class,'ui-chkbox-box')]")).isEnabled();
		
		
		System.out.println("isselected or not: "+checkboxstatusd);
		System.out.println("displayed or not : "+checkboxstatusdisplayedd);
		System.out.println("enabled or not: "+checkboxstatusenabledd);
		
		//Verification
		System.out.println("********** verification field **********");
		String Title=driver.getTitle();
		System.out.println(Title);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String attributevalue=driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']//*[contains(@class,'ui-chkbox-box')]")).getAttribute("class");
		System.out.println(attributevalue);
		String textvalue=driver.findElement(By.xpath("(//*[@id='j_idt87:j_idt102']//span)[2]")).getText();
		System.out.println(textvalue);
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		verificationandvalidation v = new verificationandvalidation();
		v.checkboximplementation();
	}

}
