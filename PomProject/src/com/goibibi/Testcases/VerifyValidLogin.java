package com.goibibi.Testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.goibibo.Pages.LoginPageNew;

import Helper.BrowserFactory;
import Helper.Screenshots;

/**
 * @author ASUS
 *
 */
public class VerifyValidLogin 
{
 
   WebDriver driver;
   LoginPageNew login_Page;

    @BeforeTest
    public void BeforeTest()
    {
   	 driver=BrowserFactory.StartBrowser("chrome");
    }
    
    @Test(description="Enter Valid username and Password")
	public void checkvaliduser()
	{        
       login_Page=new LoginPageNew(driver);
	   login_Page.Login_Wordpress("opensourcecms","opensourcecms");	   
	   String title=login_Page.Title();
	   System.out.println(title);
	   login_Page.Logout();	
	}
    
    @Test(description="Enter Invalid username and Password and get Error Massage")
   	public void checkInvaliduser()
   	{  
       login_Page=new LoginPageNew(driver);
   	   login_Page.Login_Wordpress("opensourcecm","opensourcecm");
   	   String msg= login_Page.Error();
   	   System.out.println(msg);
   	}
    
    @Test(description="Get Login Panel Heading Text")
    public void Login_PanelHeadingText()
    {
         try 
         {
			 login_Page=new LoginPageNew(driver);
			 String Panel_Heading= login_Page.getloginpaneltext();
			 assertEquals(Panel_Heading,"LOGIN Panel");
		}
         catch (Exception e) 
         {
		   System.out.println(e.getMessage());
		    
		}
        
    }
    
    @Test(description="Get Login Page Url and compare actual with expected url")
    public void getloginurl()
    {
       try 
       {
		   String LoginPage_Url= login_Page.getloginurl();
		   assertEquals(LoginPage_Url,"https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
		   
	   } 
      catch (Exception e)
       {
		
		System.out.println(e.getMessage());
	   }
       
    }
      
    @AfterMethod
    public void screenshots(ITestResult result) throws Exception
    {
    	if(ITestResult.FAILURE==result.getStatus())
    	{
    		Screenshots.capturescreenshots(driver, result.getName());
    	}
    }
        
    @AfterTest
    public void Aftertest()
    {
       driver.close();	
    }
    
}
