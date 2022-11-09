package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class AdminUser {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
	private WebElement adminUserLink;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonLink;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passWordField;
	
	@FindBy(xpath="//select[@id='user_type']")
	private WebElement userType;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveButtonAdminUser;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessageOfAdminUser;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameFieldLogIn;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordFieldLogIn;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement siginLink;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertDangerMessageOfAdminUser;
	
	@FindBy(xpath="//li[@class='nav-item dropdown']")
	private WebElement adminName_LogIn;

	
	public AdminUser(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void click_AdminUserLink() {
		adminUserLink.click();
	}
    public void click_NewButtonOfAdminUser() {
    	newButtonLink.click();
    }
    public void enter_UserNameField(String userName) {
    	userNameField.sendKeys(userName);
    }
    public void enter_PassWordField(String passWord) {
    	passWordField.sendKeys(passWord);
    	
    }
    public void select_UserTypeOfAdminUser(int value) {
    	pageutility=new PageUtility(driver);
    	pageutility.select_ByIndex(value, userType);
    }
    public void click_SaveButtonOfAdminUser() {
    	saveButtonAdminUser.click();
    }
    public void enterDetailsOfAdminUser(String userName,String passWord) {
    	enter_UserNameField(userName);
    	enter_PassWordField(passWord);
    	select_UserTypeOfAdminUser(1);
    	click_SaveButtonOfAdminUser();
    }
    public String getAttribute_DangerAlertMessageOfAdminUser() {
    	generalutility=new GeneralUtility(driver);
		return generalutility.getAttributeOfElement(alertDangerMessageOfAdminUser,"class");
    }
   
    public void enter_AdminUserDataUsingList(String user,String password) {
    	List<String> list=new ArrayList<>();
    	list.add(user);
    	list.add(password);
    	
    	enter_UserNameField(list.get(0));
    	enter_PassWordField(list.get(1));
    	select_UserTypeOfAdminUser(1);
    	click_SaveButtonOfAdminUser();
    	}
    public String getAttribute_AlertMessageOfAdminUser() {
    	generalutility=new GeneralUtility(driver);
		return generalutility.getAttributeOfElement(alertMessageOfAdminUser,"class");
    }
    public void enterUserNameOfLogIn(String UserName) {
		userNameFieldLogIn.sendKeys(UserName);
	}

	public void enterPassWordOfLogIn(String PassWord) {
		passWordFieldLogIn.sendKeys(PassWord);

	}

	public void clickSignInButton() {
		siginLink.click();
	}
	public String getText_AdminNameOfLogIn() {
		generalutility=new GeneralUtility(driver);
		return generalutility.get_Text(adminName_LogIn);
	}
}
