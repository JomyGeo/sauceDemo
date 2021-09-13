package com.sourceDemo.utility;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
 
    //initialize webdriver
    private static WebDriver driver;
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 50;
    public final static int PAGE_LOAD_TIMEOUT = 50;
    SourceDemo_PropertiesFile prop = new SourceDemo_PropertiesFile();

    private  SeleniumDriver() {

       
       
       if(prop.getBrowserName().equalsIgnoreCase("chrome"))
       {
    	   System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    	   driver = new ChromeDriver();
       }
       else if(prop.getBrowserName().equalsIgnoreCase("firefox"))
       {
    	   System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
       	   File pathBinary = new File("C:\\Users\\jgeorge\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    	   FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
    	   DesiredCapabilities desired = DesiredCapabilities.firefox();
    	   FirefoxOptions options = new FirefoxOptions();
    	   desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
    	   driver = new FirefoxDriver(options);
    	   
    	 
       }else if(prop.getBrowserName().equalsIgnoreCase("edge"))
       {
    	   System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
    	   driver = new EdgeDriver();
       }
              
       else {
    	   
    	   System.out.println("No browser launched. Please provide proper browser name in the config file");
       }
    	
        driver.manage().window().maximize();
        driver.get(prop.getURL());
        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

       
    }

    public static void openPage(String url) {
    	System.out.println(url);
    	System.out.println(driver);
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
       if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }
}
