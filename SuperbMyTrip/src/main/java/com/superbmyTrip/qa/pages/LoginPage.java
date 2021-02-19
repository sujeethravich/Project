package com.superbmyTrip.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.superbmyTrip.qa.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(id="UserName")
	WebElement mailid;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='https://superbmytrip.com/Content/images/logo.png']")
	WebElement logo;
	
	//intializing the pagefactory elements
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
		
		
	}
	
	public boolean validateLogImage() {
		return logo.isDisplayed();
		
	}
	
	public HomePage login(String un,String pwd) {
		mailid.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
		return null;
		
		//return HomePage();
		
	}
}
