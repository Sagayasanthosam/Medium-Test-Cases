package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public LoginPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//ul[@class='my-account-nav']//a[contains(text(),'Log Out')]")
	private WebElement logoutBtn; 

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
	
	public void ManageAccount() {
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='my-account-nav-container']"));
        for (WebElement element: allElements) {
            System.out.println("The userlink elements are \n"+  element.getText());
        }
	}
	public void clickLogoutBtn() {
		this.logoutBtn.click(); 
		}
}
