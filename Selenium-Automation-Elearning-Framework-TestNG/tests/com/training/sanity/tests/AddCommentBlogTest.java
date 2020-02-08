package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCommentBlogPOM;
import com.training.pom.AddNewPostCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCommentBlogTest {
	private WebDriver driver;
	private String childURL;
	private String baseURL;
	private AddCommentBlogPOM addcommentblogpom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addcommentblogpom = new AddCommentBlogPOM(driver); 
		childURL = properties.getProperty("childURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(childURL);	
	}
	
	@Test (priority=1)
	public void validLoginTest() {
		//loginadminpom.clickSignIn();
		addcommentblogpom.sendUserName("jfsagayasanthosam1@gmail.com");
		addcommentblogpom.sendPassword("Saga@123");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		addcommentblogpom.clickLoginBtn();
	}

	
	@Test (priority=2)
	public void createPostsCategory() throws InterruptedException  {
			
			addcommentblogpom.Blogs();
			addcommentblogpom.Postdetails();
			addcommentblogpom.ReadmoreDetails();
			addcommentblogpom.AddCommentDetails("Good");
			addcommentblogpom.clickSubmitBtn();
			addcommentblogpom.clickLogoutBtn();
			addcommentblogpom.ViewAdminBlog();
			addcommentblogpom.sendUserName("admin");
			addcommentblogpom.sendPassword("admin@123");
			addcommentblogpom.clickLoginBtn();
			addcommentblogpom.ViewComments();
			screenShot.captureScreenShot("ViewComments");
			addcommentblogpom.ReplyComment("Thanks for the compliment");
			screenShot.captureScreenShot("CommentsPosted");
			
	}
					
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}





