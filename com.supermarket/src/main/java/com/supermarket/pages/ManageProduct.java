package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageProduct {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//i[@class='nav-icon fas fa-tasks']")
	private WebElement manageProductLink;
	
	@FindBy(xpath="//div[@class='content-header']")
	private WebElement headContentTextOfManageProduct;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButtonLink;
	
	@FindBy(xpath="//input[@name='un']")
	private WebElement titleNameSearch;
	
	@FindBy(xpath="//select[@id='sb']")
	private WebElement subCategoryOfSearch;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//tbody//tr[1]//td[1]")
	private WebElement nameFieldAfterSearchButton;
	
	@FindBy(xpath="//input[@name='cd']")
	private WebElement productNameSearch;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonLink;
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement titlenameOfManageProduct;
	
	@FindBy(xpath="//input[@value='Veg']")
	private WebElement vegOptionLink;
	
	@FindBy(xpath="//input[@value='Nonveg']")
	private WebElement nonVegOptionLink;
	
	@FindBy(xpath="//input[@value='Others']")
	private WebElement othersOptionLink;
	
	@FindBy(xpath="//input[@name='tag']")
	private WebElement tagNameLink;
	
	@FindBy(xpath="//select[@id='cat_id']")
	private WebElement categoryLink;
	
	@FindBy(xpath="//select[@id='sub_id']")
	private WebElement subCategoryLink;
	
	@FindBy(xpath="//select[@id='grp_id']")
	private WebElement groupLink;
	
	@FindBy(xpath="//input[@value='piece']")
	private WebElement pieceOfPriceType;
	
	@FindBy(xpath="//input[@value='litre']")
	private WebElement litreOfPriceType;
	
	@FindBy(xpath="//input[@value='weight']")
	private WebElement weightOfPriceType;
	
	@FindBy(xpath="//input[@id='m_weight']")
	private WebElement weightPriceLink;
	
	@FindBy(xpath="//select[@id='w_unit']")
	private WebElement weightUnitLink;
   
    @FindBy(xpath="//input[@name='max_weight']")
    private WebElement maximumWeightLink;
    
    @FindBy(xpath="//input[@id='w_price']")
    private WebElement priceTypeLink;
    
    @FindBy(xpath="//input[@id='w_mrp']")
    private WebElement mrpField;
    
    @FindBy(xpath="//input[@id='w_stock']")
    private WebElement stockAvailabilityField;
    
    @FindBy(xpath="//input[@id='w_pp']")
    private WebElement purchasePriceField;
    
    @FindBy(xpath="//div[@class='note-editable card-block']")
    private WebElement descriptionField;
    
    @FindBy(xpath="//input[@id='main_img']")
    private WebElement chooseImage;
    
    @FindBy(xpath="//button[text()='Save']")
    private WebElement saveButton;
    
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    private WebElement alertMessageSucess;
    

	
	
	public ManageProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void click_ManageProductLink() {
		manageProductLink.click();
	}
	public void click_SearchButton() {
		searchButtonLink.click();
	}
	public void enter_DataEntrySearchFields(String titleName_Search,String productName) {
		titleNameSearch.sendKeys(titleName_Search);
		productNameSearch.sendKeys(productName);
	}
	public void select_CategoryFieldForSearch(int value) {
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(value, categoryLink);
	}
	public void select_SubCategoryForSearch(int value) {
		waitutility=new WaitUtility(driver);
		waitutility.element_ToBeClickable(10L,"//select[@id='sb']");
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(value, subCategoryOfSearch);
	}
	public void click_SearchButtonField() {
		searchButton.click();
	}
	
	public String getText_SearchTitleName() {
		generalutility=new GeneralUtility(driver);
		return generalutility.get_Text(nameFieldAfterSearchButton);
	}
	
	
	public void click_NewButtonLink() {
		newButtonLink.click();
	}
	
	public void enter_TitlenameOfManageProduct(String title) {
		
		titlenameOfManageProduct.sendKeys(title);
	}
	public void click_vegOptionLinkRadioButton() {
		vegOptionLink.click();
	}
	public void click_NonVegOptionRadioButton() {
		nonVegOptionLink.click();
	}
	public void click_OthersOptionRadioButton() {
		othersOptionLink.click();
	}
	public void enter_TagNameField(String tagName) {
		tagNameLink.sendKeys(tagName);
	}
	public void select_CategoryLinkFieldOption(String value) {
		pageutility=new PageUtility(driver);
		pageutility.select_ByVisibleText(value, categoryLink);
	}
	public void select_SubCategoryLinkFieldOption(String value) {
		waitutility=new WaitUtility(driver);
		waitutility.element_ToBeClickable(10L,"//select[@id='sub_id']");
		subCategoryLink.click();
		pageutility=new PageUtility(driver);
		pageutility.select_ByVisibleText(value, subCategoryLink);
		
	}
	public void select_GroupLinkFieldOption(int value) {
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(value, groupLink);
	}
	public void click_WeightOfPriceType() {
		weightOfPriceType.click();
	}
	public void select_FieldOptionsForManageProduct() {
		select_CategoryLinkFieldOption("Grocery & Staples");
		select_SubCategoryLinkFieldOption("Others");
		select_GroupLinkFieldOption(1);
		click_WeightOfPriceType();
	}
public void enter_WeightPriceLinkField(String weight) {
	weightPriceLink.sendKeys(weight);
}
public void select_WeightUnitLinkOption(int value) {
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(value, weightUnitLink);
}
public void enter_ProductPriceDetails(String maximumWeight,String price,String mrp,String stock,String purchasePrice,String description) {
	maximumWeightLink.sendKeys(maximumWeight);
	priceTypeLink.sendKeys(price);
	mrpField.sendKeys(mrp);
	stockAvailabilityField.sendKeys(stock);
	purchasePriceField.sendKeys(purchasePrice);
	descriptionField.sendKeys(description);
}

public void upload_ChooseImageField(String file) {
	chooseImage.sendKeys(file);
}
public void click_SaveButton() {
	waitutility=new WaitUtility(driver);
	waitutility.element_ToBeClickable(10L,"//button[text()='Save']");
	pageutility=new PageUtility(driver);
	pageutility.click_JavaScriptExecutor(saveButton);
	//saveButton.click();
}
public String getText_AlertMessageSucess() {
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(alertMessageSucess);
	
}
public boolean isDisplayed_AlertMessageSucess() {
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(alertMessageSucess);
}
public String getAttribute_AlertSucessMessage() {
	generalutility=new GeneralUtility(driver);
	return generalutility.getAttributeOfElement(alertMessageSucess,"class");
}
}
