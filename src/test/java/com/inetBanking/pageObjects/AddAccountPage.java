package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAccountPage {
	WebDriver ldriver;
	
	public AddAccountPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
		
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[5]/a")
	@CacheLookup
	WebElement lnkAddNewAccount;
	
	@FindBy(how = How.NAME, using="cusid")
	@CacheLookup
	WebElement txtCustID;
	
	@FindBy(how = How.NAME, using="selaccount")
	@CacheLookup
	WebElement luAcctType;
	
	@FindBy(how = How.NAME, using="inideposit")
	@CacheLookup
	WebElement txtIniDeposit;
	
	@CacheLookup
	@FindBy(how = How.NAME, using="button2")
	WebElement btnSubmit;
	
	public void clickNewAccount()
	{
		lnkAddNewAccount.click();
	}
	
	public void setCustomerId(String custID)
	{
		txtCustID.sendKeys(custID);
	}
	
	public void selectAccttype(String acctType) throws InterruptedException
	{
		 Select select = new Select(luAcctType);
	     select.selectByValue(acctType);
	     Thread.sleep(3000);
	}
	public void SetIniDeposti(String amount)
	{
		txtIniDeposit.sendKeys(amount);
	}
	
	public void ClickSubmitbutton()
	{
		btnSubmit.click();
	}

}
