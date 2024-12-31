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
import com.mystore.pageobjects.IndexPage;

/**
 * 
 */
public class IndexPageTest extends baseClass {
	IndexPage ip;
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
	public void verifyLogo() {
		ip=new IndexPage();
		boolean result =ip.validateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups="smoke")
	public void verifyTitle() {
		ip=new IndexPage();
	String title=	ip.getmystoretitle();
	Assert.assertEquals(title,"My Shop");
	}
	
	
}
