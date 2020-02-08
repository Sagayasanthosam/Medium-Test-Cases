package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
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
import com.training.pom.MortgageCalcPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
	
public class MortgageCalcTest {
		
		private WebDriver driver;
		private String baseUrl;
		private static Properties properties;
		private ScreenShot screenShot;
		public MortgageCalcPOM mortgagecalcpom;
			
		
		@BeforeTest
		public void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			mortgagecalcpom= new MortgageCalcPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			
		}
		
		@Test (priority=1)
		public void validLoginTest() {
			mortgagecalcpom.clickSignIn();
			mortgagecalcpom.sendUserName("jfsagayasanthosam1@gmail.com");
			mortgagecalcpom.sendPassword("Saga@123");
			mortgagecalcpom.clickLoginBtn(); 
		}
		
		@Test (priority=2)
		public void MortgageCalculate()  {
			mortgagecalcpom.villaTab.click();
			mortgagecalcpom.dneQuis.click();
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			mortgagecalcpom.sendAmount("4000000");
			mortgagecalcpom.sendDownPayment("200000");
			mortgagecalcpom.sendLoanYears("20");
			mortgagecalcpom.sendInterestRate("7.25");
			mortgagecalcpom.clickCalculateBtn();
			mortgagecalcpom.verifyText();
		}
	
		@AfterTest
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
}





