/**
 * 
 */
package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.baseClass;
/**
 * 
 */
public class SearchResultPage extends baseClass {
	
	@FindBy(xpath="//img[@title='Blouse']")
	WebElement SearchProduct;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() {
	return	Action.isElementVisible(SearchProduct);
	}
	
	public AddtoCartPage clickonproduct() {
		Action.click(SearchProduct);
		return new AddtoCartPage();
	}
	
}
