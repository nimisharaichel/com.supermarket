package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LogInPage;
import com.supermarket.pages.ManageProduct;

public class ManageProductTest extends Base {
	LogInPage loginpage;
	ManageProduct manageproduct;

	@Test
	public void verify_SearchchFunctionalityOfManageProduct() {
		loginpage = new LogInPage(driver);
		loginpage.logIn();
		manageproduct = new ManageProduct(driver);
		manageproduct.click_ManageProductLink();
		manageproduct.click_SearchButton();
		manageproduct.enter_DataEntrySearchFields("Fruits", "1038");
		manageproduct.select_CategoryFieldForSearch(1);
		manageproduct.select_SubCategoryForSearch(2);
		manageproduct.click_SearchButtonField();
		String expectedResult = Constants.TITLENAME_SEARCHFIELD;
		String actualResult = manageproduct.getText_SearchTitleName();
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test
	public void enter_ManageProductDetails() {
		loginpage = new LogInPage(driver);
		SoftAssert softassert = new SoftAssert();
		loginpage.logIn();
		manageproduct = new ManageProduct(driver);
		manageproduct.click_ManageProductLink();
		manageproduct.click_NewButtonLink();
		manageproduct.enter_TitlenameOfManageProduct("Chicken");
		manageproduct.click_NonVegOptionRadioButton();
		manageproduct.enter_TagNameField("BoilerChicken");
		manageproduct.select_FieldOptionsForManageProduct();
		manageproduct.enter_WeightPriceLinkField("2");
		manageproduct.select_WeightUnitLinkOption(2);
		manageproduct.enter_ProductPriceDetails("50", "500", "535.89", "200", "550", "Fresh Product");
		manageproduct.upload_ChooseImageField(Constants.IMAGEUPLOAD_MANAGEPRODUCT);
		manageproduct.click_SaveButton();
		String expectedResult = Constants.SUCESSMESSAGEALERT_ATTRIBUTEVALUE;
		String actualresult = manageproduct.getAttribute_AlertSucessMessage();
		softassert.assertEquals(actualresult, expectedResult);
		softassert.assertAll();
	}
}
