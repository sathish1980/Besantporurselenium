package sample.besantporurselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
	
	public void singleselectdropdown()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//*[text()='Create new account']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Select dayddopdown = new Select(driver.findElement(By.id("day")));
		System.out.println(dayddopdown.isMultiple());
		dayddopdown.selectByIndex(4);
	
		Select monthddopdown = new Select(driver.findElement(By.id("month")));
		monthddopdown.selectByValue("6");
		
		Select yearddopdown = new Select(driver.findElement(By.id("year")));
		yearddopdown.selectByVisibleText("2000");
		
		
	}
	
	public void multiselectdroddown()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select value= new Select(driver.findElement(By.xpath("//select[@id='second']")));
		if(value.isMultiple())
		{
			value.selectByIndex(3);
			value.selectByVisibleText("Pizza");
			value.deselectByIndex(3);
			value.deselectAll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dropdown d = new dropdown();
		d.multiselectdroddown();
		
	}

}
