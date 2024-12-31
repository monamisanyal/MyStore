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
import com.mystore.dataprovider.dataProvider;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.log;

/**
 * 
 */
public class LoginPageTest extends baseClass {
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
	
	@Test (dataProvider="Credentials1" , dataProviderClass=dataProvider.class ,groups= {"smoke","sanity"} )
	public void loginTest(String uname,String pass) {
		log.startTestCase("loginTest");
		ip=new IndexPage();
		log.logInfo("user is going to click on Sign in button");
	lp=	ip.clickSigninBtn();
	log.logInfo("user will enter username and password");
//	hp=lp.signintest(prop.getProperty("username"), prop.getProperty("password")); when using config properties
	// when using data provider
	hp=lp.signintest(uname,pass);
		String actURL = hp.getcurrentURL();
		String expectURL ="http://www.automationpractice.pl/index.php?controller=my-account";
		log.logInfo("verifying correct url user navigated to");
		Assert.assertEquals(actURL, expectURL);
		log.endTestCase("loginTest");
	}
}
