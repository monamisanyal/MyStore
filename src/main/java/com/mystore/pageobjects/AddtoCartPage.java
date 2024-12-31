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
public class AddtoCartPage extends baseClass{

	@FindBy(xpath="//*[@id='quantity_wanted'and @class='text']")
	WebElement Quantity;
	
	@FindBy(xpath="//*[@id='group_1' and @class='form-control attribute_select no-print']")
	WebElement Size;
	
	@FindBy(xpath="//span[text()=\"Add to cart\"]")
	WebElement AddtoCartbtn;
	
	@FindBy(xpath="//i[@class='icon-check']")
	WebElement validateaddtocart;
	
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	WebElement ProceedToCheckoutBtn;
	
	
	public AddtoCartPage() {
		PageFactory.initElements(getDriver(), this);
			}
	

 public void checkitemaddedtocart(String quantityw,String visiblesize) {
	
	 // Wait for Size drop down to be visible and select the size
     Action.waitForElementVisible(getDriver(), By.xpath("//*[@id='group_1' and @class='form-control attribute_select no-print']"));
     Action.selectDropdownByValue(Size,visiblesize);
     getDriver().navigate().refresh();
  // Wait for Quantity field to be visible and enter the quantity
     Action.waitForElementVisible(getDriver(), By.xpath("//*[@id='quantity_wanted'and @class='text']"));
	 Action.enterText(Quantity,quantityw);
	 
     // Wait for Add to Cart button to be click able and click it
     Action.waitForElementClickable(getDriver(), By.xpath("//span[text()='Add to cart']"));
	 Action.click(AddtoCartbtn);
 }
public boolean validateaddtocart() {
	
	return Action.isElementVisible(validateaddtocart);
}

public OrderPage proceedtoCheckoutpage() {
	Action.clickbyjs(ProceedToCheckoutBtn);
	return new OrderPage();
}


}
