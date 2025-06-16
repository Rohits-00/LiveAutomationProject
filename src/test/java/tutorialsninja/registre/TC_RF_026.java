package tutorialsninja.registre;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import utility.CommonUtils;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
public class TC_RF_026 extends BasePage {
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
	public void VerifyRegisterAccountInDifferentBrowser () {
		
	   driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
	  driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
	  driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generatenewemail());
	  driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("phoneNumber"));
	  driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	  driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
	  driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	  driver.findElement(By.cssSelector("input[type='submit']")).click();
     
     Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
     driver.findElement(By.xpath("//a[text()='Continue']")).click();
     Assert.assertEquals(driver.getTitle(), "My Account");
	  		
		}
	
	
	}
		
	
	  
	

