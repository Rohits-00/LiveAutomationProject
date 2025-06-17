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

public class TC_RF_013 extends BasePage {
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
	public void VerifyPlaceHoldersOfTextfiledInRegisterAccountField () {
		
		String expectedfirstnameplaceholdertext = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("placeholder"), expectedfirstnameplaceholdertext);
		String expectedlastnameplaceholdertext = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("placeholder"), expectedlastnameplaceholdertext);
		String expectedemailplaceholdertext="E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("placeholder"), expectedemailplaceholdertext);
		String expectedtelephoneplaceholdertext="Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("placeholder"), expectedtelephoneplaceholdertext);
		String expectedpasswordplaceholdertextfield="Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getDomAttribute("placeholder"), expectedpasswordplaceholdertextfield);
		String expectedconfirmpasswordplaceholdertext="Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getDomAttribute("placeholder"), expectedconfirmpasswordplaceholdertext);
		
	}

}
