package com.sourceDemo.stepDef;

import org.testng.Assert;

import com.sourceDemo.pages.actions.SourceDemo_actions;
import com.sourceDemo.utility.SeleniumDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SourceDemo_Steps {

	boolean value;
	SourceDemo_actions sourceDemo = new SourceDemo_actions();


	
	@Given("^login into the application with valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void login_into_the_application_with_valid_username_and_password(String username, String password) throws Throwable {
		
		sourceDemo.loginApplication(username, password);
	    
	}

	@Given("^choose the product randomly and capture the amount$")
	public void choose_the_product_randomly_and_capture_the_amount() throws Throwable {
		
		sourceDemo.chooseProducts();
	    
	}

	@When("^Navigate to the product cart and verify the selected product added properly$")
	public void navigate_to_the_product_cart_and_verify_the_selected_product_added_properly() throws Throwable {
	    
		sourceDemo.navigateTocart();
		sourceDemo.productsDetailsCart();
	}

	@When("^Enter user details Firstname \"([^\"]*)\" Lastname \"([^\"]*)\" Pincode \"([^\"]*)\" to place the order$")
	public void enter_user_details_Firstname_Lastname_Pincode_to_place_the_order(String firstName, String lastName, String pincode) throws Throwable {
	   
		sourceDemo.UserDetails(firstName, lastName, pincode);
	}

	@When("^Verify the Grand total of the product and place the order$")
	public void validate_the_Grand_total_of_the_product() throws Throwable {
	    
		sourceDemo.productsDetailsCart();
		sourceDemo.productCartTotal();
		sourceDemo.confirmOrder();
		
	}



}