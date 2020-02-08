package com.training.sanity.tests;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FindYourHomePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
	
public class FindyourhomeTest {
		
		private WebDriver driver;
		private String baseUrl;
		private static Properties properties;
		private ScreenShot screenShot;
		public FindYourHomePOM findyourhomepom;
			
		
		@BeforeTest
		public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			findyourhomepom= new FindYourHomePOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		@Test (priority=1)
		public void validLoginTest() {
			findyourhomepom.clickSignIn();
			findyourhomepom.sendUserName("jfsagayasanthosam1@gmail.com");
			findyourhomepom.sendPassword("Saga@123");
			findyourhomepom.clickLoginBtn(); 		
		}
		
		@Test (priority=2)
		public void SearchhomeTest()  {
			findyourhomepom.newlaunchtab.click();
			findyourhomepom.sendAddress("Electronic City");
			findyourhomepom.selectPropertyType();
			findyourhomepom.clickSearch();
		}
	
		@AfterTest
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
}





