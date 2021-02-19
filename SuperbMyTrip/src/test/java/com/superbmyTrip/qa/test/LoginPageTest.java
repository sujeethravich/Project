package com.superbmyTrip.qa.test;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.superbmyTrip.qa.base.TestBase;
import com.superbmyTrip.qa.pages.HomePage;
import com.superbmyTrip.qa.pages.LoginPage;
public class LoginPageTest extends TestBase{


	public LoginPage loginpage;
	public HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
		@BeforeMethod
		public void setUp()
		{
			intialization();
			
			loginpage=new LoginPage();
		}
		@Test(priority=1)
		public void loginpageTitleTest()
		{
			String title=loginpage.validateLoginPageTitle();
			//Assert.assertEquals(title,"");
			
			Assert.assertEquals(title,"SuperbMyTrip User Login");
		}
		@Test(priority=2)
		public void LogoTest()
		{
			boolean logo=loginpage.validateLogImage();
			Assert.assertTrue(logo);
		}
		
		@Test
		public void loginTest() {
			homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
			
			
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
