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
	//	test12 test
	}
	/*@DataProvider	
	public Object[][] getCRMTestdata()
	{
		Object [][] data=TestUtil.getTestData(sheetName);
		return data;
	}*/
	@Test(priority=4)
	public void createNewContact() throws InterruptedException
	{
		/*dataProvider="getCRMTestdata"
		System.out.println(FirstName);
		System.out.println(LastName);String Title,String FirstName,String LastName,String Company
		System.out.println(Company);
		*/
	    System.out.println("before Clicking");	
		homepage.ClickOnNewContacts();
	    System.out.println("After Clicking");
		contactpage.createNewContact("Fsjf", "absne","CApp");
	}
	
	@AfterMethod		
	public void tearDown()	
	{
		driver.quit();
	}	
}
