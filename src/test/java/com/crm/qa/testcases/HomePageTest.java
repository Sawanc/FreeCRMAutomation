package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage homepage ;
	TestUtil tstutil;
	ContactPage contactpage;
	public HomePageTest()
	{
		super();	
	}
	//@BeforeClass
	@BeforeMethod
	public void setup() 
	{
		initialization();//Initalizing Chrome/Firefox  browser
		loginpage=new LoginPage();	
		tstutil=new TestUtil();
		contactpage=new ContactPage();
	  	homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));//Returning HomePage class object	    

	}		/*
	@Test(priority=1)
	public void ValidateHomePageTitleTest() 
	{
		String Homepagetitle=homepage.verifyHomepagetitle();
		Assert.assertEquals(Homepagetitle,"CRMPRO","HomePage Title is not matched");	   
	}
	*/
	@Test(priority=2)
	public void ValidateUserName()
	{
		tstutil.switchToFrame();
		Assert.assertTrue(homepage.verifyUserName(),"UserName is not displayed");
	
	}		 
	@AfterMethod
	public void tearDown()	
	{
		driver.quit();
	}
}
