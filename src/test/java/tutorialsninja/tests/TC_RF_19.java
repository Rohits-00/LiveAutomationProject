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

public class TC_RF_19 extends BasePage {
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
	public void VerifyPrivacyPolicyFieldOnRegisterignAccountPage () {
		Assert.assertFalse(driver.findElement(By.name("agree")).isSelected());
		
	}

}
