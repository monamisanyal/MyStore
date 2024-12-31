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
public class OrderPage extends baseClass {
	@FindBy(xpath="//li[@class='price']")
	WebElement unitPrice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckoutBtn;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getUnitPrice() {
		String priceString = unitPrice.getText();  
		// Extract the price as a string (e.g., "$123.45")
		priceString = priceString.replaceAll("[^0-9.]", "");
		// Convert the price string to a float (or double)
		double price = Double.parseDouble(priceString); 
		return price;
		}
	
	public double getTotalPrice() {
		String TotalString = totalPrice.getText();  
		// Extract the price as a string (e.g., "$123.45")
		TotalString = TotalString.replaceAll("[^0-9.]", "");
		// Convert the price string to a float (or double)
		double tprice = Double.parseDouble(TotalString); 
		return tprice;
		}
 public LoginPage clickcheckoutoproceed() {
	 Action.click(proceedtoCheckoutBtn);
	 return new LoginPage();
 }
}
