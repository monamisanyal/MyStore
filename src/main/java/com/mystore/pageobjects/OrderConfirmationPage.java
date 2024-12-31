/**
 * 
 */
package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.baseClass;
/**
 * 
 */
public class OrderConfirmationPage extends baseClass {
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement Confirmmessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateconfirmmessage() {
	String message= Confirmmessage.getText();
	return message;
	}
}
