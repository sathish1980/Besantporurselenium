package BrowserDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Browser {
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	//private String reportPath=System.getProperty("user.dir")+"\\Reports\\";
	//public String reportPath ="C:\\Users\\sathishkumar\\eclipse-workspace\\besantporurselenium\\Repo";
	public void launch(String browserName)
	{
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-Notifications");
			//options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
		}
		//report = new ExtentReports("C:\\Users\\sathishkumar\\eclipse-workspace\\besantporurselenium\\Input\\",false);
		//test = report.startTest("Automation Report");
	}
	
	

}
