package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VerifyPostAddedPOM {
	private WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public VerifyPostAddedPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement Title; 
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement Content; 
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[17]/ul[1]/li[1]/label[1]")
	private WebElement chk; 
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishBtn; 
	
	@FindBy(xpath="//div[@id='published-posts']//li[1]//a[1]")
	private WebElement clkpostaddedbtn; 
	
	@FindBy(xpath="//h1[contains(@class,'wp-heading-inline')]")
	private WebElement verifypage; 
		
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
	
	public void NewPosts() {
		Actions actions=new Actions(driver);
		WebElement posts= driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(posts).perform();
		driver.findElement(By.xpath("//li[@id='menu-posts']")).click();//Click on Posts
		}

	public void AddNew() //Add new posts
	{
		List<WebElement> allElements = driver.findElements(By.xpath("//ul[@class='wp-submenu wp-submenu-wrap']//a"));
	    for (WebElement element: allElements) {
	       if (element.getText().equals("Add New")){
	    	   element.click();
	    	   return;
	       }
	    }throw new NoSuchElementException("Can't find option in dropdown");
	
			}
	
	public void EnterTitle(String Title) {
		this.Title.clear(); 
		this.Title.sendKeys(Title);
		}
	
	public void EnterContent(String Content) {
		this.Content.clear(); 
		this.Content.sendKeys(Content);
		}
	
	public void SelectCateg() {
		
		if (!chk.isSelected()){
		   chk.click();
			}
		}
	
	public void ClickPublish() throws InterruptedException {
		Thread.sleep(3000);
		this.publishBtn.click();
		driver.navigate().refresh();
		}
	
	public void VerifyPost()  {
		String expected= "View post";
		String actual = driver.findElement(By.xpath("//a[contains(text(),'View post')]")).getText();
		Assert.assertEquals(actual, expected);	
		}
	
	public void viewDashboard()  {
		Actions actions=new Actions(driver);
		WebElement dashboard= driver.findElement(By.xpath("//div[contains(text(),'Dashboard')]"));
		actions.moveToElement(dashboard).click().perform();
		}
		
	public void ClickPost()  {
		
		this.clkpostaddedbtn.click();
		}
	
	public void VerifyPostPage()  {
		String expected= "Edit Post";
		String actual = verifypage.getText();
		Assert.assertEquals(actual, expected);	
		}
}

	
	
	

