package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageDeliveryBoy {
	WebDriver driver;
	
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']//p[text()='Manage Delivery Boy']")
	private WebElement clickManageDeliveryBoyButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickNewButton;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement enterName;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement enterEmailId;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement enterMobileNo;
	
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement enterAddress;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement enterUserName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement enterPassWord;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickSaveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButtonSelect;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement dangerAlertMessage;
	
	@FindBy(xpath="alert alert-success alert-dismissible")
	private WebElement alertMeassageDelete;
	
	
public ManageDeliveryBoy(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void scrollDownthePage() {
	pageutility=new PageUtility(driver);
	pageutility.scroll_Down(0,6000);
	
}
public void click_ManageDeliveryBoyButton() {
	clickManageDeliveryBoyButton.click();
}
public void click_NewButton() {
	clickNewButton.click();
}

public void enter_NameOfDeliveryBoy(String name) {
	enterName.sendKeys(name);
}
public void enter_EmailIdDeliveryBoy(String emailId) {
	enterEmailId.sendKeys(emailId);
}
public void enter_MobileNoDeliveryBoy(String mobileNo) {
	enterMobileNo.sendKeys(mobileNo);
	
}
public void enter_AddressOfDeliveryBoy(String address) {
	
	enterAddress.sendKeys(address);
}
public void enter_UserNameOfDeliveryBoy(String username) {
	
	enterUserName.sendKeys(username);
}
public void enter_PassWordOfDeliveryBoy(String password) {
	enterPassWord.sendKeys(password);
}

public void create_DeliveryBoyDetails(String name,String emailid,String mobileno,String address,String username,String password) {
	
	
	enter_NameOfDeliveryBoy(name);
	enter_EmailIdDeliveryBoy(emailid);
	enter_MobileNoDeliveryBoy(mobileno);
	enter_AddressOfDeliveryBoy(address);
	enter_UserNameOfDeliveryBoy(username);
	enter_PassWordOfDeliveryBoy(password);
	
	
}

public void click_SaveButton() {
	pageutility=new PageUtility(driver);
	pageutility.scrollAndClick(clickSaveButton);
	//pageutility.click_JavaScriptExecutor(clickSaveButton);
	
}
public String get_TextAlertMessageOfDeliveryBoy() {
	generalutility=new GeneralUtility(driver);
	String text= generalutility.get_Text(alertMessage);
	System.out.println("The text alert message:"+text);
	return text;
}
public boolean is_SaveButtonSelected() {
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Enabled(saveButtonSelect);
}
public boolean textAlertMessage_IsDisplayed() {
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(alertMessage);
}
public String getDangerAlertMsgOfDeliveryBoy() {
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(dangerAlertMessage);
}
public void deleteDeliveryBoyData(String data) {
	List<String> names=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	pageutility=new PageUtility(driver);
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	int j=0;
	for(j=0;j<names.size();j++) {
		
		if(data.equals(names.get(j))) {
			j++;
			break;
		}
	}
	
	WebElement deleteData=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[8]//a[2]"));
	deleteData.click();
	driver.switchTo().alert().accept();
	gettextOfDeleteAlertMessageOfManageDeliveryBoy();
	
	
	
}
public String gettextOfDeleteAlertMessageOfManageDeliveryBoy() {
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(alertMeassageDelete);
}


}
