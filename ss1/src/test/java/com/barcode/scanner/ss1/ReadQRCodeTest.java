
package com.barcode.scanner.ss1;
/*
 * MIT License
 *
 * Copyright (c) 2018 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/*import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static org.assertj.core.api.Assertions.assertThat;

*/

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


class ReadQRCodeTest {
	
	
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
	    	String asURL = "http:\\0.0.0.0:4723\\wd\\hub";
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
	    
	   

	/*
	 * private static final Logger log =
	 * LoggerFactory.getLogger(ReadQRCodeTest.class);
	 * 
	 * private AppiumDriver<MobileElement> driver; private AppiumDriverLocalService
	 * service;
	 * 
	 * //URL url = null;
	 * 
	 * 
	 * @BeforeEach
	 * 
	 * public void setup() { DesiredCapabilities capabilities = new
	 * DesiredCapabilities(); capabilities.setCapability(MobileCapabilityType.APP,
	 * new File("F:\\TEXTEXPRESS\\qrcode-app.apk").getAbsolutePath());
	 * capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
	 * AutomationName.APPIUM);
	 * capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
	 * MobilePlatform.ANDROID);
	 * capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	 * capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
	 * "Android Emulator"); // capabilities.setCapability(MobileCapabilityType.")
	 * 
	 * 
	 * System.out.println("App Capabilities: "+capabilities);
	 * 
	 * 
	 * try { URL url = new URL("http://0.0.0.0:4723/wd/hub");
	 * System.out.println("Appium server started"); } catch (MalformedURLException
	 * e) { System.out.
	 * println("Appium Server could not be started...malformed exception occured.");
	 * e.printStackTrace(); }catch(Exception e){
	 * System.out.println("Appium Server could not be started");
	 * e.printStackTrace(); }
	 * 
	 * try {
	 * System.out.println("----- Launching Appium driver using Appium Server----");
	 * driver = new AppiumDriver(new
	 * URL("http://0.0.0.0:4723/wd/hub"),capabilities); Thread.sleep(5000);
	 * 
	 * } catch(Exception ex) { System.out.println("Error launching Driver:"+ ex); }
	 * 
	 * 
	 * AppiumServiceBuilder builder = new AppiumServiceBuilder().usingAnyFreePort();
	 * service = AppiumDriverLocalService.buildService(builder); driver = new
	 * AppiumDriver<>(builder, capabilities);
	 * 
	 * service.start();
	 * 
	 * //readQRCode();
	 * 
	 * }
	 * 
	 * @AfterEach public void tearDown() { driver.quit(); service.stop(); }
	 * 
	 *//**
		 * This test capture the screenshot and get the element that contains the QRCode
		 * Based on the element points (width and height) the image os cropped With
		 * cropped image we can decode the QRCode with axing
		 */
	/*
	 * @Test void readQRCode() { MobileElement qrCodeElement =
	 * driver.findElement(By.id("com.example.qrcode:id/qrcode")); File screenshot =
	 * driver.getScreenshotAs(OutputType.FILE);
	 * 
	 * String content = decodeQRCode(generateImage(qrCodeElement, screenshot)); //
	 * assertThat(content).isEqualTo("f3ce8d4d-074f-483f-9fd0-45c7947fd40c"); }
	 * 
	 *//**
		 * Return a cropped image based on an element (in this case the qrcode image)
		 * from the entire device screenshot
		 *
		 * @param element    elemement that will show in the screenshot
		 * @param screenshot the entire device screenshot
		 * @return a new image in BufferedImage object
		 */
	/*
	 * private BufferedImage generateImage(MobileElement element, File screenshot) {
	 * BufferedImage qrCodeImage = null;
	 * 
	 * try { BufferedImage fullImage = ImageIO.read(screenshot); Point imageLocation
	 * = element.getLocation();
	 * 
	 * int qrCodeImageWidth = element.getSize().getWidth(); int qrCodeImageHeight =
	 * element.getSize().getHeight();
	 * 
	 * int pointXPosition = imageLocation.getX(); int pointYPosition =
	 * imageLocation.getY();
	 * 
	 * qrCodeImage = fullImage.getSubimage(pointXPosition, pointYPosition,
	 * qrCodeImageWidth, qrCodeImageHeight); ImageIO.write(qrCodeImage, "png",
	 * screenshot); } catch (IOException e) {
	 * log.error("Problem during the image generation", e); }
	 * 
	 * return qrCodeImage; }
	 * 
	 *//**
		 * Decode a QR Code image using zxing
		 *
		 * @param qrCodeImage the qrcode image cropped from entire device screenshot
		 * @return the content
		 *//*
			 * private static String decodeQRCode(BufferedImage qrCodeImage) { Result result
			 * = null; try { LuminanceSource source = new
			 * BufferedImageLuminanceSource(qrCodeImage); BinaryBitmap bitmap = new
			 * BinaryBitmap(new HybridBinarizer(source));
			 * 
			 * result = new MultiFormatReader().decode(bitmap); } catch (NotFoundException
			 * e) { log.error("QRCode not found", e); } return result.getText(); }
			 */
}