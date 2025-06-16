package tutorialsninja.registre;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import utility.CommonUtils;

public class TC_RF_022 extends BasePage {
	WebDriver driver;
	   Properties prop;
	   @BeforeMethod
	   public void setup() {
		   prop=CommonUtils.loadproperties();
			 driver=openBrowserAndApplication();

		   driver.findElement(By.xpath("//span[text()='My Account']")).click();
	       driver.findElement(By.linkText("Register")).click();
	   }
	   
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
@Test
	public void VerifyWorkingOfEveryLinkOnRegisteringAccountPage () {
		driver.findElement(By.xpath("//i[@class=\"fa fa-phone\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Contact Us']")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.xpath("//span[text()='Wish List (0)']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[@title=\"Shopping Cart\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Shopping Cart']")).isDisplayed());
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@title=\"Checkout\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()=\"Shopping Cart\"]")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[text()=\"Qafox.com\"]")).click();		
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
	    driver.navigate().back();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Account']")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Login']")).isDisplayed());
	    driver.navigate().back();
		  
	    driver.findElement(By.xpath("//a[@class=\"agree\"]")).click();
         	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
         	  WebElement xOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"×\"]")));
         	  Assert.assertTrue(xOption.isDisplayed());
         	 xOption.click();
         	 
         	 driver.findElement(By.xpath("//div[@class=\"list-group\"]/a[text()='Login']")).click();
         	 Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Login']")).isDisplayed());
         	 driver.navigate().back();
         	 
         	 driver.findElement(By.xpath("//a[text()='Forgotten Password']")).click();
         	 Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Forgotten Password']")).isDisplayed());
         	 driver.navigate().back();
         	 
         	 driver.findElement(By.xpath("//a[text()='Address Book']")).click();
         	 Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Account']")).isDisplayed());
         	 driver.navigate().back();
         	 }
}
