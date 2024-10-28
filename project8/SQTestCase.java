package test123;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SQTestCase {

	static ChromeDriver driver;
	
		@BeforeMethod
		public void setUp() throws InterruptedException {
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver(); // Assigning the WebDriver instance to the static field
    	 driver.manage().window().maximize();

        // Create a new instance of the ChromeDriver
        

        // Navigate to the demo website
       
        driver.get("https://beta.ashidiamonds.com/LoginPage.aspx");
        driver.findElement(By.name("ctl00$ContentPlaceHolder1$JewelerIDss")).sendKeys("CARTJA11720");
        driver.findElement(By.name("ctl00$ContentPlaceHolder1$EmailID")).sendKeys("Avalontester1@gmail.com");
        driver.findElement(By.name("ctl00$ContentPlaceHolder1$Password")).sendKeys("CARTJA12345");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_A1")).click();
        Thread.sleep(6000);
       // Get the title of the webpage
        String title = driver.getTitle();

        // Print the title
        System.out.println("Title of the webpage: " + title);

    }

		@Test	
		public void SQtest1() throws InterruptedException{
	
	
		driver.get("https://beta.ashidiamonds.com/Product/ProductList.aspx?CategoryId=5&PCategoryId=5&PCategoryName=Bridals&CategoryName=Bridals");
		Thread.sleep(13000);
		
		WebElement elementToScrollTo = driver.findElement(By.xpath("(//span[@class='icon_wishlist WishListIcon DIcon SalesQIconList'])[1]"));
		
		int scrollValue = 500;
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + scrollValue + ");");
		
		Thread.sleep(3000);
		
		elementToScrollTo.click();
		Thread.sleep(3000);
		
		WebElement textElement = driver.findElement(By.xpath("(//label[@id='quotationname'])[1]"));
		String text = textElement.getText();
		
		System.out.println("Text from element: " + text);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@id='AddQuotation'])[1]")).sendKeys("test004");
		Thread.sleep(300);
		driver.findElement(By.xpath("(//a[@id='btn_AddToList'])[1]")).click();
		Thread.sleep(4000);
		
		elementToScrollTo.click();
		Thread.sleep(3000);
		
		WebElement textElement1 = driver.findElement(By.xpath("(//label[@id='quotationname'])[1]"));
		String text1 = textElement1.getText();
		
		System.out.println("Text from element: " + text1);
		
		String textBeforeParentheses = text1.split("\\(")[0].trim();
		System.out.println("textBeforeParentheses: " + textBeforeParentheses);
		
		if (textBeforeParentheses.equalsIgnoreCase("test004")) {
		System.out.println("Pass: " + textBeforeParentheses);
		} else {
		System.out.println("Fail: " + text1);
		}
		Thread.sleep(1000);
		WebElement textElement2 = driver.findElement(By.xpath("(//div[contains(@class,'marginBottom10 ng-binding')])[1]"));
		String text2 = textElement2.getText();
		System.out.println("Text from element: " + text2);
		String textBeforeParentheses1 = text2.split("\\(")[0].trim();
		System.out.println("textBeforeParentheses: " + textBeforeParentheses1);
		if (textBeforeParentheses1.equalsIgnoreCase("test004")) {
		System.out.println("Pass: " + textBeforeParentheses1);
		} else {
		System.out.println("Fail: " + text2);
		}				
		}
				
		@Test
	    public void SQtest2() throws InterruptedException {
	        driver.get("https://beta.ashidiamonds.com/Product/ProductDetails.aspx?ITEM_ID=17349&ItemType=&PCategoryId=5&CategoryId=5,5&PCategoryName=Bridals");
	        Thread.sleep(10000);
	        scrollPage(100); // Scroll down by 200 pixels
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//span[@class='icon_wishlist WishListIcon DIcon SalesQD']")).click();
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("(//input[@id='CP'])[1]")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("(//input[@id='CP'])[1]")).sendKeys("1234567899");
            Thread.sleep(500);
            driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_txtFriendName'])[1]")).sendKeys("John");
            Thread.sleep(500);
            driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_txtFreindsEmail'])[1]")).sendKeys("avalontest1234@gmail.com");
            Thread.sleep(500);
            driver.findElement(By.xpath("(//textarea[@id='ctl00_ContentPlaceHolder1_txtMsg'])[1]")).sendKeys("This is Test mail, Please ignore this.");
            Thread.sleep(1000);
	        
	        driver.quit();
	    }

	    public void scrollPage(int scrollValue) {
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + scrollValue + ");");
	    }
			
	
}