package BrowserDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class OldBrowser {
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	//private String reportPath=System.getProperty("user.dir")+"\\Reports\\";
	public String reportPath ="C:\\Users\\sathishkumar\\eclipse-workspace\\besantporurselenium\\";
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
			EdgeOptions options = new EdgeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-Notifications");
			driver = new EdgeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
		}
		report = new ExtentReports(reportPath+"Report//extentreport.html",true);
		test= report.startTest("Facebook Automation report");	
	
		//report = new ExtentReports("C:\\Users\\sathishkumar\\eclipse-workspace\\besantporurselenium\\Input\\",false);
		//test = report.startTest("Automation Report");
	}
	
	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
	      //This method returns the time in millis
	    long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//Screenshot//"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Destinationfile.toString();
	}
	

}
