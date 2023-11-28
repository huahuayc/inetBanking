package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {
	WebDriver driver;
	public AddUserPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//@FindBy(how = How.XPATH, using="//*[@id=\"navbar-brand-centered\"]/ul/li[2]/a")
	@FindBy(how = How.XPATH, using="//a[contains(text(),'Register')]")
	@CacheLookup
	WebElement btnRegister;
	
	@FindBy(how = How.LINK_TEXT, using="Insurance Project")
	@CacheLookup
	WebElement lnkInurProj;
	
	@FindBy(how = How.ID, using="user_title")
	@CacheLookup
	WebElement luTitle;
	
	@FindBy(how = How.ID, using="user_firstname")
	@CacheLookup
	WebElement txtUserfname;
	
	@FindBy(how = How.ID, using="user_surname")
	@CacheLookup
	WebElement txtUserlname;
	
	@FindBy(how = How.ID, using="user_phone")
	@CacheLookup
	WebElement txtUserphone;
	
	@FindBy(how = How.ID, using="user_dateofbirth_1i")
	@CacheLookup
	WebElement luYear;
	
	@FindBy(how = How.ID, using="user_dateofbirth_2i")
	@CacheLookup
	WebElement luMonth;
	
	@FindBy(how = How.ID, using="user_dateofbirth_3i")
	@CacheLookup
	WebElement luDay;
	
	@FindBy(how = How.ID, using="licencetype_f")
	@CacheLookup
	WebElement rgType;
	
	
	public void clickInsuranceProj() {
		lnkInurProj.click();
	}
	
	public void clickRegister() {
		btnRegister.click();
	}
	public void selectTitle(String title) 
	{
		 Select select = new Select(luTitle);
	     select.selectByValue(title);
	    // Thread.sleep(3000);
	}
	
	public void setUserfname(String fname)
	{
		txtUserfname.sendKeys(fname);
	}
	
	public void setUserlname(String lname) {
		txtUserlname.sendKeys(lname);
	}
	public void setUserphone(String phone) {
		
		txtUserphone.sendKeys(phone);
	}
	
	public void selectyear(String year) 
	{
		 Select select = new Select(luYear);
	     select.selectByValue(year);
	}
	public void selectmonth(String month)
	{
		 //luMonth.click();
		 Select select = new Select(luMonth);
		
	     select.selectByValue(month);
	}
	public void selectday(String day)
	{
		if (luMonth.isEnabled())
		{
			Select select = new Select(luMonth);
	        select.selectByValue(day);
	     
		}
		else
		{
			System.out.println("unable select");
		}
	}
	
	public void clickRadioButton()
	{
		rgType.click();
	}
	
	
	
}
