package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	LoginPage lgpage;	
	HomePage homepage;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		lgpage=new LoginPage();
	}	
	/*@Test(priority=0)
	public void logintitleValidate()
	{
		String Title=lgpage.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title,"#1 Free CRM software in the cloud for sales and service");			
	}*/
	@Test(priority=1)
	public void validateCRMLogo()
	{
		System.out.println("CRMLogo");
	  Assert.assertEquals(lgpage.validateCRMlogo(),true);	
	}
	@Test(priority=2)
	public void logintest() 
	{	
		homepage=lgpage.Login(prop.getProperty("username"), prop.getProperty("password"));		//Returning HomePage class object
	}	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
