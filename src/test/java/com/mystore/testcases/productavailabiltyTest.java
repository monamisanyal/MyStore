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
import com.mystore.pageobjects.SearchResultPage;

/**
 * 
 */
public class productavailabiltyTest extends baseClass{
	
	IndexPage ip;
	SearchResultPage srp;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) {
		launchApp(browser);
		}
	

	@AfterMethod(groups= {"smoke","sanity","regression"})
public void teardown()
{
		getDriver().quit();
}
@Test(groups="smoke")
	public void checkproductavailability() {
	ip=new IndexPage();
		srp=ip.searchProduct("Blouse");
		boolean result= srp.isProductAvailable();
		Assert.assertTrue(result);
	}
}
