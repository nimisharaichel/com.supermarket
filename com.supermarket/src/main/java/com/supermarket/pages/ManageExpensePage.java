package com.supermarket.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
import com.supermarket.utilities.WaitUtility;

public class ManageExpensePage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	WaitUtility waitutility;
	

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
	
	@FindBy(xpath="//tbody//tr[7]//td[9]//a[1]")
	private WebElement editSubManageExpenseData;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateButtonSubManageExpense;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessageOfUpdateOfSubManageExpense;
	
	@FindBy(xpath="//tbody//tr[9]//td[9]//a[2]")
	private WebElement deleteDataOfSubManageExpense;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertMeassageAfterDeleteSubManageExpenseData;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchLink;
	
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	private WebElement userFiledOfSearchSubManageExpense;
	
	@FindBy(xpath="//input[@id='ti']")
	private WebElement enterTitleFieldofSeachSubManageExpense;
	
	@FindBy(xpath="//select[@id='uc']")
	private WebElement categoryFieldOfSearchSubManageExpense;
	
	@FindBy(xpath="//select[@id='od']")
	private WebElement orderIdFieldLink;
	
	@FindBy(xpath="//select[@id='pi']")
	private WebElement purchaseIdSearchFieldOfSubManageExpense;
	
	@FindBy(xpath="//select[@id='ty']")
	private WebElement expenseTypesSearchOfSubManageExpense;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	private WebElement searchButtonOfSubManageExpense;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-info']")
	private WebElement reportButtonOfSerachSubManageExpense;
	
	@FindBy(xpath="//div[@class='col-sm-12']")
	private WebElement nextWindowofReport;
	
	@FindBy(xpath="//span[@id='back']")
	private WebElement backButtonOfReport;
	
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
	public String getAttribute_AlertUnsucessMessageOfExpenseCategory() {
		generalutility=new GeneralUtility(driver);
		return generalutility.getAttributeOfElement(alertMessageLinkOfExpenseCategory,"class");
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
		waitutility=new WaitUtility(driver);
		waitutility.element_ToBeClickable(10L,"//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']");
		sub_ManageExpenseField.click();
	}
public void click_NewButtonOfSubManageExpense() {
	newButtonOfSubManageExpense.click();
}
public void click_UserFieldButtonOfSubManageExpense() {
	
	//userButtonOfSubManageExpense.click();
}
public void select_UserFieldOptionOfSubManageExpse() {

	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(2, userButtonOfSubManageExpense);
	
	
}
public void select_CategoryFieldOptionOfSubManageExpense() {
	
	categoryFieldOfSubManageExpense.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByValue("415", categoryFieldOfSubManageExpense);
}
public void select_OrderIdFieldOptionOfSubManageExpense() {
	
	userFiledOfSearchSubManageExpense.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByVisibleText("18", userFiledOfSearchSubManageExpense);
}
public void select_PurchaseIdOptionOfSubManageExpense() {
	waitutility=new WaitUtility(driver);
	waitutility.element_ToBeClickable(10L,"//select[@id='pi']");
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
public void enterData_ManageExpense() {
	click_UserFieldButtonOfSubManageExpense();
	select_UserFieldOptionOfSubManageExpse();
	select_CategoryFieldOptionOfSubManageExpense();
	select_OrderIdFieldOptionOfSubManageExpense();
	select_PurchaseIdOptionOfSubManageExpense();
	select_ExpenseFiledOptionOfSubManageExpense();
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
public void click_EditOptionOfSubManageExpense() {
	editSubManageExpenseData.click();
}
public void enter_dataForUpdationInSubManageExpense() {
	click_UserFieldButtonOfSubManageExpense();
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(2, userButtonOfSubManageExpense);
	select_PurchaseIdOptionOfSubManageExpense();
}
public void click_UpdateEditButtonOfSubManageExpense() {
	waitutility=new WaitUtility(driver);
	waitutility.element_ToBeClickable(10L,"//button[text()='Update']");
	updateButtonSubManageExpense.click();
	
}
public String getText_OfUpdateAlertMessageForSubManageExpense() {
	generalutility=new GeneralUtility(driver);
	String string=generalutility.get_Text(alertMessageOfUpdateOfSubManageExpense);
	String split[] = string.split("Alert!");
	String text=split[0];
	
	System.out.println("The splitted string:"+text);
	return text;
}
public void delete_DataOfSubManageExpense() {
	deleteDataOfSubManageExpense.click();
	driver.switchTo().alert().accept();
	//driver.switchTo().alert().dismiss();
}
public boolean deleteButtonOfSubManageExpenseIsSelected() {
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Selected(deleteDataOfSubManageExpense);
}
public String getAttributeOfSuccessAlert_DeleteDataOfSubManageExpense() {
	generalutility=new GeneralUtility(driver);
	return generalutility.getAttributeOfElement(successAlertMeassageAfterDeleteSubManageExpenseData,"class");
	
}
public void click_SearchIconOfSubManageExpense() {
	searchLink.click();
}
public void search_enterValidUserDataOfSubManageExpense() {
	userFiledOfSearchSubManageExpense.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(2, userFiledOfSearchSubManageExpense);
	
}
public void enterTitleDataOfSubManageExpense(String tileName) {
	enterTitleFieldofSeachSubManageExpense.sendKeys(tileName);
}
public void search_enterValidCategoryDataOfSubManageExpense() {
	userFiledOfSearchSubManageExpense.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByVisibleText("Grocery", categoryFieldOfSearchSubManageExpense);
	pageutility.select_ByVisibleText("Debit Bank", expenseTypesSearchOfSubManageExpense);
	pageutility.select_ByVisibleText("18", orderIdFieldLink);
	pageutility.select_ByVisibleText("18", purchaseIdSearchFieldOfSubManageExpense);
	
	
}
public void click_SearchButtonOfSubManageExpense() {
	searchButtonOfSubManageExpense.click();
	
}
public boolean searchButtonOfSubManageExpenseIsSelected() {
	generalutility=new GeneralUtility(driver);
    return	generalutility.is_Selected(searchButtonOfSubManageExpense);
}
public void click_reportButtonNextWindowOfSerachSubManageExpense() {
	reportButtonOfSerachSubManageExpense.click();
	
	String parentWindow=driver.getWindowHandle();
	System.out.println("The id of current window:"+parentWindow);
	Set<String> windows=driver.getWindowHandles();
	System.out.println("Size of set:"+windows.size());
	System.out.println("The set of windows:"+windows);


for(String s:windows)
{
if(parentWindow.equals(s))
{
	System.out.println("no need to switch");
	System.out.println(s+" "+parentWindow);
}
else
{
	driver.switchTo().window(s);
}
}

}
public String getText_NewWindowReportOfSubManageExpense() {
	click_reportButtonNextWindowOfSerachSubManageExpense();
	generalutility=new GeneralUtility(driver);
    return	generalutility.get_Text(nextWindowofReport);
    
}
public void click_BackButtonOfReport() {
	backButtonOfReport.click();
}
}

