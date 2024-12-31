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
public class PaymentPage extends baseClass {
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement PaymentbybankWire;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement PaymentbybankCheque;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
public OrderSummaryPage PaybybankWire() {
	Action.click(PaymentbybankWire);
	return new OrderSummaryPage();
}


}
