package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname) throws InterruptedException
	{
		txtUserName.sendKeys(uname);
		Thread.sleep(3000);
	}
	
	public void setPassword(String pwd) throws InterruptedException
	{
		txtPassword.sendKeys(pwd);
		Thread.sleep(3000);
	}
	
	public void clickSumit()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	public void  loginApp(String username, String password) throws InterruptedException
	{
		
		setUserName(username);
		setPassword(password);
		clickSumit();
		
	}

}
