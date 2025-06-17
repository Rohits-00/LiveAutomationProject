package tutorialsninja.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import utility.CommonUtils;

public class TC_RF_016 extends BasePage {
	
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
	@Test (dataProvider = "passwordsupplier")
	public void VerifyPasswordComplexityStandards (String passwordtext) {
		
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generatenewemail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("phoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(passwordtext);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordtext);
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String expectedWarningMessage="Password entered is not matching the password complexity";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-password\"]/following-sibling::div")).getText(), expectedWarningMessage);
		}
	    @DataProvider(name="passwordsupplier")
	    public Object [][] supplypasswords () {
		Object [][] data= {{"1234"},{"abv"},{"asf@"},};
		return data;
		}
	}


