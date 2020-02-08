package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DoneQuisPOM {
	public WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public DoneQuisPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//ul[@id='responsive']//li[@id='menu-item-571']//a[contains(text(),'Villas')]")
	public WebElement villaTab; 
	
	@FindBy(xpath="//span[contains(text(),'Donec quis')]")
	public WebElement dneQuis; 

	@FindBy(xpath="//input[@name='your-name']")
	public WebElement name; 
	
	@FindBy(xpath="//input[@name='your-email']")
	public WebElement email; 
	
	@FindBy(xpath="//input[@name='your-subject']")
	public WebElement subject;
	
	@FindBy(xpath="//textarea[@name='your-message']")
	public WebElement message;
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-submit']")
	public WebElement submitbtn;
	

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

	public void clickSignIn() {
		this.signIn.click();
	}
	
	public void Sendname(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
		
	public void Sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void Sendsubject(String subject) {
		this.subject.clear();
		this.subject.sendKeys(subject);
	}
	
	public void Sendmessage(String message) {
		this.message.clear();
		this.message.sendKeys(message);
	}
		
	public void SubmitBtn() {
		this.submitbtn.click(); 
		}
	
	public void verifyText() {
	String actual= driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
	String expected="There was an error trying to send your message. Please try again later.";
	Assert.assertEquals(actual, expected);
	System.out.println("The text displays as expected");
	
	}
}


