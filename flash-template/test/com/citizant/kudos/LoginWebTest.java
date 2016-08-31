	package com.citizant.kudos;

	import java.io.IOException;
	import java.net.URL;

	import org.junit.AfterClass;
	import org.junit.Assert;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Capabilities;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;

	public class LoginWebTest {
		private static String seleniumHub= "http://54.174.151.21:4444/wd/hub";
		private static String startPage = "http://54.196.239.109:8090/kudos";
		private  static WebDriver driver;
		
		@BeforeClass
		public static void setUpDriver() throws IOException
		{								
		    Capabilities cap = DesiredCapabilities.firefox();	    
		    driver = new RemoteWebDriver(new URL(seleniumHub),cap);	   
		}
			   
		@Test	
		
				    
		    public void testSeleniumInfrastructure() throws IOException, InterruptedException {   
			driver.get(startPage);
			Assert.assertEquals(driver.getTitle(),"Flash");
		    
		    driver.findElement(By.id("email_id")).sendKeys("admin@kudo.com");
		    driver.findElement(By.id("password_id")).sendKeys("12345");
		    driver.findElement(By.id("btnSubmit")).click();
		    
		}
		    
		    @AfterClass	    
			public static void  tearDownDriver(){	
				driver.quit();
		   
		}
		  }
		
	
