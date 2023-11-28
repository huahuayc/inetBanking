package com.inetBanking.testCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.inetBanking.utilities.XLUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {

	public static void main(String[] args) throws IOException {
//		WebDriverManager.chromedriver().setup();  //base
//		WebDriver driver = new ChromeDriver();    // base
//        driver.get("https://www.zoho.com/");   // properties
       
       String xlfile= "";
       String  xlsheet = "";
       String path =System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
      // String path = "C:/eclipse-javalearning/SeleniumAutomationFrameWork/inetBankingV1/src/test/java/com/inetBanking/testData/LoginData.xlsx";
	  
   
      
     int rownum = getRowCount(path, "login");
   
     System.out.println(rownum);
       
	}
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		System.out.println("tt1");
		fi = new FileInputStream(xlfile);

		System.out.println("tt2");
		wb = new XSSFWorkbook(fi);

		System.out.println("tt3");
		ws = wb.getSheet(xlsheet);
		
		System.out.println(xlfile);
		System.out.println(xlsheet);
		int rowcount = ws.getLastRowNum();
		
		
		wb.close();
		fi.close();
		return rowcount;
	}
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	

}
