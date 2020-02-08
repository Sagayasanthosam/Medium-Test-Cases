package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MortgageCalcPOM {
	public WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public MortgageCalcPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//input[@id='amount']")
	public WebElement amount; 

	@FindBy(xpath="//input[@id='downpayment']")
	public WebElement downpayment; 
	
	@FindBy(xpath="//input[@id='years']")
	public WebElement years; 
	
	@FindBy(xpath="//input[@id='interest']")
	public WebElement interest; 
	
	@FindBy(xpath="//button[@class='button calc-button']")
	public WebElement CalcBtn; 
	
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
	
	public void sendAmount(String amount) {
		this.amount.clear();
		this.amount.sendKeys(amount);
	}
	
	public void sendDownPayment(String downpayment) {
		this.downpayment.clear();
		this.downpayment.sendKeys(downpayment);
	}
	
	public void sendLoanYears(String years) {
		this.years.clear();
		this.years.sendKeys(years);	
	}
		
	public void sendInterestRate(String interest) {
		this.interest.clear();
		this.interest.sendKeys(interest);	
	}
		
	public void clickCalculateBtn() {
		this.CalcBtn.click(); 
		
	}
	
	public void verifyText() {
	String actual= driver.findElement(By.xpath("//*[contains(text(), 'Rs.')]")).getText();
	//String actual= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[4]/form[1]/div[5]/div[1]")).getText();
	//String actual= driver.findElement(By.xpath("//*[contains(text(), 'Monthly Payment:')] || //strong[@class='calc-output']")).getText();
	//String actual= driver.findElement(By.xpath("//strong[@class='calc-output']")).getText();
	String expected="Rs."; 
	//Assert.assertEquals(actual, expected);
	Assert.assertTrue(actual.contains(expected));
	System.out.println("The text displays as expected");
	}
	
}


