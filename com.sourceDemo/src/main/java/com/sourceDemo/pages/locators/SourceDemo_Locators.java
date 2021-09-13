package com.sourceDemo.pages.locators;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SourceDemo_Locators {

	
	@FindBy(how = How.ID, using = "user-name") 
	public  WebElement loginUsername;
	
	@FindBy(how = How.ID, using = "password") 
	public  WebElement loginPassword;
	
	@FindBy(how = How.ID, using = "login-button") 
	public  WebElement loginSubmit;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@name,'add-to-cart')]") 
	public  List<WebElement> listProducts;
	
	@FindBy(how = How.XPATH, using = "//div[@class='inventory_item_name']") 
	public  List<WebElement> productName;
	
	@FindBy(how = How.XPATH, using = "//div[@class='inventory_item_price']") 
	public  List<WebElement> productPrice;
	
	@FindBy(how = How.ID, using = "shopping_cart_container") 
	public  WebElement NavigateproductCart;
	
	@FindBy(how = How.XPATH, using = "//div[@class='cart_item_label']//a//div") 
	public  List<WebElement> productNameCart;
	
	@FindBy(how = How.XPATH, using = "//div[@class='inventory_item_price']") 
	public  List<WebElement> productRateCart;
	
	@FindBy(how = How.ID, using = "checkout") 
	public  WebElement checkOut_btn;
	
	@FindBy(how = How.ID, using = "first-name") 
	public  WebElement userFirstName;
	
	@FindBy(how = How.ID, using = "last-name") 
	public  WebElement userLastName;
	
	@FindBy(how = How.ID, using = "postal-code") 
	public  WebElement userPostalCode;
	
	@FindBy(how = How.ID, using = "continue") 
	public  WebElement continueCheckout;
	
	@FindBy(how = How.XPATH, using = "//div[@class='summary_subtotal_label']") 
	public  WebElement itemTotal;
	
	@FindBy(how = How.XPATH, using = "//div[@class='summary_tax_label']") 
	public  WebElement taxTotal;
	
	@FindBy(how = How.XPATH, using = "//div[@class='summary_total_label']") 
	public  WebElement grandTotal;
	
	@FindBy(how = How.ID, using = "finish") 
	public  WebElement confirmOrder;
	
	@FindBy(how = How.XPATH, using = "//div[@id='checkout_complete_container']//h2") 
	public  WebElement orderSuccessmsg;
}
