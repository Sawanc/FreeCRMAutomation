package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil tstutil;
	public HomePageTest()
	{
		super();
	}	
	@BeforeMethod
	public void setup() 
	{
		initialization();
		loginpage=new LoginPage();	
		tstutil=new TestUtil();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));//Returning HomePage class object
	    
	}		
	@Test(priority=1)
	public void ValidateHomePageTitleTest() 
	{
		String Homepagetitle=homepage.verifyHomepagetitle();
		Assert.assertEquals(Homepagetitle,"CRMPRO","HomePage Title is not matched");	   
	}
	
	@Test(priority=2)
	public void ValidateUserName()
	{
		tstutil.switchToFrame();
		Assert.assertTrue(homepage.verifyUserName());
	}
	@AfterMethod
	public void tearDown()	
	{
		driver.quit();
	}
}
