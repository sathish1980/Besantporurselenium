package sample.besantporurselenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class firstclass {
	
	public void launch()
	{
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//WebElement username= driver.findElement(By.id("email"));
		//WebElement username= driver.findElement(By.cssSelector("input#email"));
		//WebElement username= driver.findElement(By.cssSelector("input.inputtext _55r1 _6luy"));
		//WebElement username= driver.findElement(By.cssSelector("input[data-testid='royal_email']"));
		//WebElement username= driver.findElement(By.cssSelector("input.inputtext _55r1 _6luy[data-testid='royal_email']"));
		WebElement username= driver.findElement(By.xpath("//input[@data-testid='royal_email']"));
		
		
		username.sendKeys("sathish kumar");
		//username.clear();
		driver.findElement(By.name("email")).sendKeys("besant");
		//driver.findElement(By.linkText("Forgotten password?")).click();
		driver.findElement(By.partialLinkText("sword?")).click();
		//driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("besant");
		/*driver.manage().window().minimize();
		driver.manage().window().setSize(new Dimension(200,600));
		driver.close();
		driver.quit();*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		firstclass f = new firstclass();
		f.launch();
	}

}
