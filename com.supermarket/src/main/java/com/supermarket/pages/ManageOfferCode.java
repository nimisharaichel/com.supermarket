package com.supermarket.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageOfferCode {
WebDriver driver;
PageUtility pageutility;
GeneralUtility generalutility;

@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']//p[text()='Manage Offer Code']")
private WebElement manageOfferCodeLink;

@FindBy(xpath="//tbody//tr[3]//td[6]//a[2]")
private WebElement deleteButton;

@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
private WebElement searchButton;

@FindBy(xpath="//input[@name='un']")
private WebElement offerCodeField;

@FindBy(xpath="//button[@name='Search']")
private WebElement searchButtonLink;

@FindBy(xpath="//tbody//tr[1]//td[1]")
private WebElement searchOfferCodeResult;

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton;

@FindBy(xpath="//input[@name='offer_code']")
private WebElement offerCodeNew;

@FindBy(xpath="//input[@id='offer_per']")
private WebElement percentegeField;

@FindBy(xpath="//input[@id='offer_price']")
private WebElement amountField;

@FindBy(xpath="//div[@class='note-editable card-block']")
private WebElement descriptionField;

@FindBy(xpath="//input[@id='main_img']")
private WebElement uploadImage;

@FindBy(xpath="//button[text()='Save']")
private WebElement saveButton;

@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
private WebElement dangerAlertMessage;

public ManageOfferCode(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_ManageOfferCode() {
	manageOfferCodeLink.click();
}
public void click_ChangeStatusButtonOfManageOfferCode(String data) {
	List<String> offerCode=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	pageutility=new PageUtility(driver);
	offerCode=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	int j=0;
	for(j=0;j<offerCode.size();j++) {
		
		if(data.equals(offerCode.get(j))) {
			j++;
			break;
		}
	}
	
	WebElement changeStatusButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[5]"));
	changeStatusButton.click();
	//driver.switchTo().alert().dismiss();
}
public void click_SearchButtonOfManageOfferCode() {
	searchButton.click();
}

public void enter_OfferCodeField(String data) {
	offerCodeField.sendKeys(data);
}
public void click_SearchButtonLink() {
	searchButtonLink.click();
}
public String getText_SearchOfferCodeResult() {
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(searchOfferCodeResult);
	
}
public void click_NewButton() {
	newButton.click();
}
public String enter_OfferCodeData(String offerCode) {
	 offerCodeNew.sendKeys(offerCode);
	return offerCode;
	
}
public String enter_PercentageField(String percentage) {
	percentegeField.sendKeys(percentage);
	return percentage;
}
public String enter_AmountField(String amount) {
	amountField.sendKeys(amount);
	return amount;
}
public String enter_DescriptionField(String description) {
	descriptionField.sendKeys(description);
	return description;
}
public void enter_ManageOfferCodeData() {
	List<String> list=new ArrayList<>();
	list.add("457");
	list.add("48%");
	list.add("4850");
	list.add("Amount is paid");
	enter_OfferCodeData(list.get(0));
	enter_PercentageField(list.get(1));
	enter_AmountField(list.get(2));
	enter_DescriptionField(list.get(3));

	}
public void upload_ImageForManageOfferCode(String fileName) {
	
	uploadImage.sendKeys(fileName);
	
}
public void click_SaveButton() {
	pageutility=new PageUtility(driver);
	pageutility.click_JavaScriptExecutor(saveButton);
	
}
public String getAttribute_DangerAlertMessageOfManagerOfferCode() {
	generalutility=new GeneralUtility(driver);
	return generalutility.getAttributeOfElement(dangerAlertMessage,"class");
}
}

