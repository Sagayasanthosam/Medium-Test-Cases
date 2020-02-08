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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewPostCategoryTests {
	private WebDriver driver;
	private String baseUrl;
	private AddNewPostCategoryPOM addnewpostcategorypom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addnewpostcategorypom = new AddNewPostCategoryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);	
	}
	
	@Test (priority=1)
	public void validLoginTest() {
		//loginadminpom.clickSignIn();
		addnewpostcategorypom.sendUserName("admin");
		addnewpostcategorypom.sendPassword("admin@123");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		addnewpostcategorypom.clickLoginBtn();
	}

	
	@Test (priority=2)
	public void createPostsCategory() throws InterruptedException  {
			addnewpostcategorypom.NewPosts();
			addnewpostcategorypom.AddNew();
			screenShot.captureScreenShot("AddnewPosts");
			addnewpostcategorypom.AddNewCategory();
			addnewpostcategorypom.CategoryText("Plots");
			addnewpostcategorypom.SelectCategory();
			addnewpostcategorypom.AddNewCategoryBtn();
			screenShot.captureScreenShot("SelectCategory");
			addnewpostcategorypom.EnterTitle("Vihar");
			addnewpostcategorypom.EnterContent("New Launch in Plots");
			addnewpostcategorypom.SelectCateg();
			addnewpostcategorypom.ClickPublish();
			addnewpostcategorypom.VerifyPost();
			screenShot.captureScreenShot("PostPublished");
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}






