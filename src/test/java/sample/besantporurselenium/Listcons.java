package sample.besantporurselenium;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listcons {
	
	public void listimplementation(String expectedCountry)
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menuform:j_idt40"))));
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_dropdown")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='j_idt87:country']//div[3]"))));
		driver.findElement(By.xpath("//*[@id='j_idt87:country']//div[3]")).click();
		java.util.List<WebElement> country = driver.findElements(By.xpath("//*[@id='j_idt87:country_items']//following-sibling::li"));
		for(WebElement eachweb : country)
		{
			String actualCountry = eachweb.getText();
			if (expectedCountry.equalsIgnoreCase(actualCountry))
			{
				eachweb.click();
				break;
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listcons l = new Listcons();
		l.listimplementation("USA");
	}

}
