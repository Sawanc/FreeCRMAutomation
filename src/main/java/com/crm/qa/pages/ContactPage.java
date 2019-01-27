package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase

{
	 @FindBy(xpath="//td[@class='headertext' and contains(text(),'Sawan')]")
	    WebElement contactLabel;
	 
	 @FindBy(xpath="//input[@name='first_name' and @id='first_name']")
	 WebElement firstname;
	 
	 @FindBy(xpath="//input[@name='surname' and @id='surname']")
	 WebElement lastName;
	 
	 @FindBy(xpath="//input[@name='client_lookup' and @type='text']")
	 WebElement company;
	 
	 
	 @FindBy(xpath = "//input[@type='submit' and @value='Save']")
		WebElement saveBtn;
		

	/* @FindBy(xpath="//a[text()='Keshav Parashar']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"
	 		+ "//input[@name='contact_id']")
	    WebElement selectContact;*/
	 	 
	 public ContactPage()
	 {
		 PageFactory.initElements(driver,this);
	 }	 
	 
	 public boolean verifycontactLabel()
	 {
		 
	    return contactLabel.isDisplayed();	 
	 }
	 
	 public void selectContactName(String name)
	 {
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();		 
	 }
	 
	 public void createNewContact(String FirstName,String LastName,String Company){
			/*
		    Select select = new Select(driver.findElement(By.name("title")));
			select.selectByVisibleText(title);
			*/
			firstname.sendKeys(FirstName);
			lastName.sendKeys(LastName);
			company.sendKeys(Company);
			saveBtn.click();
	 }
	
	
}
