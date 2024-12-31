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
/**
 * 
 */
public class AddressPage extends baseClass {

	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span")
	WebElement proceedtoCheckoutBtn;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	 public ShippingPage clickcheckoutoproceed() {
		 Action.click(proceedtoCheckoutBtn);
		 getDriver().navigate().refresh();
		 return new ShippingPage();
		 
		 
	 }
}
