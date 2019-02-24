package com.crm.qa.utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil extends TestBase

{
   public static long PAGE_LOAD_TIMEOUT=20;
   
   public static long IMPLICIT_WAIT=10;
   
   WebDriverWait expwait= new WebDriverWait(driver,20);
   
   
   public static String TESTDATA_SHEET_PATH = "C:\\Users\\Sawan Choubisa\\eclipse-workspace\\TestAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM.xlsx";

	static Workbook book;
	static Sheet sheet;
	
   
   public void switchToFrame()
   {
	 	   driver.switchTo().frame("mainpanel");
   }     /*
     public  ArrayList<String> getTestDatamyway()
     {

   	  File src=new File("C:\\Users\\Sawan Choubisa\\eclipse-workspace\\TestAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM.xlsx"); 
   	   FileInputStream fls = null;
	try {
		fls = new FileInputStream(src);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//Class Will read  data from file
   	   
   	   XSSFWorkbook wb = null;
	try {
		wb = new XSSFWorkbook(fls);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//Will load Workbook for xlsx type file for xls file will use HSSFWorkbook
   	   //System.out.println("before");
   	   XSSFSheet sheet1=wb.getSheet("Contacts");
   	   //System.out.println("After");   
   	   int total_rows= sheet1.getLastRowNum();
   	  ArrayList <String>ls=new ArrayList<String>();
   	   for(int i=1;i<=total_rows;i++)
   	   {
   		   for(int j=0;j<sheet1.getRow(0).getLastCellNum();j++)
   		   { 
   			   String dt=sheet1.getRow(i).getCell(j).getStringCellValue();
   		       ls.add(dt);
   		   }
   	  }
   	   for(String s:ls)
   	   {
   		   System.out.println(s);
   	   }
   	   try {
		wb.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	   

        return ls;    	 
     }
   
*/   
     
   public static  Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	 			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	      //			 System.out.println(data[i][k]);				
	      }
		}
		return data;
	}
   
   

}
