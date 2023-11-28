package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
    @Test	
	public void loginTest() throws IOException, InterruptedException {
		
	    LoginPage lp= new LoginPage(driver);
	    System.out.println("user name" + username);
		lp.loginApp(username,password) ;
		
		System.out.println(driver.getTitle());
		if ( driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			//logger.info("Login test passed ");
			
		}
		else
		{
			captureScreen(driver,"loginTest");
			System.out.println("Login test failed" );
			Assert.assertTrue(false);
			//captureScreen(driver,"loginTest");
			System.out.println("Screenshot take??");
			//logger.info("Login test failed" );
			
		}
	}

}
