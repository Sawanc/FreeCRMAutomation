package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;

 public class LoginPage extends TestBase

{
    //Page Factory //Object Repository and Comment added 	
	WebDriverWait expwait;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@value='Login' and @type='submit']")
	WebElement loginbtn;

    @FindBy(xpath="//font[(text()='Sign Up')]")    
	WebElement signup;
    
    
    @FindBy(xpath="//a[@class=\"navbar-brand\" ]//img[@class=\"img-responsive\"]")
    WebElement crmLogo;
    
    public LoginPage()
	{
		PageFactory.initElements(driver,this);
		
	}	
	public String getTitle()
	{
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);	
		return driver.getTitle();
	}	
	public boolean validateCRMlogo()
	{
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		
		return crmLogo.isDisplayed();
	}
	public HomePage Login(String un,String ps)
	{
		username.sendKeys(un);
		password.sendKeys(ps);
		loginbtn.submit();	
       
		return new HomePage();
	}
}
