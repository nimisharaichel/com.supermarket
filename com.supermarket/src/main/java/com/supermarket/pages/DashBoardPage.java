package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;

public class DashBoardPage {
	WebDriver driver;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//span[@class='brand-text font-weight-light']")
	private WebElement titleLink;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
public String get_TitleOfPage() {
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Title(titleLink);
}

public String get_CurrentUrlOfThePage() {
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CurrentUrl();
}

}
