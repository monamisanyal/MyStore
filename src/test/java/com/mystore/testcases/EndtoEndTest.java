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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * 
 */
public class EndtoEndTest extends baseClass {

	IndexPage ip;
	SearchResultPage srp;
	AddtoCartPage acp;
	OrderPage op;
	LoginPage lp;
	AddressPage ap;
	ShippingPage ssp;
	PaymentPage pay_p;
	OrderSummaryPage osp;
	OrderConfirmationPage ocp;
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
public void Testorderproduct() {
		ip=new IndexPage();
		srp=ip.searchProduct("Blouse");
		acp=srp.clickonproduct();
		acp.checkitemaddedtocart("2", "3");
		op=acp.proceedtoCheckoutpage();
		lp=op.clickcheckoutoproceed();
		ap =lp.signintest_checkout(prop.getProperty("username"), prop.getProperty("password"));
		ssp= ap.clickcheckoutoproceed();
		ssp.enableTerms();
		pay_p=ssp.clickconproceedtocheckout();
		osp=pay_p.PaybybankWire();
		ocp= osp.confirmorder();
		String actualmsg= ocp.validateconfirmmessage();
		String expectedmsg= "Your order on My Shop is complete.";
		Assert.assertEquals(actualmsg, expectedmsg);
	}

}
