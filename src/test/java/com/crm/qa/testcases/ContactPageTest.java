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

public class ContactPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil tstutil;
    ContactPage contactpage;   
    String sheetName="Contacts";
    
	public ContactPageTest()
	{
		super();
	}		
	@BeforeMethod
	public void setup() 
	{
		initialization();
		loginpage=new LoginPage();	
		tstutil=new TestUtil();
		contactpage=new ContactPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));//Returning HomePage class object
		tstutil.switchToFrame();
		contactpage=homepage.ClickOnContacts();
	}	
	
	@Test(priority=1,enabled=false)
	public void verifyLabelName()
	{
		Assert.assertTrue(contactpage.verifycontactLabel());        	
	}
	
	@Test(priority=2,enabled=false)
	public void selectName()
	{
		contactpage.selectContactName("Keshav Parashar");	
	}
	@Test(priority=3,enabled=false)
	public void selectmultipleName()
	{
		contactpage.selectContactName("Keshav Parashar");
		contactpage.selectContactName("test12 test");		
		}
	@DataProvider	
	public Object[][] getCRMTestdata()
	{
		Object [][] data=TestUtil.getTestData(sheetName);
		return data;
	}
    @Test(priority=4,dataProvider="getCRMTestData")
	 public void validateCreateNewContact(String title,String fname,String lname,String company)
    	{
			    System.out.println("Before");
				homepage.ClickOnNewContacts();
				System.out.println("After");
				contactpage.createNewContact(title, fname, lname, company);			
		}				
	@AfterMethod		
	public void tearDown()	
	{
		driver.quit();
	}	
}
