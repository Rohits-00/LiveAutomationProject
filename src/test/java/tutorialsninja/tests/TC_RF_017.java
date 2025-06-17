package tutorialsninja.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import utility.CommonUtils;

public class TC_RF_017 extends BasePage {
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
	public void VerifyRegisterAccountFiledHeightandWidth () throws IOException {
		
		String ExpectedHeight="34px";
		String ExpectedWidth="701.25px";
		String actualFirstNameHeight = driver.findElement(By.id("input-firstname")).getCssValue("height");
		String actualFirstNameWidth = driver.findElement(By.id("input-firstname")).getCssValue("width");
		
		Assert.assertEquals(actualFirstNameHeight, ExpectedHeight);
		Assert.assertEquals(actualFirstNameWidth, ExpectedWidth);
		
		String actualLastNameHeight = driver.findElement(By.id("input-lastname")).getCssValue("height");
		String actualLastNameWidth = driver.findElement(By.id("input-lastname")).getCssValue("width");
		
		Assert.assertEquals(actualLastNameHeight, ExpectedHeight);
		Assert.assertEquals(actualLastNameWidth, ExpectedWidth);
		
		String actualEmailNameHeight = driver.findElement(By.id("input-email")).getCssValue("height");
		String actualEmailNameWidth = driver.findElement(By.id("input-email")).getCssValue("width");
		
		Assert.assertEquals(actualEmailNameHeight, ExpectedHeight);
		Assert.assertEquals(actualEmailNameWidth, ExpectedWidth);
		
		String actualTelephoneNameHeight = driver.findElement(By.id("input-telephone")).getCssValue("height");
		String actualTelephoneNameWidth = driver.findElement(By.id("input-telephone")).getCssValue("width");
		
		Assert.assertEquals(actualTelephoneNameHeight, ExpectedHeight);
		Assert.assertEquals(actualTelephoneNameWidth, ExpectedWidth);
		
		String actualPasswordNameHeight = driver.findElement(By.id("input-password")).getCssValue("height");
		String actualPasswordNameWidth = driver.findElement(By.id("input-password")).getCssValue("width");
		
		Assert.assertEquals(actualPasswordNameHeight, ExpectedHeight);
		Assert.assertEquals(actualPasswordNameWidth, ExpectedWidth);
		
		String actualConfirmPasswordNameHeight = driver.findElement(By.id("input-confirm")).getCssValue("height");
		String actualConfirmPasswordNameWidth = driver.findElement(By.id("input-confirm")).getCssValue("width");
		
		Assert.assertEquals(actualConfirmPasswordNameHeight, ExpectedHeight);
		Assert.assertEquals(actualConfirmPasswordNameWidth, ExpectedWidth);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
	    File srcScreenshots = ts.getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(srcScreenshots, new File(System.getProperty("user.dir")+"\\Screenshots\\registerPageActualAllignment.png"));
	    Assert.assertFalse(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\registerPageActualAllignment.png", System.getProperty("user.dir")+"\\Screenshots\\registerPageExpectedAllignment.png"));
	    
	}
}
