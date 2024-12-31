/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.baseClass;
/**
 * 
 */
public class ShippingPage extends baseClass {
	
	@FindBy(id="uniform-cgv")
	WebElement termscheckbox;
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckoutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void enableTerms() {
		Action.click(termscheckbox);
	}
	
	public PaymentPage clickconproceedtocheckout() {
		Action.click(proceedtoCheckoutBtn);
				return new PaymentPage();
		}
	}
	
	