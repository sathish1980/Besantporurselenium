package sample.besantporurselenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alertconcepts {
	
WebDriver driver;
	public void alertimplementation() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		String textvalue=driver.findElement(By.xpath("//*[@id='simple_result']")).getText();
		System.out.println(textvalue);
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']")).click();
		alert.dismiss();
		String canceltext=driver.findElement(By.xpath("//*[@id='result']")).getText();
		System.out.println(canceltext);
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt104']")).click();
		driver.switchTo().alert().sendKeys("Besant technologies");
		System.out.println("alert text: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	
		String prompttext=driver.findElement(By.xpath("//*[@id='confirm_result']")).getText();
		System.out.println(prompttext);
		
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt88:j_idt98']")));
	
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt98']")).click();
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alertconcepts a = new Alertconcepts();
		a.alertimplementation();
	}

}
