package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase

{
   @FindBy(xpath="//td[@class='headertext' and contains(text(),'Sawan')]")
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
	  PageFactory.initElements(driver,this);
  } 
  public String verifyHomepagetitle()
  {
	  String Title=driver.getTitle();
	  System.out.println(Title);
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
