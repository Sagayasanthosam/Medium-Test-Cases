package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DoneQuisPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
	
public class DoneQuisTest {
		
		private WebDriver driver;
		private String baseUrl;
		private static Properties properties;
		private ScreenShot screenShot;
		public DoneQuisPOM donequispom;
			
		
		@BeforeTest
		public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			donequispom= new DoneQuisPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);	
		}

		
		@Test (priority=1)
		public void validLoginTest() {
			donequispom.clickSignIn();
			donequispom.sendUserName("jfsagayasanthosam1@gmail.com");
			donequispom.sendPassword("Saga@123");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,150)");
			donequispom.clickLoginBtn(); 
		}
		
		@Test (priority=2)
		public void DoneQues()  {
			donequispom.villaTab.click();
			donequispom.dneQuis.click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.scrollBy(0,500)");
			donequispom.Sendname("Saga");
			donequispom.Sendemail("Saga@gmail.com");
			donequispom.Sendsubject("Apartments");
			donequispom.Sendmessage("Looking for Apartments");
			js.executeScript("window.scrollBy(0,200)");
			donequispom.SubmitBtn();
			donequispom.verifyText();	
		}
		
		@AfterTest
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
}





