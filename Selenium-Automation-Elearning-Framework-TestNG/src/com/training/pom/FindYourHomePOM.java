package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindYourHomePOM {
	public WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public FindYourHomePOM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[contains(text(),'New Launch')]")
	public WebElement newlaunchtab; 
	
	@FindBy(xpath="//input[@id='keyword_search']")
	public WebElement address; 
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	public WebElement searchbtn; 
	
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
		
	public void sendAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	public void selectPropertyType()
	{
			// Clicking on Dropdown
			driver.findElement(By.xpath("//div[@id='_property_type_chosen']//a[@class='chosen-single chosen-default']")).click();
		
			// Get the all WebElements inside the dropdown in List  
			List<WebElement> dropdown_list =  driver.findElements(By.xpath("//div[@id='_property_type_chosen']//ul[@class='chosen-results']"));

			// Condition to get the WebElement for list and Click over "Apartments" option
			for(int i=0; i<dropdown_list.size(); i++)
			{
				// Printing All the options from the dropdown
				System.out.println("The elements in property Type dropdown list are");
				System.out.println(dropdown_list.get(i).getText());
				
				driver.findElement((By.xpath("//li[contains(text(),'Apartments')]"))).click();
				
			}
	}

	public void clickSearch() {
		this.searchbtn.click();
	}
		
}



