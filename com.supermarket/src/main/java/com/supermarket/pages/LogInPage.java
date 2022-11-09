package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.WaitUtility;

public class LogInPage {
	public WebDriver driver;
	Excel excel;
	GeneralUtility generalutility;
	
	
	@CacheLookup
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@CacheLookup
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordField;
	@CacheLookup
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement siginLink;

	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement profileImage;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alertMessage;

	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private WebElement adminButton;

	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logOutButton;

	@FindBy(xpath = "//p[@class='login-box-msg']")
	private WebElement TextMessage;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
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

	public void logIn(String userName, String passWord) {
		enterUserName(userName);
		enterPassWord(passWord);
		clickSignInButton();
	}

	public void logIn() {
		String UserName;
		String PassWord;
		excel = new Excel();
		excel.setExcelFile("LogIn", "ValidLogInCredentials");
		UserName = excel.getCellData(1, 0);
		PassWord = excel.getCellData(1, 1);
		logIn(UserName, PassWord);
	}

	public boolean is_ProfileImageDisplayed() {
		generalutility = new GeneralUtility(driver);
		return generalutility.is_Displayed(profileImage);
	}

	public String get_AlertMessageNotification() {
		generalutility = new GeneralUtility(driver);
		return generalutility.get_Text(alertMessage);
	}

	public void click_AdminButton() {
		adminButton.click();
	}

	public void click_LogOutButton() {
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.element_ToBeClickable(10L, "//i[@class='ace-icon fa fa-power-off']");
		logOutButton.click();
	}

	public String getText_LogOutButton() {
		generalutility = new GeneralUtility(driver);
		return generalutility.get_Text(TextMessage);
	}
}
