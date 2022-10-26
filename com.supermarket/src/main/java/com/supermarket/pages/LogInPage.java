package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;

public class LogInPage {
	public WebDriver driver;
	Excel excel;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;
	

	@FindBy(xpath="//input[@name='password']")
	private WebElement passWordField;

	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement siginLink;
	
	@FindBy(xpath="//img[@class='img-circle']")
	private WebElement profileImage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;

	
	public LogInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	public void enterUserName(String UserName) {
		userNameField.sendKeys(UserName);
	}
	
	public void enterPassWord(String PassWord) {
		passWordField.sendKeys(PassWord);
		
	}
	
	public void clickSignInButton() {
		siginLink.click();
	}
	
	public void logIn(String userName,String passWord) {
		enterUserName(userName);
		enterPassWord(passWord);
		clickSignInButton();
		
		
	}
	
	public void logIn() {
		String UserName;
		String PassWord;
		excel=new Excel();
		excel.setExcelFile("LogIn","ValidLogInCredentials");
		UserName=excel.getCellData(1, 0);
		PassWord=excel.getCellData(1, 1);
		logIn(UserName,PassWord);
	}
	
	public boolean is_ProfileImageDisplayed() {
		generalutility=new GeneralUtility(driver);
		return generalutility.is_Displayed(profileImage);
	}
	
	
	public String get_AlertMessageNotification() {
		
	
		generalutility=new GeneralUtility(driver);
		return generalutility.get_Text(alertMessage);
	}
	
}
