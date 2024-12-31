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
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * 
 */
public class priceTest extends baseClass {

	IndexPage ip;
	SearchResultPage srp;
	AddtoCartPage acp;
	OrderPage op;
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
	@Test(groups="regression")
public void verifytoalprice() {
	ip=new IndexPage();
	srp=ip.searchProduct("Blouse");
	acp=srp.clickonproduct();
	acp.checkitemaddedtocart("2", "3");
	op=acp.proceedtoCheckoutpage();
	Double unitPrice =op.getUnitPrice();
	Double TotalPrice= op.getTotalPrice();
	System.out.println(TotalPrice);
	Double expectedPrice = (unitPrice*2)+7;
	System.out.println(expectedPrice);
	Assert.assertEquals(TotalPrice, expectedPrice);
	
}
	
}
