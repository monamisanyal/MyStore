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
public class HomePage extends baseClass {
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement OrderHistory_Details;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
			}
	
	public boolean validateOrderHistory() {
		return Action.isElementVisible(OrderHistory_Details);
	}
	
	public String getcurrentURL()
	{
		String curURL=getDriver().getCurrentUrl();	
		return curURL;}	
}
