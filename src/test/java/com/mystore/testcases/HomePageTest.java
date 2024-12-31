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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * 
 */
public class HomePageTest extends baseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) {
		launchApp(browser);
		}
	
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups="smoke")
	public void verifyOrderHistory() {
		ip=new IndexPage();
		lp=	ip.clickSigninBtn();
		hp=lp.signintest(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=hp.validateOrderHistory();
		Assert.assertTrue(result);
	}
}
