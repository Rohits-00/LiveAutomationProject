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

public class TC_RF_024 extends BasePage {
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
	public void VerifyHeadingTitleOfRegisterAccountPage() {
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"content\"]/h1[text()='Register Account']")).isDisplayed());
		
		String ExpectedHeading = "Register Account";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"content\"]/h1[text()='Register Account']")).getText(), ExpectedHeading);
		String ExpectedUrl="https://tutorialsninja.com/demo/index.php?route=account/register";
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedUrl);
		String ExpectedTitle="Register Account";
		Assert.assertEquals(driver.getTitle(), ExpectedTitle);
		}

}
