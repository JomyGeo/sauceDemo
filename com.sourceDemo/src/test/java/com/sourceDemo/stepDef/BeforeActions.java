package com.sourceDemo.stepDef;




import com.sourceDemo.utility.SeleniumDriver;

import cucumber.api.java.Before;


public class BeforeActions  {

	@Before
    public static void setUp() {

		SeleniumDriver.setUpDriver();
       
    }
}
