package com.sourceDemo.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sourceDemo.utility.SeleniumHelper;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions( plugin = {"pretty","json:target/positive/cucumber.json", "html:target/positive/cucumber.html",("com.cucumber.listener.ExtentCucumberFormatter:Extent_Reports/ExtentReport.html")},
		features = "src/test/resources/FeatureFiles",
        glue = "com.sourceDemo.stepDef",
 		tags = {"@sourceDemoCart"},   
        monochrome = true)

public class Sourcedemo_TestRunner  extends AbstractTestNGCucumberTests  {
	@BeforeClass
    public static void setup() {
		
		SeleniumHelper.startReport();
    }		
	
	@AfterClass
	public void Report() {
		
		SeleniumHelper.systemconfig();
		SeleniumHelper.flush();
	}
}


	