package com.supermarket.tests;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.utilities.PdfReader;

public class ManageExpenseTest extends Base {
	LogInPage loginpage;
	ManageExpensePage manageexpensepage;
	PdfReader pdfreader;
	
	@Test
	public void verify_ManageExpenseLogoAndButton() {
		
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageexpensepage=new ManageExpensePage(driver);
		Assert.assertTrue(manageexpensepage.isDisplayed_LogoSymbolOfManageExpense());
		
		manageexpensepage.click_ManageExpensePage();
		manageexpensepage.click_expenseCategory();
		manageexpensepage.click_newButtonOfExpenseCategory();
		Assert.assertTrue(manageexpensepage.expenseCategoryNewButton_IsEnable());
		
	}
	
	
	@Test
	public void create_ExpenseCategoryDataFromPdf() {
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_ManageExpensePage();
		manageexpensepage.click_expenseCategory();
		manageexpensepage.click_newButtonOfExpenseCategory();
		 
		String title1;
		String title2;
		String title3;
		HashMap<String, String> map=new HashMap<String,String>();
		pdfreader=new PdfReader();
	    map= pdfreader.readPdf_Data("ExpenseCategory");
		title1= map.get("Title 1");
		title2=map.get("Title 2");
		title3=map.get("Title 3");
		
		manageexpensepage.enter_titleOfExpenseCategoryFromPdf(title1);
		manageexpensepage.enter_titleOfExpenseCategoryFromPdf(title2);
		manageexpensepage.enter_titleOfExpenseCategoryFromPdf(title3);
		manageexpensepage.click_SaveButtonOfExpenseCategory();
		System.out.println("The alert message:"+ manageexpensepage .getText_AlertUnsucessMessageOfExpenseCategory());
		//System.out.println(manageexpensepage.getText_SucessMessageOfExpenseCategory());
		Assert.assertTrue(manageexpensepage.getAlertMessage_IsDisplayed());
		
	}
	@Test
	public void verify_SubManageExpenseFunctionalities() {
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_ManageExpensePage();
		manageexpensepage.click_SubManageExpenseField();
		manageexpensepage.click_NewButtonOfSubManageExpense();
		manageexpensepage.click_UserFieldButtonOfSubManageExpense();
		manageexpensepage.select_UserFieldOptionOfSubManageExpse();
		manageexpensepage.select_CategoryFieldOptionOfSubManageExpense();
		manageexpensepage.select_UserIdFieldOptionOfSubManageExpense();
		manageexpensepage.select_CategoryFieldOptionOfSubManageExpense();
		manageexpensepage.select_UserIdFieldOptionOfSubManageExpense();
		manageexpensepage.select_PurchaseIdOptionOfSubManageExpense();
		manageexpensepage.select_ExpenseFiledOptionOfSubManageExpense();
		manageexpensepage.enter_amountFieldOfManageExpense("6000","Total amount is paid");
		manageexpensepage.click_UserFileUploadOfSubManageExpense();
		manageexpensepage.UserFileUploadOfSubManageExpense(Constants.USERFILE_UPLOADOFSUBMANAGEEXPENSE);
		manageexpensepage.click_saveButtonOfSubManageExpense();
		Assert.assertTrue(manageexpensepage.saveButtonOfSubManageExpense_IsSelected());
		System.out.println(manageexpensepage.getAlertText_SubManageExpense());
	
	}
}
