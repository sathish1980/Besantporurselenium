package Testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.ExcelfileTest;

public class dataproviders {
	
	@DataProvider(name="testdata")
	public Object[][] LoginTestdata() throws IOException
	{
		ExcelfileTest T = new ExcelfileTest();
		return T.ExcelReaddata("testdata.xlsx","input");
	}

}
