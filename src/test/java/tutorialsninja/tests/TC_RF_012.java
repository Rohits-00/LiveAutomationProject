package tutorialsninja.tests;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import utility.CommonUtils;

public class TC_RF_012 extends BasePage {
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
	public void VerifyingRegisteringAccountUsingKeyboardKeys () {
	Actions action = new Actions(driver);	
	  for (int i = 1; i<=23; i++) {
		action.sendKeys(Keys.TAB).perform();
		}
	  action.sendKeys(prop.getProperty("firstName")).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).sendKeys(prop.getProperty("lastName")).sendKeys(Keys.TAB).sendKeys(CommonUtils.generatenewemail())
		.sendKeys(Keys.TAB).sendKeys(prop.getProperty("phoneNumber")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB)
		.sendKeys(Keys.LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER).build().perform();
	  Assert.assertTrue( driver.findElement(By.xpath("//*[@id=\"column-right\"]//a[text()='Logout']")).isDisplayed());
	 }
}
