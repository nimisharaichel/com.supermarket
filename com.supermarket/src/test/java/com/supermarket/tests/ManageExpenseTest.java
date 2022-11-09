package com.supermarket.tests;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	public void verify_ManageExpenseLogoSymbol() {
		
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageexpensepage=new ManageExpensePage(driver);
		Assert.assertTrue(manageexpensepage.isDisplayed_LogoSymbolOfManageExpense());
	}
	
	
	@Test
	public void create_ExpenseCategoryDataFromPdf() {
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_ManageExpensePage();
		manageexpensepage.click_expenseCategory();
		manageexpensepage.click_newButtonOfExpenseCategory();
	    HashMap<String, String> map=new HashMap<String,String>();
		pdfreader=new PdfReader();
	    map= pdfreader.readPdf_Data("ExpenseCategory");
		String manageExpenseTitle1= map.get("Title 1");
		manageexpensepage.enter_titleOfExpenseCategoryFromPdf(manageExpenseTitle1);
		manageexpensepage.click_SaveButtonOfExpenseCategory();
		String expectedResult=Constants.DANGERALERT_EXPENSECATEGORY;
	    String actualResult=  manageexpensepage .getAttribute_AlertUnsucessMessageOfExpenseCategory();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@Test
	public void verify_UpdateFunctionalityOfSubManageExpense() {
		loginpage=new LogInPage(driver);
		SoftAssert softassert=new SoftAssert();
		loginpage.logIn();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_ManageExpensePage();
		manageexpensepage.click_SubManageExpenseField();
		manageexpensepage.click_EditOptionOfSubManageExpense();
		manageexpensepage.enter_dataForUpdationInSubManageExpense();
		manageexpensepage.click_UpdateEditButtonOfSubManageExpense();
		String expectedResult=Constants.EXPECTEDRESULT_UPADTEDDATAOFSUBMANAGEEXPENSE;
		String actualResult=manageexpensepage.getText_OfUpdateAlertMessageForSubManageExpense();
	    softassert.assertEquals(actualResult, expectedResult);
	}
	@Test
	public void verify_DeleteFunctionalityOfSubManageExpense() {
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_ManageExpensePage();
		manageexpensepage.click_SubManageExpenseField();
		manageexpensepage.delete_DataOfSubManageExpense();
		String expectedResult=Constants.SUCESSALERT_EXPENSECATEGORY;
		String actualResult=manageexpensepage.getAttributeOfSuccessAlert_DeleteDataOfSubManageExpense();
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}
	@Test
	public void verify_SearchDataOfSubManageExpense() {
		loginpage=new LogInPage(driver);
		loginpage.logIn();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_ManageExpensePage();
		manageexpensepage.click_SubManageExpenseField();
		manageexpensepage.click_SearchIconOfSubManageExpense();
		manageexpensepage.search_enterValidUserDataOfSubManageExpense();
		manageexpensepage.enterTitleDataOfSubManageExpense("Grocery (Staff-ST)");
		manageexpensepage.search_enterValidCategoryDataOfSubManageExpense();
		manageexpensepage.click_SearchButtonOfSubManageExpense();
		Assert.assertFalse(manageexpensepage.searchButtonOfSubManageExpenseIsSelected());
		System.out.println(manageexpensepage.getText_NewWindowReportOfSubManageExpense());
		manageexpensepage.click_BackButtonOfReport();
		
		
	}
}
