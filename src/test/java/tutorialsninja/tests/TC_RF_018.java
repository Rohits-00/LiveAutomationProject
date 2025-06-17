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
import org.testng.asserts.SoftAssert;

import base.BasePage;
import utility.CommonUtils;

public class TC_RF_018 extends BasePage {
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
	public void VerifyLeadinAndTrailingSpacesWhileRegisteringAccount () {
		
		 SoftAssert softAssert = new SoftAssert();
	  String firstNameText="    "+prop.getProperty("firstName")+"     ";
		 driver.findElement(By.id("input-firstname")).sendKeys(firstNameText);
		 String lastNameText="   "+prop.getProperty("lastName")+"   ";
		driver.findElement(By.id("input-lastname")).sendKeys(lastNameText);
		String emailText="      "+CommonUtils.generatenewemail();
		driver.findElement(By.id("input-email")).sendKeys(emailText);
		String telephoneText="   "+prop.getProperty("phoneNumber")+"   ";
		driver.findElement(By.id("input-telephone")).sendKeys(telephoneText);
		String passwordText="   "+prop.getProperty("validPassword")+"   ";
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		String confirmPasswordText="   "+prop.getProperty("validPassword")+"   ";
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPasswordText);
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		driver.findElement(By.xpath("//a[text()='Edit your account information']")).click();
		
		softAssert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("value"), firstNameText.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("value"), lastNameText.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("value"), emailText.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("value"), telephoneText.trim());
		softAssert.assertAll();
	}

}
