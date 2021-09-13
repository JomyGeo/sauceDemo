package com.sourceDemo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SourceDemo_PropertiesFile {
	


	Properties prop;
	String propertyValue = null;

	public SourceDemo_PropertiesFile() {

		try {

			File source = new File("./Property_file/sourceDemo.properties");
			FileInputStream fis = new FileInputStream(source);

			prop = new Properties();
			prop.load(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("Ünable to read property file" + e.getMessage());

		}

	}
	
    public String getBrowserName() {
		
		return prop.getProperty("browser");
	}
    
 public String getURL() {
		
		return prop.getProperty("URL");
	}
  
}



