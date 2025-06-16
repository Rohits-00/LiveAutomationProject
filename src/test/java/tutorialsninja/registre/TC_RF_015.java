package tutorialsninja.registre;

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

public class TC_RF_015 extends BasePage{
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
	public void VerifyRegisteringAccountWithOnlySpaces () {
		driver.findElement(By.id("input-firstname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-telephone")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.id("input-confirm")).sendKeys(" ");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedFristNameWarning="First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning="Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning="E-Mail Address does not appear to be valid!";
		String expectedTellPhoneWarning="Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning="Password must be between 4 and 20 characters!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"firstname\"]/following-sibling::div")).getText(), expectedFristNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-lastname\"]/following-sibling::div")).getText(), expectedLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-email\"]/following-sibling::div")).getText(), expectedEmailWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-telephone\"]/following-sibling::div")).getText(), expectedTellPhoneWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-password\"]/following-sibling::div")).getText(), expectedPasswordWarning);
		
	}
}
