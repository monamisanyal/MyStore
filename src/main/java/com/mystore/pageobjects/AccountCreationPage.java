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
public class AccountCreationPage extends baseClass{
	
	@FindBy(xpath="//*[@id=\"noSlide\"]/h1")
	WebElement FormTitle;
	
	@FindBy(id="customer_firstname")
	WebElement First;
	
	@FindBy(id="customer_lastname")
	WebElement Last;
	
	@FindBy(id="email")
	WebElement EmailA;
	
	@FindBy(id="passwd")
	WebElement Passwd;
	
	@FindBy(id="submitAccount")
	WebElement RigistrBtn;
	

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
			}
	
	public boolean validatetitle() {
	return	Action.isElementVisible(FormTitle);
	}
	
	public HomePage registeraccount(String Firstname,String Lastname,String EmailAdd,String Password) {
		Action.enterText(First, Firstname);
		Action.enterText(Last, Lastname);
		Action.enterText(EmailA, EmailAdd);
		Action.enterText(Passwd, Password);
		Action.click(RigistrBtn);
		return new HomePage();
	}
	
	
}
