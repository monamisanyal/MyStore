package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public ExtentReports extent;
	 public ExtentSparkReporter sparkReporter;;

	public static Properties prop;
//	public static WebDriver driver;
	 // ThreadLocal to store the WebDriver instance for each thread
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    
 // Method to get the WebDriver instance for the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    @BeforeSuite(groups= {"smoke","sanity","regression"})
    public void loadConfig() throws Exception {
    	ExtentManager.setExtent();
    	DOMConfigurator.configure("log4j.xml");
    	try {
			prop =new Properties();
			FileInputStream ip = new FileInputStream ("C:\\Users\\monamis\\eclipse-workspace\\Mystoreproject\\Configuration\\Config.properties");
			prop.load(ip);
		
			
			
		}
		catch (FileNotFoundException ex) {
            ex.printStackTrace();}
		catch (IOException ex) {
            ex.printStackTrace();}
		
		
    	}
    
   
    
//	@BeforeTest(groups= {"smoke","sanity","regression"})
//	public Properties loadConfig() {
//		
//		try {
//			prop =new Properties();
//			FileInputStream ip = new FileInputStream ("C:\\Users\\monamis\\eclipse-workspace\\Mystoreproject\\Configuration\\Config.properties");
//			prop.load(ip);
//		
//			
//			
//		}
//		catch (FileNotFoundException ex) {
//            ex.printStackTrace();}
//		catch (IOException ex) {
//            ex.printStackTrace();}
//		
//		return prop;
//	}
	
	public void launchApp(String browserName) {
		
//		String browserName = prop.getProperty("browser"); when fetching from config properties

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();  // Automatically manage ChromeDriver
//            driver = new ChromeDriver();
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();  // Automatically manage GeckoDriver
//            driver = new FirefoxDriver();
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();  // Automatically manage IE Driver
//            driver = new InternetExplorerDriver();
            driver.set(new InternetExplorerDriver());
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        // Initialize WebDriver wait
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
        getDriver().get(prop.getProperty("url"));
		Action.initializeDriver(getDriver()); 
		
	}
	
	@AfterSuite
    public void AfterSuite() throws Exception {
    	ExtentManager.endReport();;
    	
    	}	

	
}
