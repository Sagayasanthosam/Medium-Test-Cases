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
import com.training.pom.CreatePropertyFeaturePOM;
import com.training.pom.LoginPOM;
import com.training.pom.VerifyPostAddedPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreatePropertyFeatureTests {
	private WebDriver driver;
	private String baseUrl;
	private CreatePropertyFeaturePOM createpropertyfeaturepom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		createpropertyfeaturepom = new CreatePropertyFeaturePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);	
	}
	
	@Test (priority=1)
	public void validLoginTest() {
		createpropertyfeaturepom.sendUserName("admin");
		createpropertyfeaturepom.sendPassword("admin@123");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		createpropertyfeaturepom.clickLoginBtn();
	}

	
	@Test (priority=2)
	public void createPostsCategory() throws InterruptedException  {
		
		createpropertyfeaturepom.ClickProperty();
		createpropertyfeaturepom.ViewPropertyList();
		screenShot.captureScreenShot("Featurespage");
		createpropertyfeaturepom.EnterName("Shantiniketan");
		createpropertyfeaturepom.EnterSlug("Prestige");
		createpropertyfeaturepom.SelectParentFeature();
		createpropertyfeaturepom.EnterDescription("New Launches of Apartments");
		createpropertyfeaturepom.clickSubmitBtn();
		createpropertyfeaturepom.SearchFeature("Shantiniketan");
		screenShot.captureScreenShot("NewFeatureAdded");
		createpropertyfeaturepom.AddNewProperty();
		createpropertyfeaturepom.EnterTitle("Prestige");
		createpropertyfeaturepom.EnterText("Home Town");
		createpropertyfeaturepom.SelectFeat();
		createpropertyfeaturepom.ClickPublish();
		screenShot.captureScreenShot("PublishProperty");
		createpropertyfeaturepom.VerifyPost();
	}


	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}





