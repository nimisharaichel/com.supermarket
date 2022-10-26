package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;

public class PushNotificationPage {
WebDriver driver;
GeneralUtility generalutility;

@FindBy(xpath="//p[text()='Push Notifications']")
private WebElement pushNotificationLink;

@FindBy(xpath="//input[@id='title']")
private WebElement titleField;

@FindBy(xpath="//input[@id='description']")
private WebElement descriptionField;

@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
private WebElement sendButtonLink;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement alertSuccessText;

public PushNotificationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_PushNotificationButton() {
	pushNotificationLink.click();
}

public void enter_TitleField(String title) {
	titleField.sendKeys(title);
}
public void enter_DescriptionField(String description) {
	
	descriptionField.sendKeys(description);
}



public String getTextSuccessAlert_PushNotification(String title,String description) {
	enter_TitleField(title);
	enter_DescriptionField(description);
	sendButtonLink.click();
	return getTextAlert_PushNotification();
}

public String getTextAlert_PushNotification() {
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(alertSuccessText);
	
}




}
