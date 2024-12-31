package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.baseClass;

public class LoginPage extends baseClass {

	@FindBy(id="email")
	WebElement SigninEmailAdd;
	
	@FindBy(id="passwd")
	WebElement SigninPassword;
	
	@FindBy(xpath="//a[contains(@title,\"forgotten\")]")
	WebElement ForgetPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement SigninBtn;
	
	@FindBy(id="email_create")
	WebElement SignupEmailAdd;
	
	@FindBy(id="SubmitCreate")
	WebElement Createanaccountbtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage signintest(String signin_emailadd,String password) {
		Action.enterText(SigninEmailAdd, signin_emailadd);
		Action.enterText(SigninPassword, password);
		Action.click(SigninBtn);
		return new HomePage();
	}
	
	public AddressPage signintest_checkout(String signin_emailadd,String password) {
		Action.enterText(SigninEmailAdd, signin_emailadd);
		Action.enterText(SigninPassword, password);
		Action.click(SigninBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createnewaccount(String SignupEmailadd) {
		Action.enterText(SignupEmailAdd, SignupEmailadd);
		Action.click(Createanaccountbtn);
		return new AccountCreationPage();
	}
}
