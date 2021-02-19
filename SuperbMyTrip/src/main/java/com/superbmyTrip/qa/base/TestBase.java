package com.superbmyTrip.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.superbTrip.qa.util.TestUtil;

public class TestBase
{
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream ipss=new FileInputStream("E:\\SUJEETH\\Workspace\\SuperbMyTrip\\src\\main\\java\\com\\superbTrip\\qa\\config\\config.properties");
			try {
				prop.load(ipss);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void intialization()
	{
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
}
		else if(browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\SUJEETH\\SOFTWARES\\WebDriver\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.IE.driver", "E:\\SUJEETH\\SOFTWARES\\WebDriver\\internetexplorer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
