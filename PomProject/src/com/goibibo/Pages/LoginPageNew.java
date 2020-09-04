package com.goibibo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author ASUS
 *
 */
public class LoginPageNew
{
	WebDriver driver;
	
	public LoginPageNew(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='txtUsername']") @CacheLookup WebElement Username;
	@FindBy(how=How.XPATH,using="//input[@id='txtPassword']") @CacheLookup WebElement Password;
	@FindBy(how=How.XPATH,using="//input[@id='btnLogin']") @CacheLookup WebElement Login_Button;
    @FindBy(how=How.XPATH,using="//a[.='Logout']") @CacheLookup WebElement Logout_Button;
    @FindBy(how=How.XPATH,using="//div[@id='logInPanelHeading']") @CacheLookup WebElement Login_PanelHeading;
    @FindBy(id="spanMessage") WebElement error;
    
    public void Login_Wordpress(String Uid,String Pass)
    {
    	Username.sendKeys(Uid);
    	Password.sendKeys(Pass);
    	Login_Button.click();   	   	
    }
   
	public void Logout()
	{
	  Logout_Button.click();
		
	}
	
	public String getloginpaneltext()
	{
		String Panelheadingtext=Login_PanelHeading.getText();
		System.out.println("Panel Heading Text is "+Panelheadingtext);
		return Panelheadingtext;
	}
	
	public String getloginurl()
	{
		String loginpage_url=driver.getCurrentUrl();
		System.out.println("url is "+loginpage_url);
		return loginpage_url;
	}
	
	public String Error()
	{
		String msg=error.getText();
		return msg;
	}
	
	
	public String Title() 
	{
		String title=driver.getTitle();
		return title;
		
	}
}
