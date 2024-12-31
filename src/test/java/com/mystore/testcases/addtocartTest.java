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
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * 
 */
public class addtocartTest extends baseClass {

	IndexPage ip;
	SearchResultPage srp;
	AddtoCartPage acp;
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
@Test(groups={"regression","sanity"})
	public void checkitemaddedincart() throws InterruptedException {
	ip=new IndexPage();
		srp=ip.searchProduct("Blouse");
		acp=srp.clickonproduct();
		acp.checkitemaddedtocart("2", "3");
		boolean result =acp.validateaddtocart();
		Assert.assertTrue(result);
		}
}
