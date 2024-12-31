package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.baseClass;

public class IndexPage extends baseClass {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signinbtn;
	
	@FindBy(xpath="//img[@alt='My Shop']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement SearchProductBox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement SearchBtn;
	
	
	public IndexPage() {
		
		PageFactory.initElements(getDriver(),this);
	}
	
	public LoginPage clickSigninBtn() {
		Action.click(signinbtn);
		
		return new LoginPage();
	} 
	
	public boolean validateLogo() {
		return Action.isElementVisible(myStoreLogo);
	}
	
	public String getmystoretitle() {
		String MystoreTitle= getDriver().getTitle();
		return MystoreTitle;
	}
	
	public SearchResultPage searchProduct(String Productname) {
		Action.enterText(SearchProductBox,Productname );
		Action.click(SearchBtn);
		return new SearchResultPage();
		
	}

}
