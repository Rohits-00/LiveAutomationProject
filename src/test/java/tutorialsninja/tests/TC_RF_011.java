package tutorialsninja.tests;

import java.time.Duration;
import java.util.Date;
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

public class TC_RF_011 extends BasePage{
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
    public void VerifyRegisteringAccountByProvidingInvalidPhoneNumber () {
		
		driver.findElement(By.cssSelector("input[id=\"input-firstname\"]")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.cssSelector("input[id=\"input-lastname\"]")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.cssSelector("input[id=\"input-email\"]")).sendKeys(CommonUtils.generatenewemail());
		driver.findElement(By.cssSelector("input[id=\"input-telephone\"]")).sendKeys(prop.getProperty("invalidNumber"));
		driver.findElement(By.cssSelector("input[id=\"input-password\"]")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.cssSelector("input[id=\"input-confirm\"]")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		String expectedwarningmessage = "Telephone number does not appear to be valid";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-telephone\"]/following-sibling::div")).getText(), expectedwarningmessage);

		}
	}
