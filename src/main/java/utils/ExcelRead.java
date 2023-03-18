package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	String filepath=System.getProperty("user.dir")+"//input//testdata.xlsx";
	String outfilepath=System.getProperty("user.dir")+"//input//testdataout.xlsx";
	
	public void readdata() throws IOException
	{
		File f = new File(filepath);
		FileInputStream FI = new FileInputStream(f);
		FileOutputStream FP = new FileOutputStream(outfilepath);
		XSSFWorkbook wkb = new XSSFWorkbook(FI);
		//write
		XSSFWorkbook outwkb = new XSSFWorkbook();
		Sheet sheet = wkb.getSheet("input");
		Sheet outsheet = outwkb.createSheet("input");
		int rowcount = sheet.getPhysicalNumberOfRows();
		for (int i=0;i<rowcount;i++)
		{
			Row row = sheet.getRow(i);
			Row outrow = outsheet.createRow(i);
			int columncount= row.getLastCellNum();
			for (int j=0;j<columncount;j++) 
			{
				Cell eachcell =row.getCell(j);
				Cell outeachcell =outrow.createCell(j);
				System.out.println(eachcell.getStringCellValue());
				outeachcell.setCellValue(eachcell.getStringCellValue());
			}
		}
		outwkb.write(FP);
		outwkb.close();
		FP.close();
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelRead E = new ExcelRead();
		E.readdata();
	}

}
