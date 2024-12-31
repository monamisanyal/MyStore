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
public class OrderSummaryPage extends baseClass {
	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	WebElement ConfirmOrderbtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
public OrderConfirmationPage confirmorder() {
	Action.click(ConfirmOrderbtn);
	return new OrderConfirmationPage();
}
}
