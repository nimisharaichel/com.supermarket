package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageLocation {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-map-marker']")
	private WebElement manageLocationLink;
	
	@FindBy(xpath="//tbody//tr[11]//td[5]")
	private WebElement changeStatus;

	@FindBy(xpath="//tbody//tr[1]//td[6]//a[2]")
	private WebElement deleteButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonLink;
	
	@FindBy(xpath="//select[@id='country_id']")
	private WebElement countryOption;
	
	@FindBy(xpath="//select[@id='st_id']")
	private WebElement stateOption;
	
	@FindBy(xpath="//input[@id='location']")
	private WebElement locationOption;
	
	@FindBy(xpath="//input[@id='delivery']")
	private WebElement deliveryCharge;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement  saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSucessMessage;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertmessageSucess;
	

	
	public ManageLocation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void click_ManageLocationLink() {
		manageLocationLink.click();
	}
	public void click_ChangeStatusOption(String location) {
		List<String> listLocation=new ArrayList<String>();
		generalutility=new GeneralUtility(driver);
		listLocation=generalutility.get_TextOfElements("//tbody//tr[1]//td[6]//a[2]");
		int i=0;
		for(i=0;i<listLocation.size();i++) {
			
			if(location.equals(listLocation.get(i))) {
				i++;
				break;
			}
		}
		WebElement changeStatus=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[6]//a[2]"));
		changeStatus.click();
		driver.switchTo().alert().accept();
		
		
	}
	public String getAttribute_ManageLocation() {
		generalutility=new GeneralUtility(driver);
		return generalutility.getAttributeOfElement(alertSucessMessage,"class");
	}
	public boolean deleteButton_IsSelected() {
		generalutility=new GeneralUtility(driver);
		return generalutility.is_Selected(deleteButton);
	}
	public void click_newButtonLinkOfManageLocation() {
		newButtonLink.click();
	}
	public void select_CountryOptionOfManageLocation(int value) {
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(value, countryOption);
		
	}
	public void select_StateOfManageLocation(String value) {
		pageutility=new PageUtility(driver);
		pageutility.select_ByValue(value, stateOption);
	}
	public void enter_DetailsOfManageLocation() {
		click_newButtonLinkOfManageLocation();
		select_CountryOptionOfManageLocation(1);
		select_StateOfManageLocation("3805");
	}
	public void enter_LocationOptionOfMangeLocation(String data) {
		locationOption.sendKeys(data);
		
	}
	public void enter_DeliveryChargeOfManageLocation(String data) {
		deliveryCharge.sendKeys(data);
	}
	public void click_SaveButton() {
		saveButton.click();
	}
	public String getText_ManageLocation() {
		generalutility=new GeneralUtility(driver);
		return generalutility.get_Text(alertSucessMessage);
	}
	public String getAttribute_ManageLocationSucessAlertMessage() {
		generalutility=new GeneralUtility(driver);
		return generalutility.getAttributeOfElement(alertSucessMessage,"class");
	}
	public String getCssValue_ManageLocationAlertMessage() {
		generalutility=new GeneralUtility(driver);
		return generalutility.getAttributeOfElement(alertmessageSucess,"background-color");
	}
	public void enter_LocationOfManageLocationHashMap(String location) {
		locationOption.sendKeys(location);
		
	}
	public void enter_DeliveryChargeOfManageLocationHashMap(String charge) {
		deliveryCharge.sendKeys(charge);
	}
}
