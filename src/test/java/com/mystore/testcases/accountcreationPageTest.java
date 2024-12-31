/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.baseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * 
 */
public class accountcreationPageTest extends baseClass {

	IndexPage ip;
	LoginPage lp;
	AccountCreationPage ap;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) {
		launchApp(browser);
		}
	
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void teardown() {
		getDriver().quit();
	}
	@Test(groups="sanity")
	public void createaccount() {
		ip=new IndexPage();
		lp=ip.clickSigninBtn();
		ap=lp.createnewaccount("Test@qa.com");
		boolean result = ap.validatetitle();
		Assert.assertTrue(result);
	}
}
