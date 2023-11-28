package com.inetBanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddUserPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddUserTest_005 extends BaseClass  {
	
	@Test
	public void addNewUser() throws InterruptedException
	{
		
		LoginPage lp= new LoginPage(driver);
		AddUserPage adduser = new AddUserPage(driver);
		adduser.clickInsuranceProj();
		
		// driver.switchTo().alert().sendKeys("Close");
		// ClosecommericalAd();
		
		adduser.clickRegister();
		
		adduser.selectTitle("Miss");
		adduser.setUserfname("hua");
		adduser.setUserlname("Cooper");
		adduser.setUserphone("123456789");
	
	    adduser.selectyear("1980");
		adduser.selectmonth("3");
	    adduser.selectday("5");
		
		adduser.clickRadioButton();
		
		Thread.sleep(3000);
		
		
		
	}
	

}
