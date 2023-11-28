package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL=readConfig.getApplicationURL();
	public String username= readConfig.getUserName();
	public String password=readConfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//String br = readConfig.getBrowserType();
		//logger = Logger.getLogger("eBanking");
	  //  PropertyConfigurator.configure("Log4j.properties");
	    
	    if ( br.equals("chrome"))
	    {
			WebDriverManager.chromedriver().setup();  
			System.out.println("start loding chrome");
			driver = new ChromeDriver();
			System.out.println("loding chrome");
			
	    }
	    else  if ( br.equals("edge"))
	    {
			WebDriverManager.edgedriver().setup();  
			driver = new EdgeDriver();
	    }
	    else  if ( br.equals("firfox"))
	    {
			WebDriverManager.firefoxdriver().setup();  
			driver = new FirefoxDriver();
	    }
	    
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.get(baseURL);
	    
//	    if (logger.isTraceEnabled())
//	    {
//	    	System.out.println("lggoing1");
//	    }
//	    else
//	    {
//		    System.out.println("not loggging nothing");
//		    logger.info("browser will open");
//	    }
	    
	 //   loginApp();
	
	}
	
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	
	public void captureScreen( WebDriver driver, String tname) throws IOException {
	
		System.out.println("Screenshot take");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname+".png");
		FileUtils.copyFile(source, target);
		
	}
	
//	private void loginApp()
//	{
//		LoginPage lp = new LoginPage(driver);
//		lp.setUserName(username);
//		lp.setPassword(password);
//		lp.clickSumit();
//	}
	
//	public LoginPage loginApp()
//	{
//		LoginPage lp = new LoginPage(driver);
//		lp.setUserName(username);
//		lp.setPassword(password);
//		lp.clickSumit();
//		return lp;
//	}
	
	public void ClosecommericalAd() throws InterruptedException {
		System.out.println("before");		
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(frame1);
		WebElement frame2 = driver.findElement(By.id("ad_iframe"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		driver.switchTo().defaultContent();
		System.out.println("after");		
	}
	
	
	
	

}
