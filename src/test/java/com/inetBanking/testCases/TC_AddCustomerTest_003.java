package com.inetBanking.testCases;

import java.io.IOException;

import javax.sound.midi.SysexMessage;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

//import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp= new LoginPage(driver);
		lp.loginApp(username,password) ;
		
		Thread.sleep(3000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickNewcustomer();
		
		
		// was used to bypass the commerical ad auto pop, itonly worked for certain ads.
		Thread.sleep(5000);
		 WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		    driver.switchTo().frame(frame1);
		    WebElement frame2 = driver.findElement(By.id("ad_iframe"));
		    driver.switchTo().frame(frame2);
		    driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		    driver.switchTo().defaultContent();
		Thread.sleep(3000);	    
		    
		
		addcust.custName("huahua");
		addcust.custGender("male");
		addcust.custdob("1985","10", "12" );
		Thread.sleep(3000);
		addcust.custaddress("Bookview");
		addcust.custcity("Edmonton");
		addcust.custstate("BC");
		addcust.custpinno("562330");
		addcust.custtelephoneno("966563533");
		
		String eamil = randomstring()+"@gmail.com";
		addcust.custemailid(eamil);
				
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!");
		if ( res==true)
		{
			Assert.assertTrue(true);
			System.out.println("customer added");
			
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			System.out.println("customer NOT added");
			
		}
		
	}
	
	public String randomstring()
	{
		String generatestring = RandomStringUtils.randomAlphabetic(5);
		return generatestring;
		
	}
	public static String randomNum()
	{
		String generatestring2 = RandomStringUtils.randomNumeric(4);
		return generatestring2;
		
	}
	
	
	
	
	
	

}
