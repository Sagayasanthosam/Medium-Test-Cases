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

public class AddNewPropertyAllDetailsPOM {
	private WebDriver driver; 
	
	public AddNewPropertyAllDetailsPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"_price\"]")
	private WebElement Price;

	@FindBy(xpath="//*[@id=\"_price_per\"]")
	private WebElement Pricepersqft;
	
	@FindBy(linkText="Main Details")
	private WebElement Maindetails;
	
	@FindBy(xpath="//*[@id=\"_status\"]")
	private WebElement Status;
	
	@FindBy(xpath="//input[@id='_location']")
	private WebElement Location;
	
	@FindBy(xpath="//input[@id='_possession']")
	private WebElement Possesion;
	
	@FindBy(linkText="Location")
	private WebElement LocationTab;
	
	@FindBy(xpath="//input[@id='_friendly_address']")
	private WebElement address;
	
	@FindBy(xpath="//*[@id=\"_address\"]")
	private WebElement MapAddress;
	
	@FindBy(xpath="//*[@id=\"_geolocation_lat\"]")
	private WebElement Latitude;
	
	@FindBy(xpath="//*[@id=\"_geolocation_long\"]")
	private WebElement Longitude;
	
	@FindBy(linkText="Details")
	private WebElement DetailsTab;
	
	@FindBy(xpath="//*[@id=\"_storage_room\"]")
	private WebElement Storageroom;
	
	@FindBy(xpath="//*[@id=\"acf-group_5aa6786492979\"]/div/div/div[2]/div/div[2]/ul/li[3]/ul/li[3]/label/span")
	private WebElement Clk;
	
	@FindBy(xpath="//label[contains(text(),'Shantiniketan')]")
	private WebElement chk; 
	
	@FindBy(xpath="//li[@id='region-58']//label[@class='selectit'][contains(text(),'East Bangalore')]")
	private WebElement chkregion; 
	
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
	
	public void EnterPrice(String Price) {
		this.Price.clear();
		this.Price.sendKeys(Price);
		}
	
	public void EnterPricePerSqFt(String Pricepersqft) {
		this.Pricepersqft.clear();
		this.Pricepersqft.sendKeys(Pricepersqft);
		}
	
	public void ClickMainDetails() {
		this.Maindetails.click(); 
		}
	
	public void EnterStatus(String Status) {
		this.Status.clear();
		this.Status.sendKeys(Status);
		}
	
	public void EnterLocation(String Location) {
		this.Location.clear();
		this.Location.sendKeys(Location);
		}
	
	public void EnterPossesion(String Possesion) {
		this.Possesion.clear();
		this.Possesion.sendKeys(Possesion);
		}
	
	public void ClickLocationTab() {
		this.LocationTab.click(); 
		}
	
	public void EnterAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
		}
	public void EnterMapAddress(String MapAddress) {
		this.MapAddress.clear();
		this.MapAddress.sendKeys(MapAddress);
		}
	
	public void EnterLatitude(String Latitude) {
		this.Latitude.clear();
		this.Latitude.sendKeys(Latitude);
		}
	
	public void EnterLongitude(String Longitude) {
		this.Longitude.clear();
		this.Longitude.sendKeys(Longitude);
		}
	
	public void ClickDetailsTab() {
		this.DetailsTab.click(); 
		}
	
	public void EnterStorageRoom(String Storageroom) {
		this.Storageroom.clear();
		this.Storageroom.sendKeys(Storageroom);
		}
	
	public void SelectKeywordTags() {
		
		if (!Clk.isSelected()){
		   Clk.click();
			}
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
	
	public void ClickPublish() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
		this.publishBtn.click();
		}
	
	public void VerifyPost()  {
		String expected= "View post";
		String actual = driver.findElement(By.xpath("//a[contains(text(),'View post')]")).getText();
		Assert.assertEquals(actual, expected);	
		System.out.println(actual);
		}
	
}


	
	
	

