package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class DashBoardPage {
	WebDriver driver;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	private WebElement titleLink;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-th-large']")
	private WebElement logoSymbol;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String get_TitleOfPage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.get_Title(titleLink);
	}

	public String get_CurrentUrlOfThePage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.get_CurrentUrl();
	}

	public boolean logoSymbol_DashBoard() {
		generalutility = new GeneralUtility(driver);
		return generalutility.is_Displayed(logoSymbol);
	}

}
