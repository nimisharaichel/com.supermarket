package com.supermarket.pages;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.PdfReader;

public class ManageExpensePage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	

	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement logoSymbol;
	
	@FindBy(xpath="(//i[@class='fas fa-angle-left right'])[1]")
	private WebElement manageExpenseLink;
	
	@FindBy(xpath="//p[text()='Expense Category']")
	private WebElement sub_ExpenseCategoryLink;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonOfExpenseCategory;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement titelLinkOfExpenseCategory;
	
	@FindBy(xpath="//button[@name='Create']")
	private WebElement SaveButtonOfExpenseCategory;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessageLinkOfExpenseCategory;
	
	@FindBy(xpath="//div[@class=alert alert-success alert-dismissible']")
	private WebElement alertMessage2LinkOfExpenseCategory;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	private WebElement sub_ManageExpenseField;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonOfSubManageExpense;
	
	@FindBy(xpath="//select[@id='user_id']")
	private WebElement userButtonOfSubManageExpense;
	
	@FindBy(xpath="//select[@id='ex_cat']")
	private WebElement categoryFieldOfSubManageExpense;
	
	@FindBy(xpath="//select[@id='order_id']")
	private  WebElement userIdFieldOfSubManageExpense;
	
	@FindBy(xpath="//select[@id='purchase_id']")
	private WebElement purchaseIdFieldOfManageExpense;
	
	@FindBy(xpath="//select[@id='ex_type']")
	private WebElement expenseTypeFieldOfManageExpense;
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement amountFieldOfManageExpense;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement remarkFieldOfSubManageExpense;
	
	@FindBy(xpath="//input[@name='userfile']")
	private WebElement chooseFileUploadButton;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButtonOfSubManageExpense;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessageLink;
	
	public ManageExpensePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isDisplayed_LogoSymbolOfManageExpense() {
		generalutility=new GeneralUtility(driver);
		return generalutility.is_Displayed(logoSymbol);
	}
	
		public void click_ManageExpensePage() {
		manageExpenseLink.click();
	}
	
	public void click_expenseCategory() {
		sub_ExpenseCategoryLink.click();
	}
	
	public void click_newButtonOfExpenseCategory() {
		newButtonOfExpenseCategory.click();
	}
	public void enter_titleOfExpensecategory(String title1) {
		titelLinkOfExpenseCategory.sendKeys(title1);
	}
	public void enter_titleOfExpenseCategoryFromPdf(String title1) {
		enter_titleOfExpensecategory(title1);
	}
	
	public void click_SaveButtonOfExpenseCategory() {
		pageutility=new PageUtility(driver);
		pageutility.click_JavaScriptExecutor(SaveButtonOfExpenseCategory);
	}
	
	public String getText_AlertUnsucessMessageOfExpenseCategory() {
		
		generalutility=new GeneralUtility(driver);
		return generalutility.get_Text(alertMessageLinkOfExpenseCategory);
		
	}
	public String getText_SucessMessageOfExpenseCategory() {
		generalutility=new GeneralUtility(driver);
		return generalutility.get_Text(alertMessage2LinkOfExpenseCategory);
	}
	public boolean getAlertMessage_IsDisplayed() {
		generalutility=new GeneralUtility(driver);
		return generalutility.is_Displayed(alertMessageLinkOfExpenseCategory);
	}
	public boolean expenseCategoryNewButton_IsEnable() {
		generalutility=new GeneralUtility(driver);
		return generalutility.is_Enabled(newButtonOfExpenseCategory);
	}
	
	public void click_SubManageExpenseField() {
		sub_ManageExpenseField.click();
	}
public void click_NewButtonOfSubManageExpense() {
	newButtonOfSubManageExpense.click();
}
public void click_UserFieldButtonOfSubManageExpense() {
	userButtonOfSubManageExpense.click();
}
public void select_UserFieldOptionOfSubManageExpse() {

	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(2, userButtonOfSubManageExpense);
	
	
}
public void select_CategoryFieldOptionOfSubManageExpense() {
	categoryFieldOfSubManageExpense.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByValue("482", categoryFieldOfSubManageExpense);
}
public void select_UserIdFieldOptionOfSubManageExpense() {
	userIdFieldOfSubManageExpense.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByVisibleText("18", userIdFieldOfSubManageExpense);
}
public void select_PurchaseIdOptionOfSubManageExpense() {
	purchaseIdFieldOfManageExpense.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(3, purchaseIdFieldOfManageExpense);
	
}
public void select_ExpenseFiledOptionOfSubManageExpense() {
	expenseTypeFieldOfManageExpense.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(3, expenseTypeFieldOfManageExpense);
}
public void send_AmountFieldOfManageExpense(String amount) {
	amountFieldOfManageExpense.sendKeys(amount);
	
}
public void send_RemarkFieldOfManageExpense(String remarks) {
	remarkFieldOfSubManageExpense.sendKeys(remarks);
}
public void enter_amountFieldOfManageExpense(String amount,String remarks) {
	send_AmountFieldOfManageExpense(amount);
	send_RemarkFieldOfManageExpense(remarks);
	
}
public void click_UserFileUploadOfSubManageExpense() {
	pageutility=new PageUtility(driver);
	pageutility.click_JavaScriptExecutor(chooseFileUploadButton);
	
}
public void UserFileUploadOfSubManageExpense(String filePath) {
	
	chooseFileUploadButton.sendKeys(filePath);
	
}
public void click_saveButtonOfSubManageExpense() {
	saveButtonOfSubManageExpense.click();
}

public boolean saveButtonOfSubManageExpense_IsSelected() {
generalutility=new GeneralUtility(driver);
return	generalutility.is_Displayed(saveButtonOfSubManageExpense);
	
}
public String getAlertText_SubManageExpense() {
		generalutility=new GeneralUtility(driver);
		return generalutility.get_Text(alertMessageLink);
}
}
