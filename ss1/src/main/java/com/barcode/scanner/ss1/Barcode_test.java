/*
 * package com.barcode.scanner.ss1;
 * 
 * import java.awt.image.BufferedImage; import java.io.IOException; import
 * java.net.MalformedURLException; import java.net.URL;
 * 
 * import javax.imageio.ImageIO;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import org.testng.annotations.Test;
 * 
 * import com.google.zxing.BinaryBitmap; import
 * com.google.zxing.LuminanceSource; import com.google.zxing.MultiFormatReader;
 * import com.google.zxing.NotFoundException; import com.google.zxing.Result;
 * import com.google.zxing.client.j2se.BufferedImageLuminanceSource; import
 * com.google.zxing.common.HybridBinarizer;
 * 
 * public class Barcode_test {
 * 
 * @Test public void barcode_scanner() throws IOException, NotFoundException {
 * 
 * // System Property for Chrome Driver
 * System.setProperty("webdriver.chrome.driver",
 * "F:\\TEXTEXPRESS\\Drivers\\chromedriver.exe");
 * 
 * // Instantiate a ChromeDriver class. WebDriver driver = new ChromeDriver();
 * 
 * driver.get(
 * "https://barcode.tec-it.com/en/Code128?data=Hi%20This%20is%20Kirti%20here");
 * 
 * String barCodeUrl =
 * driver.findElement(By.tagName("img")).getAttribute("src");
 * System.out.println(barCodeUrl); //main code // new
 * 
 * URL url= new URL(barCodeUrl); BufferedImage bufferedImage =
 * ImageIO.read(url); LuminanceSource luminanceSource = new
 * BufferedImageLuminanceSource(bufferedImage); BinaryBitmap binaryBitmap = new
 * BinaryBitmap(new HybridBinarizer(luminanceSource)); Result result = new
 * MultiFormatReader().decode(binaryBitmap);
 * 
 * 
 * 
 * 
 * System.out.println(result.getText()); //driver.close();
 * 
 * 
 * }
 * 
 * }
 */