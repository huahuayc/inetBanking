package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddAccountPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_AddAccountDDt_006 extends BaseClass {
	
	
	@Test(dataProvider = "LoginData")
	public void addNewAccountDDT(String custID, String acct, String deposit) throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.loginApp(username,password) ;
		
		System.out.println(custID + " " + acct +" "+ deposit);
		
		AddAccountPage addAccount = new AddAccountPage(driver);
		addAccount.clickNewAccount();
		
		addAccount.setCustomerId(custID);
		addAccount.selectAccttype(acct);
		addAccount.SetIniDeposti(deposit);
		addAccount.ClickSubmitbutton();
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		System.out.println(path);
		int rownum = XLUtils.getRowCount(path, "sheet2");
		int colcount = XLUtils.getCellCount(path, "sheet2",1);
		String logindata[][] = new String[rownum][colcount];
		for (int i=1; i<=rownum; i++)
		{
			
			for( int j= 0; j<colcount;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "sheet2", i, j);
			}
			
		}
		return logindata;
	}

}
