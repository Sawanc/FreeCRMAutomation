package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.utilities.TestUtil;

public class TestBase 

{
	public static WebDriver driver; 	
	public static Properties prop;
	
	public TestBase() 
	{
		prop=new Properties();
	    FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\Sawan Choubisa\\eclipse-workspace\\TestAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	}
	
	public  void initialization()
	{
		 String browserName=prop.getProperty("browser");
		 
			if(browserName.equals("FF"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Sawan Choubisa\\Downloads\\geckodriver.exe");
					driver =new FirefoxDriver();
			}
			else if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Sawan Choubisa\\Downloads\\chromedriver.exe");
					driver =new ChromeDriver();
			}
			else if(browserName.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver","C:\\Users\\Sawan Choubisa\\Downloads\\IEDriverServer.exe");
					driver =new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);

			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
	}	
	}  

