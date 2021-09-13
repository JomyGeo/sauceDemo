package com.sourceDemo.pages.actions;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sourceDemo.pages.locators.SourceDemo_Locators;
import com.sourceDemo.utility.SeleniumDriver;
import com.sourceDemo.utility.SeleniumHelper;


public class SourceDemo_actions {

	SourceDemo_Locators sourceDemoCart = null;
	SeleniumHelper helper = new SeleniumHelper();
	
	Random randomNum = new Random();
	
	static int productOrder = 0;
	static String productName = null;
	static String productRate = null;
	
	public SourceDemo_actions() {
		
		this.sourceDemoCart = new SourceDemo_Locators();
		PageFactory.initElements(SeleniumDriver.getDriver(), sourceDemoCart);
		

	}
	
	
	public void loginApplication(String username , String password) throws Exception {
		
		
		helper.sendElementByWebElement(sourceDemoCart.loginUsername, username);
		helper.sendElementByWebElement(sourceDemoCart.loginPassword, password);
		helper.clickElementByWebElement(sourceDemoCart.loginSubmit);
	}
	
	public void chooseProducts() throws InterruptedException {
		
		productOrder = randomNum.nextInt(sourceDemoCart.listProducts.size());
		productName = sourceDemoCart.productName.get(productOrder).getText().trim();
		productRate = sourceDemoCart.productPrice.get(productOrder).getText().trim();
		helper.clickElementByWebElement(sourceDemoCart.listProducts.get(productOrder));
		
		System.out.println("productName"+productName+" :  productRate"+productRate);
		
	}
	
	public void navigateTocart() throws InterruptedException {
		
		helper.clickElementByWebElement(sourceDemoCart.NavigateproductCart);
	}
	
	public void productsDetailsCart() throws InterruptedException {
				
		for(int i=0;i<sourceDemoCart.productNameCart.size();i++) {
			
			
			if(sourceDemoCart.productNameCart.get(i).getText().trim().equalsIgnoreCase(productName)) {
				
				
				if(sourceDemoCart.productRateCart.get(i).getText().trim().equals(productRate)) {
					
					System.out.println("Product name and rate matched properly");
				}
			}
		}
	

	}
	
	
	public void UserDetails(String firstName , String lastName , String Pincode) throws Exception {
		
		helper.clickElementByWebElement(sourceDemoCart.checkOut_btn);
		helper.sendElementByWebElement(sourceDemoCart.userFirstName, firstName);
		helper.sendElementByWebElement(sourceDemoCart.userLastName,lastName );
		helper.sendElementByWebElement(sourceDemoCart.userPostalCode, Pincode);
		helper.clickElementByWebElement(sourceDemoCart.continueCheckout);
	
	}
	public void productCartTotal() {
		
		String itemTotalvalue = sourceDemoCart.itemTotal.getText().replace("Item total: $", " ").trim();
		double itemTotal = Double.parseDouble(itemTotalvalue);
		
		String itemTaxvalue = sourceDemoCart.taxTotal.getText().replace("Tax: $", " ").trim();
		double taxTotal = Double.parseDouble(itemTaxvalue);
		
		
		double expectedGrandTotal = itemTotal+taxTotal;
		
		String grandTaxvalue = sourceDemoCart.grandTotal.getText().replace("Total: $", " ").trim();
		double grandTotal = Double.parseDouble(grandTaxvalue);
		
		Assert.assertEquals(grandTotal, expectedGrandTotal );
	
		
	}
	
	
	public void confirmOrder() throws InterruptedException {
		
		
		helper.clickElementByWebElement(sourceDemoCart.confirmOrder);
		
		String successMsg = sourceDemoCart.orderSuccessmsg.getText().trim();
		
		Assert.assertEquals(successMsg, "THANK YOU FOR YOUR ORDER");
	}
	
		
	}
	
	

	
	
	
		
	
	




