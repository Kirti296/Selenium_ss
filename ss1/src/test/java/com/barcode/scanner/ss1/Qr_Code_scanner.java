package com.barcode.scanner.ss1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.appium.java_client.AppiumDriver;

public class Qr_Code_scanner {
	
	AppiumDriver driver = null;
	   
    URL url = null;
    @Test
    public void setup() throws MalformedURLException {
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        
      //Android
    	String platform = "Android";
    	String osVersion = "10";
    	String deviceName = "emulator-5554";
    	String udid = "emulator-5554";
    	String MobilePath="F:\\TEXTEXPRESS\\qrcode-app.apk";
    	String automationName = "uiautomator2";
    	String appPackage = "com.example.qrcode";
    	String appActivity = "com.eliasnogueira.qrcode.MainActivity";
    	String asURL = "http://0.0.0.0:4723/wd/hub";
    	String executionMode = "local";
    	//String brand = "EMEA-Whirlpool";
    	
    		
    		appCapabilities = new DesiredCapabilities();	
    		appCapabilities.setCapability("platformName",platform);
    		appCapabilities.setCapability("platformVersion",osVersion);
    		appCapabilities.setCapability("deviceName",deviceName );
    		appCapabilities.setCapability("udid",udid);
    		appCapabilities.setCapability("app", MobilePath);
    		appCapabilities.setCapability("noReset",true);
    		appCapabilities.setCapability("autoAcceptAlerts", true);
    		appCapabilities.setCapability("automationName",automationName);
    		appCapabilities.setCapability("appPackage",appPackage);
    		appCapabilities.setCapability("appActivity",appActivity);        
//        
        System.out.println("App Capabilities: "+appCapabilities);
		/*
		 * try { url = new URL("http://0.0.0.0:4723/wd/hub");
		 * System.out.println("Appium server started"); } catch (MalformedURLException
		 * e) { System.out.
		 * println("Appium Server could not be started...malformed exception occured.");
		 * e.printStackTrace(); }catch(Exception e){
		 * System.out.println("Appium Server could not be started");
		 * e.printStackTrace(); }
		 * 
		 * try {
		 * System.out.println("----- Launching Appium driver using Appium Server----");
		 * driver = new AppiumDriver(url,capabilities); Thread.sleep(5000);
		 * 
		 * } catch(Exception ex) { System.out.println("Error launching Driver:"+ ex); }
		 */
        url = new URL(asURL);
        driver = new AppiumDriver(url, appCapabilities);

     
		
		readQRCode();
        
    }

  
    /**
     * This test capture the screenshot and get the element that contains the QRCode
     * Based on the element points (width and height) the image os cropped
     * With cropped image we can decode the QRCode with axing
     */
    
    void readQRCode() {
    
        WebElement qrCodeElement = driver.findElement(By.id("com.example.qrcode:id/qrcode"));
        File screenshot = driver.getScreenshotAs(OutputType.FILE);

        String content = decodeQRCode(generateImage(qrCodeElement, screenshot));
        System.out.println(content);
       if(content.equals("f3ce8d4d-074f-483f-9fd0-45c7947fd40c")) {
    	   System.out.println("QR Code read successfully");
       }else {
    	   System.out.println("Not able to read QR Code");
       }
       
    }

    /**
     * Return a cropped image based on an element (in this case the qrcode image) from the entire device screenshot
     *
     * @param qrCodeElement    elemement that will show in the screenshot
     * @param screenshot the entire device screenshot
     * @return a new image in BufferedImage object
     */
    private BufferedImage generateImage(WebElement qrCodeElement, File screenshot) {
        BufferedImage qrCodeImage = null;

        try {
            BufferedImage fullImage = ImageIO.read(screenshot);
            Point imageLocation = qrCodeElement.getLocation();

            int qrCodeImageWidth = qrCodeElement.getSize().getWidth();
            int qrCodeImageHeight = qrCodeElement.getSize().getHeight();

            int pointXPosition = imageLocation.getX();
            int pointYPosition = imageLocation.getY();

            qrCodeImage = fullImage.getSubimage(pointXPosition, pointYPosition, qrCodeImageWidth, qrCodeImageHeight);
            ImageIO.write(qrCodeImage, "png", screenshot);
            
        } catch (IOException e) {
            System.out.println("Problem during the image generation"+ e);
        }

        return qrCodeImage;
    }

    /**
     * Decode a QR Code image using zxing
     *
     * @param qrCodeImage the qrcode image cropped from entire device screenshot
     * @return the content
     */
    private static String decodeQRCode(BufferedImage qrCodeImage) {
        Result result = null;
        try {
            LuminanceSource source = new BufferedImageLuminanceSource(qrCodeImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            result = new MultiFormatReader().decode(bitmap);
            
        } catch (NotFoundException e) {
            System.out.println("QRCode not found"+ e);
        }
        return result.getText();
    }
    

}
