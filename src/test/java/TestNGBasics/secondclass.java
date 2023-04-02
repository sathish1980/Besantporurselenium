package TestNGBasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class secondclass {
	@BeforeSuite(alwaysRun=true)
	public void BeforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite(alwaysRun=true)
	public void AfterSuite()
	{
		System.out.println("AfterSuite");
	}
	
	@BeforeTest(alwaysRun=true)
	public void BeforeTest()
	{
		System.out.println("BeforeTest");
	}
	
	@Test(groups="Sanity")
	public void testcase1insecondclass()
	{
		System.out.println("testcase1insecondclass");
	}
	
}
