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

public class CreatePropertyFeaturePOM {
	private WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public CreatePropertyFeaturePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
		
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement Clkproperty; 
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement Name; 
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement Slug; 
	
	@FindBy(xpath="//textarea[@id='tag-description']")
	private WebElement description; 
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement submitBtn; 
	
	@FindBy(xpath="//input[@id='tag-search-input']")
	private WebElement Featname; 
	
	@FindBy(xpath="//input[@id='search-submit']")
	private WebElement SrchSbtBtn; 
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement AddnewProp; 
		
	@FindBy(xpath="//input[@id='title']")
	private WebElement Title; 
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement Text; 
	
	@FindBy(xpath="//label[contains(text(),'Shantiniketan')]")
	private WebElement chk; 
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishBtn; 
	
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
	
	public void ClickProperty() {
		Actions actions=new Actions(driver);
		WebElement property= Clkproperty;
		actions.moveToElement(property).click().perform();
		}

	public void ViewPropertyList() {
		
		List<WebElement> allElements = driver.findElements(By.xpath("//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//a"));
		for (WebElement element: allElements) {
	       if (element.getText().equals("Features")){
	    	   element.click();
	    	   return;
	       }
	    }throw new NoSuchElementException("Can't find option in dropdown");
	
		}
	
	public void EnterName(String Name) {
		this.Name.clear();
		this.Name.sendKeys(Name);
		}
	
	public void EnterSlug(String Slug) {
		this.Slug.clear();
		this.Slug.sendKeys(Slug);
		}

	public void SelectParentFeature() {
		Select ParentFeature=new Select(driver.findElement(By.id("parent")));
		ParentFeature.selectByVisibleText("New Launches");
	}
	
	public void EnterDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click(); 
		}
	
	public void SearchFeature(String Featname) {
		this.Featname.clear();
		this.Featname.sendKeys(Featname);
		this.SrchSbtBtn.click();
	}
	
	public void AddNewProperty() {
		this.AddnewProp.click(); 
		}
	
	public void EnterTitle(String Title) {
		this.Title.clear();
		this.Title.sendKeys(Title);
		}
	
	public void EnterText(String Text) {
		this.Text.clear();
		this.Text.sendKeys(Text);
		}
	
	public void SelectFeat() {
		
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


	
	
	

