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

public class AddNewPostCategoryPOM {
	private WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public AddNewPostCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//ul[@id='responsive']//a[@class='sign-in']")
	private WebElement signIn; 
	
	@FindBy(xpath="//a[@id='category-add-toggle']")
	private WebElement AddnewCat;
			
	@FindBy(xpath="//input[@id='newcategory']")
	private WebElement text; 
	
	@FindBy(xpath="//input[@id='category-add-submit']")
	private WebElement AddBtn; 
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement Title; 
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement Content; 
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[17]/ul[1]/li[1]/label[1]")
	private WebElement chk; 
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishBtn; 
	
	public void clickSignIn() {
		this.signIn.click();
	}
		
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
	
	//Click on Add new Category
	public void AddNewCategory()
	{
		this.AddnewCat.click();
	
	}

	//Enter details in TextBox
	public void CategoryText(String text) {
				this.text.clear();
				this.text.sendKeys(text);
				}
	
	//Select Category	   
	public void SelectCategory() {
		Select ParentCategory=new Select(driver.findElement(By.name("newcategory_parent")));
		ParentCategory.selectByVisibleText("New Launches");
		}
		    
	public void AddNewCategoryBtn() {
		this.AddBtn.click(); 
		driver.navigate().refresh();
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
		}
	
	public void VerifyPost()  {
		String expected= "View post";
		String actual = driver.findElement(By.xpath("//a[contains(text(),'View post')]")).getText();
		Assert.assertEquals(actual, expected);	
		}
	
}
	
	
	

