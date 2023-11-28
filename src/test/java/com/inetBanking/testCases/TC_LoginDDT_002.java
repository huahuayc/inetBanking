package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.loginApp(user, pwd);
		System.out.println("usrname: " +user + " pwd: " + pwd);
		 
	
		Thread.sleep(3000);
		
		if ( isAlertPresent() == true )
		{
			System.out.println("uaename and pwd are wrong");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);  // test failed
		}
		else
		{
			System.out.println("uaename and pwd are correct");
			//driver.switchTo().alert().accept();
			Assert.assertTrue(true);  // test passed
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();  // close alert: you have successfully logged out
			driver.switchTo().defaultContent();
			
		}
	}
	public boolean isAlertPresent()   // user defined method created to check alert is shown or not
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch( NoAlertPresentException e)
		{
			return false;
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
	    int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1",1);
		String logindata[][] = new String[rownum][colcount];
		for (int i=1; i<=rownum; i++)
		{
			
			for( int j= 0; j<colcount;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "sheet1", i, j);
			}
			
		}
		return logindata;
	}

}
