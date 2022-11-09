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

public class ManageSlider {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-window-restore']")
	private WebElement manageSliderLink;
	
	@FindBy(xpath="//tbody//tr[1]//td[3]")
	private WebElement changeStatusLink;
	
	@FindBy(xpath="//input[@id='link']")
	private WebElement updateLinkField;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateButtonLink;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSucessMessageUpdate;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement imageUploadLink;
	
	@FindBy(xpath="//input[@id='link']")
	private WebElement linkField;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSucessMessage;
	
	public ManageSlider(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_ManageSlider() {
		manageSliderLink.click();
	}
	public void updateOfManageSlide(String data) {
		
			List<String> names = new ArrayList<String>();
			generalutility = new GeneralUtility(driver);
			pageutility = new PageUtility(driver);
			names = generalutility.get_TextOfElements("//tbody//tr//td[2]");
			int j = 0;
			for (j = 0; j < names.size(); j++) {

				if (data.equals(names.get(j))) {
					j++;
					break;
				}
			}

			WebElement updateButton = driver.findElement(By.xpath("//tbody//tr["+j+"]//td[4]//a[1]"));
			pageutility=new PageUtility(driver);
			pageutility.click_JavaScriptExecutor(updateButton);
			

	}
	public void update_LinkfieldOfManageSlide(String link) {
		updateLinkField.clear();
		updateLinkField.sendKeys(link);
	}
	public void click_UpdateButton() {
		pageutility=new PageUtility(driver);
		pageutility.click_JavaScriptExecutor(updateButtonLink);
		
	}
	public String getAttribute_SuccessAlertMessageOfUpdateData() {
		
		generalutility=new GeneralUtility(driver);
		return generalutility.getAttributeOfElement(alertSucessMessageUpdate,"class");
	}
	
	public void click_NewButtonOfManageSlide() {
		newButton.click();
	}
	public String getCssPropertyOfNewButton() {
		generalutility=new GeneralUtility(driver);
		return generalutility.getCssColorOfElement(newButton,"background-color");
		
	}
	public void enter_ImageUpload(String fileName){
		imageUploadLink.sendKeys(fileName);
		
	}
	public void enter_LinkField(String link) {
		linkField.sendKeys(link);
	}
	public void click_SaveButton() {
		saveButton.click();
	}
	public boolean alertSucessMessage_IsDisplayed() {
		generalutility=new GeneralUtility(driver);
		return generalutility.is_Displayed(alertSucessMessage);
	}
	
}
