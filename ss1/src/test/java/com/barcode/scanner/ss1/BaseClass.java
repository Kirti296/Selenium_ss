package com.barcode.scanner.ss1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	//  private AppiumDriver<MobileElement> driver;
	  @BeforeTest
    public void setup() throws MalformedURLException {
		  
		  File f = new File("F:\\TEXTEXPRESS\\qrcode-app.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
	// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    
    
    // Specify the device name (any name)
     
    capabilities.setCapability("deviceName", "Kirti-5554");
     
     
    // Platform version
     
    //capabilities.setCapability("platformVersion", "4.4.2");
     
     
    // platform name
     
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
     
    // specify the application package that we copied from appium      
    capabilities.setCapability("app", "f");
     
    capabilities.setCapability("appPackage", "com.example.qrcode");
     
     
    // specify the application activity that we copied from appium                   
     
    capabilities.setCapability("appActivity", ".com.eliasnogueira.qrcode.MainActivity");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
    
   // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME , "Chrome");
    URL url= new URL("http://0.0.0.0:4727/wd/hub");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
   AndroidDriver driver = new AndroidDriver<>(url, capabilities);
    
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
}
	  
	  @Test
	  
	  public void readqr()
	  {
		  System.out.println("runsuccessfuuly");
	  }
    @AfterTest
    public void tearDown() {
       //driver.quit();
  //      service.stop();
  //  
}
    
}
