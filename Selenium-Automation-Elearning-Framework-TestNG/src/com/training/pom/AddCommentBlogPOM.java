package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCommentBlogPOM {
	private WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public AddCommentBlogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"responsive\"]/li[7]/a")
	private WebElement signin; 
	
	@FindBy(xpath="//*[@id=\"menu-item-617\"]/a")
	private WebElement ClkBlog;
	
	@FindBy(xpath="//div[@class='post-content']//a[contains(text(),'Prestige')]")
	private WebElement Blogdetails;
	
	@FindBy(linkText="Read More")
	private WebElement readmore;
	
	@FindBy(xpath="//section[1]//div[2]//form[1]//p[2]//textarea[1]")
	private WebElement AddComment; 
	
	@FindBy(xpath="//*[@id=\"submit\"]")
	private WebElement SubmitBtn; 
	
	@FindBy(xpath="//p[contains(text(),'Good')]")
	private WebElement AddedComment; 
	
	@FindBy(xpath="//section[1]//div[2]//form[1]//p[1]//a[2]")
	private WebElement logoutBtn; 
	
	@FindBy(xpath="//div[contains(text(),'Comments')]")
	private WebElement ClkComments; 
	
	@FindBy(xpath="//td[@class='author column-author']//a[contains(text(),'jfsagayasanthosam1@gmail.com')]")
	private WebElement mousehovercomment; 
	
	@FindBy(xpath="//a[@class='vim-r comment-inline'][contains(text(),'Reply')]")
	private WebElement ClkReply; 
	
	@FindBy(xpath="//textarea[@id='replycontent']")
	private WebElement replytext; 

	@FindBy(xpath="//span[@id='replybtn']")
	private WebElement clkreplybtn; 
	
		
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
		}
	
	public void clickSigninBtn() {
		this.signin.click(); 
		}
	public void Blogs() {
		this.ClkBlog.click();
		}

	public void Postdetails()  {
		String expected= "Prestige";
		String actual = Blogdetails.getText();
		Assert.assertEquals(actual, expected);	
		System.out.println(actual);
		}
	
	public void ReadmoreDetails()  {
		this.readmore.click();
	
		}
	
	public void AddCommentDetails(String AddComment) {
		this.AddComment.clear(); 
		this.AddComment.sendKeys(AddComment); 
	}
	
	public void clickSubmitBtn() {
		this.SubmitBtn.click(); 
		String expected= "Good";
		String actual = AddedComment.getText();
		Assert.assertEquals(actual, expected);	
		System.out.println(actual);
	}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click(); 
		}
	
	public void ViewAdminBlog(){
		
	String parentWindow= driver.getWindowHandle();
	((JavascriptExecutor) driver).executeScript("window.open('http://realty-real-estatem1.upskills.in/wp-admin/')");
	//driver.switchTo().activeElement();
	ArrayList<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
	for(String curWindow : allWindows){
	    driver.switchTo().window(curWindow);
	}
	WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user_login")));
	}
	
	public void ViewComments() {
		this.ClkComments.click(); 
		Actions action = new Actions(driver);
		action.moveToElement(mousehovercomment).build().perform();
		ClkReply.click();
		}
	
	public void ReplyComment(String replytext) {
		this.replytext.clear();
		this.replytext.sendKeys(replytext);
		this.clkreplybtn.click();
		driver.navigate().refresh();
	}

}
	
	
	

