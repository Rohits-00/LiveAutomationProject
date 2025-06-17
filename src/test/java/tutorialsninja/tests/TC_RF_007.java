package tutorialsninja.tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import utility.CommonUtils;

public class TC_RF_007 extends BasePage {
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
	public  void VerifyNavigationToRegisterAccountBusingMultipleWays() {
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class=\"list-group-item\"][text()='Register']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
     }
}
