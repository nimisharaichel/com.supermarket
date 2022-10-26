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

public class ManageUser {
WebDriver driver;
GeneralUtility generalutility;
PageUtility pageutility;

@FindBy(xpath="//i[@class='nav-icon fas fa-user']")
private WebElement manageuserLink;

@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
private WebElement searchFieldLink;

@FindBy(xpath="//input[@id='un']")
private WebElement searchByName;

@FindBy(xpath="//input[@id='ut']")
private WebElement searchByEmail;

@FindBy(xpath="//input[@id='ph']")
private WebElement searchByPhoneNo;

@FindBy(xpath="//select[@id='st']")
private WebElement searchByStatus;

@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
private WebElement searchButton;

public ManageUser(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void click_ManageUser() {
	manageuserLink.click();
}
public void deactivate_User(String users) {
	
	List<String> names=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	pageutility=new PageUtility(driver);
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	//System.out.println(names);
	int i=0;
	for(i=0;i<names.size();i++) {
		if(users.equals(names.get(i))) {
			i++;
			break;
		}
		
	
}
	WebElement deactivateButton=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[5]//a"));
	deactivateButton.click();
	
}
public void deleteData_User(String users) {
	
	List<String> names=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	pageutility=new PageUtility(driver);
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	
	int j=0;
	for(j=0;j<names.size();j++) {
		if(users.equals(names.get(j))) {
			j++;
			break;
		}
		
	
}
	
	WebElement deleteData=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[6]//a[2]"));
	deleteData.click();
	driver.switchTo().alert().accept();
}
public void click_SearchFieldInManageUser() {
	searchFieldLink.click();
}
public void searchDataByName_ManageUser(String name) {
	searchByName.sendKeys(name);
}
public void searchDataByEmail_ManageUser(String email) {
	searchByEmail.sendKeys(email);
	
}
public void searchByPhoneNo_ManageUser(String phoneNo) {
	
	searchByPhoneNo.sendKeys(phoneNo);
}
public void searchBystatus_ManageUser() {
	searchByStatus.click();
	pageutility=new PageUtility(driver);
	//pageutility.select_ByValue("active", searchByStatus);
	pageutility.select_ByIndex(2, searchByStatus);
}
public void click_searchButtonOfManageUser() {
	searchButton.click();
}

}
