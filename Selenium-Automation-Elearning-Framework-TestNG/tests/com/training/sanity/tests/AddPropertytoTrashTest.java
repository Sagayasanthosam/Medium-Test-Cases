package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPostCategoryPOM;
import com.training.pom.AddPropertytoTrashPOM;
import com.training.pom.CreatePropertyFeaturePOM;
import com.training.pom.LoginPOM;
import com.training.pom.VerifyPostAddedPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddPropertytoTrashTest {
	private WebDriver driver;
	private String baseUrl;
	private AddPropertytoTrashPOM addpropertytotrashpom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addpropertytotrashpom = new AddPropertytoTrashPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);	
	}
	
	@Test (priority=1)
	public void validLoginTest() {
		addpropertytotrashpom.sendUserName("admin");
		addpropertytotrashpom.sendPassword("admin@123");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		addpropertytotrashpom.clickLoginBtn();
	}

	
	@Test (priority=2)
	public void createPostsCategory() throws InterruptedException  {
		
		addpropertytotrashpom.ClickProperty();
		addpropertytotrashpom.ViewPropertyList();
		addpropertytotrashpom.AddNewProperty();
		addpropertytotrashpom.EnterTitle("Brigade");
		addpropertytotrashpom.EnterText("Gateway");
		addpropertytotrashpom.SelectFeat();
		addpropertytotrashpom.SelectRegion();
		screenShot.captureScreenShot("RegionSelection");
		addpropertytotrashpom.MoveToTrash();
		addpropertytotrashpom.HandleAlert();
		screenShot.captureScreenShot("TrashItem");
		
	}


	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}





