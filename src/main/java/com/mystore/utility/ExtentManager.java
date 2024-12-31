package com.mystore.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mystore.base.baseClass;


public class ExtentManager {

    public static ExtentSparkReporter sparkReporter;  // Changed to ExtentSparkReporter
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() throws Exception {
        // Set the report path with dynamic file name based on current time
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\ExtentReport\\" + "MyReport.html");

        // Optionally load configuration file (it might be XML or JSON based on your ExtentReport version)
        sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");

        // You can also directly configure some properties if you don't use an external config file:
//        sparkReporter.config().setDocumentTitle("Automation Test Report");
//        sparkReporter.config().setReportName("OrangeHRM Test Automation Report");
//        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK); // Dark theme for the report

        // Initialize ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system information for the report
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "MyStoreProject");
        extent.setSystemInfo("Tester", "Monami");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void endReport() {
        extent.flush(); // Finalize and write the report to disk
    }
}

