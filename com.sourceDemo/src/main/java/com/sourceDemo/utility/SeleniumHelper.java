package com.sourceDemo.utility;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.listener.ExtentCucumberFormatter;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class SeleniumHelper {
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	
	boolean value;
	

	public static String TIME_STAMP = new SimpleDateFormat("ddMMyyHHmmss").format(Calendar.getInstance().getTime());

	public boolean clickElementByWebElement(WebElement webelement) throws InterruptedException {

		for (int i = 1; i <= 3; i++) {
			try {
				this.explicitWait(webelement);
				(new WebDriverWait(SeleniumDriver.getDriver(),10)).until(ExpectedConditions.elementToBeClickable(webelement));
				
				if (webelement.isDisplayed()) {
					webelement.click();
					value = true;
					break;
				} else {
					JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
					js.executeScript("arguments[0].click();", webelement);
					value = true;
					break;
				}
			} catch (UnhandledAlertException e) {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println("Unable to click on the Element" + webelement);
				System.out.println("Retrying " + i + "... due to : " + e.getMessage());
				Thread.sleep(1000);
				if (i == 3)
				{
					throw new NoSuchElementException(e.getMessage());
					
				}
			}
		}
		return value;
	}


	public boolean sendElementByWebElement(WebElement webelement, String keyValue) throws Exception {

		for (int i = 1; i <= 3; i++) {
			try {
				this.explicitWait(webelement);
				webelement.sendKeys(keyValue);
				value = true;
				break;

			}

			catch (UnhandledAlertException e) {
				Thread.sleep(500);

			} catch (Exception e) {
				System.out.println("Retrying " + i + "... due to : " + e.getMessage());
				Thread.sleep(1000);
				if (i == 3)
					throw new NoSuchElementException(e.getMessage());
			}
		}

		return value;
	}
    public void explicitWait(WebElement webelement) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 20);
		//	wait.until(ExpectedConditions.elementToBeClickable(webelement));
		    wait.until(ExpectedConditions.visibilityOf(webelement));
		//	wait.until(ExpectedConditions.elementToBeSelected(webelement));
		//	wait.until(ExpectedConditions.presenceOfElementLocated((By) webelement));
	
           } catch (Exception e) {
		
    	   System.out.println("Unable to identity the element : " +webelement);
	   }
    }


    public static void startReport(){
    	 
    	
    	 htmlReporter = new ExtentHtmlReporter("./target/html/ExtentReport11.html");
    	 extent = new ExtentReports ();
    	
    	 extent.attachReporter(htmlReporter);
    	 
    	 SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
 		Date curDate = new Date();
 		String strDate = sdf.format(curDate);
 		String fileName = "./Extent_Reports/SourceDemo_ExtentReport_" + strDate+".html";
 		
    }
    
    public static void systemconfig() {
    	
    	htmlReporter.loadXMLConfig("./extentReportXML/extent-config.xml");
    	htmlReporter.config().setReportName("Name of the Report Comes here");
         //	 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    	htmlReporter.config().setTheme(Theme.STANDARD);

    
    }
    
    public static void flush() {
    	
    	extent.flush();
    }
	
}
