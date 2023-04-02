package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
	
	public static WebDriver driver;
	
	public void launch(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
		}
	}

}
