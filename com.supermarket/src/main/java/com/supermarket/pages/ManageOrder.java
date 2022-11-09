package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageOrder {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-basket']")
	private WebElement manageOrderLink;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement listOrderText;
	
	@FindBy(xpath="//a[@class='btn btn-warning btn-sm']")
	private WebElement assignDeliveryBoyButton;
	
	@FindBy(xpath="//select[@id='delivery_boy_id']")
	private WebElement selectDeliveryBoy;
	
	@FindBy(xpath="(//button[@name='Update_st'])[1]")
	private WebElement updateButton;
	
	
	
public ManageOrder(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void click_ManagerOrderLink() {
	manageOrderLink.click();
}
public String getText_ListOrder() {
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(listOrderText);
}


}