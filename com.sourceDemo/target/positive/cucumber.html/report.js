$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SourceDemo_addTocart.feature");
formatter.feature({
  "line": 2,
  "name": "Add products to the sourceDemo Cart and place order",
  "description": "",
  "id": "add-products-to-the-sourcedemo-cart-and-place-order",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@sourceDemoCart"
    }
  ]
});
formatter.before({
  "duration": 8595921967,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "login into the application with valid username \"standard_user\" and password \"secret_sauce\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 48
    },
    {
      "val": "secret_sauce",
      "offset": 77
    }
  ],
  "location": "SourceDemo_Steps.login_into_the_application_with_valid_username_and_password(String,String)"
});
formatter.result({
  "duration": 1566261420,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Add products to the cart and verify the bill amount",
  "description": "",
  "id": "add-products-to-the-sourcedemo-cart-and-place-order;add-products-to-the-cart-and-verify-the-bill-amount",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "choose the product randomly and capture the amount",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Navigate to the product cart and verify the selected product added properly",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Enter user details Firstname \"Jomy\" Lastname \"George\" Pincode \"641041\" to place the order",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Verify the Grand total of the product and place the order",
  "keyword": "Then "
});
formatter.match({
  "location": "SourceDemo_Steps.choose_the_product_randomly_and_capture_the_amount()"
});
formatter.result({
  "duration": 714120496,
  "status": "passed"
});
formatter.match({
  "location": "SourceDemo_Steps.navigate_to_the_product_cart_and_verify_the_selected_product_added_properly()"
});
formatter.result({
  "duration": 457479024,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jomy",
      "offset": 30
    },
    {
      "val": "George",
      "offset": 46
    },
    {
      "val": "641041",
      "offset": 63
    }
  ],
  "location": "SourceDemo_Steps.enter_user_details_Firstname_Lastname_Pincode_to_place_the_order(String,String,String)"
});
formatter.result({
  "duration": 814070126,
  "status": "passed"
});
formatter.match({
  "location": "SourceDemo_Steps.validate_the_Grand_total_of_the_product()"
});
formatter.result({
  "duration": 364607161,
  "status": "passed"
});
formatter.after({
  "duration": 243918,
  "status": "passed"
});
});