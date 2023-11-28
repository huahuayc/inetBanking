package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddAccountPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddAccount_004 extends BaseClass {
	
	@Test
	public void addNewAccount() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.loginApp(username,password) ;
		
		AddAccountPage addAccount = new AddAccountPage(driver);
		addAccount.clickNewAccount();
		
		addAccount.setCustomerId("3546");
		addAccount.selectAccttype("Savings");
		addAccount.SetIniDeposti("1000");
		addAccount.ClickSubmitbutton();
		
		// Thread.sleep(3000);
		 
		 boolean res = driver.getPageSource().contains("Account Generated Successfully!!");
			if ( res==true)
			{
				Assert.assertTrue(true);
				System.out.println("Account Generatedd");
				
			}
			else
			{
				captureScreen(driver, "addNewAccount");
				System.out.println("Account NOT Generatedd");
				
			}
		
		
	}
	
}
