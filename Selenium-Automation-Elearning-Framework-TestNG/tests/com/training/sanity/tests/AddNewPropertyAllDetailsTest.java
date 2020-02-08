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
import com.training.pom.AddNewPropertyAllDetailsPOM;
import com.training.pom.AddPropertytoTrashPOM;
import com.training.pom.CreatePropertyFeaturePOM;
import com.training.pom.LoginPOM;
import com.training.pom.VerifyPostAddedPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewPropertyAllDetailsTest {
	private WebDriver driver;
	private String baseUrl;
	private AddNewPropertyAllDetailsPOM addnewpropertyalldetailspom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addnewpropertyalldetailspom = new AddNewPropertyAllDetailsPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);	
	}
	
	@Test (priority=1)
	public void validLoginTest() {
		addnewpropertyalldetailspom.sendUserName("admin");
		addnewpropertyalldetailspom.sendPassword("admin@123");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		addnewpropertyalldetailspom.clickLoginBtn();
	}

	
	@Test (priority=2)
	public void createPostsCategory() throws InterruptedException  {
		
		addnewpropertyalldetailspom.ClickProperty();
		addnewpropertyalldetailspom.ViewPropertyList();
		addnewpropertyalldetailspom.AddNewProperty();
		addnewpropertyalldetailspom.EnterTitle("New Launch");
		addnewpropertyalldetailspom.EnterText("New Launch Bangalore");
		addnewpropertyalldetailspom.EnterPrice("20000");
		addnewpropertyalldetailspom.EnterPricePerSqFt("2500");
		addnewpropertyalldetailspom.ClickMainDetails();
		addnewpropertyalldetailspom.EnterStatus("New");
		addnewpropertyalldetailspom.EnterLocation("Electronic City");
		addnewpropertyalldetailspom.EnterPossesion("Immediate");
		addnewpropertyalldetailspom.ClickLocationTab();
		addnewpropertyalldetailspom.EnterAddress("Yeshvantpur");
		addnewpropertyalldetailspom.EnterMapAddress("Yeshvantpur");
		addnewpropertyalldetailspom.EnterLatitude("102");
		addnewpropertyalldetailspom.EnterLongitude("60");
		addnewpropertyalldetailspom.ClickDetailsTab();
		addnewpropertyalldetailspom.EnterStorageRoom("3");
		addnewpropertyalldetailspom.SelectFeat();
		addnewpropertyalldetailspom.SelectRegion();
		addnewpropertyalldetailspom.ClickPublish();
		addnewpropertyalldetailspom.VerifyPost();
		screenShot.captureScreenShot("Postadded");
		
	}


	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}





