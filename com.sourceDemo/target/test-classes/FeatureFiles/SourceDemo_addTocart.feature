@sourceDemoCart
Feature: Add products to the sourceDemo Cart and place order

Background: 

		Given login into the application with valid username "standard_user" and password "secret_sauce"

Scenario: Add products to the cart and verify the bill amount

		Given choose the product randomly and capture the amount
		When Navigate to the product cart and verify the selected product added properly
		And Enter user details Firstname "Jomy" Lastname "George" Pincode "641041" to place the order 
	    Then Verify the Grand total of the product and place the order
	    
	    
		
		
		

		
