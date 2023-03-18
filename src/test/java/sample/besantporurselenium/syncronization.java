package sample.besantporurselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class syncronization {
	
	public void syncconcept() throws InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//*[text()='Create new account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("sathish");
		driver.findElement(By.name("reg_email__")).sendKeys("kumar.sathish189@gmail.com");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("reg_email_confirmation__"))));
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("kumar.sathish189@gmail.com");
				
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		syncronization s = new syncronization();
		s.syncconcept();
	}

}
