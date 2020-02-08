package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
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

public class AddPropertytoTrashPOM {
	private WebDriver driver; 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public AddPropertytoTrashPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement AddnewProp; 
		
	@FindBy(xpath="//input[@id='title']")
	private WebElement Title; 
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement Text; 
	
	@FindBy(xpath="//label[contains(text(),'Shantiniketan')]")
	private WebElement chk; 
	
	@FindBy(xpath="//li[@id='region-58']//label[@class='selectit'][contains(text(),'East Bangalore')]")
	private WebElement chkregion; 

	
	@FindBy(linkText="Move to Trash")
	private WebElement Trashlink; 
	
	@FindBy(xpath="//*[@id=\"wpbody-content\"]/div[3]/ul/li[5]/a")
	private WebElement Trash; 

	
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
	       if (element.getText().equals("Add New")){
	    	   element.click();
	    	   return;
	       }
	    }throw new NoSuchElementException("Can't find option in dropdown");
	
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
	
	public void SelectRegion() {
		
		if (!chkregion.isSelected()){
		   chkregion.click();
			}
		}
	

	public void MoveToTrash() throws InterruptedException  {
		this.Trashlink.click();
		Thread.sleep(4000);
		}
	
	public void HandleAlert() throws InterruptedException  {
		
		Alert alert=driver.switchTo().alert();
		String alertmessage= alert.getText();
		System.out.println(alertmessage);
		Thread.sleep(2000);
		alert.accept();
		String expected="1 post moved to the Trash. Undo";
		String actual= driver.findElement(By.xpath("//*[@id=\"message\"]/p")).getText();	
		Assert.assertEquals(actual, expected);
		this.Trash.click();
			
		}
	
}


	
	
	

