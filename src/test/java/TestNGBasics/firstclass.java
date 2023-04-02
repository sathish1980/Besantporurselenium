package TestNGBasics;
import org.testng.annotations.*;

public class firstclass {
	
	
	
	@AfterTest(alwaysRun=true)
	public void AfterTest()
	{
		System.out.println("AfterTest");
	}
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClass()
	{
		System.out.println("BeforeClass");
	}

	@AfterClass(alwaysRun=true)
	public void AfterClass()
	{
		System.out.println("AfterClass");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethod()
	{
		System.out.println("BeforeMethod");
	}

	@AfterMethod(alwaysRun=true)
	public void AfterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	
	
	@Test(priority=0,timeOut=60,groups="Sanity")
	public void Testcase2()
	{
		System.out.println("Testcase 2");
	}
	
	@Test(priority=-1,enabled=true,description="login",dependsOnMethods="Testcase2",invocationCount=5,invocationTimeOut=60,groups= {"Sanity","SIT"})
	public void Testcase1() throws InterruptedException
	{
		System.out.println("Testcase 1");
		//Thread.sleep(10000);
	}
	
	@Test(priority=1,groups="SIT")
	public void Testcase3()
	{
		System.out.println("Testcase 3");
	}
}

