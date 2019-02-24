package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase

{	
	//AFter First Push then Commit
		
   @FindBy(xpath="//td[contains(text(),'User: Sawan Choubisa')]")
    WebElement usrname;
      
   @FindBy(xpath="//a[contains(text(),'Contacts')]")
   WebElement contactButton;
   
   @FindBy(xpath="//a[contains(text(),'New Contact')]")
   WebElement newcontactButton;
   
   @FindBy(xpath="//a[contains(text(),'Deals')]")
   WebElement dealstButton;

   @FindBy(xpath="//a[contains(text(),'Tasks')]")
   WebElement TasktButton;
    
   public HomePage()
  { 
	//   System.out.println("Before printed");
          PageFactory.initElements(driver, this);  
	 // System.out.println("After Printed");
	  }
  
   public String verifyHomepagetitle()
  {
	  String Title=driver.getTitle();
	  System.out.println(Title);
     System.out.println("Printed after Commit");
	  return Title;
  }  
  public boolean verifyUserName()
  {
	  
	return usrname.isDisplayed();     
  }  
  public ContactPage ClickOnContacts()
  {
	  //Actions action= new Actions(driver);
	  contactButton.click();
	  return new ContactPage();	  
  }
  public void ClickOnNewContacts()
  { 
	    Actions action = new Actions(driver);
		action.moveToElement(contactButton).build().perform();
		newcontactButton.click();		
  }  
  public DealsPage ClickOnDeals()
  {
	  contactButton.click();
	  return new DealsPage();	  
  }
  public ContactPage ClickOnTask()
  {
	  contactButton.click();
	  return new ContactPage();	  
  }
}
