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

public class TC_RF_025 extends BasePage {
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
	public void VerifyUIofRegisterAccountPage () throws IOException {
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		
		 try {
		FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterUI.png "));
		 }catch (IOException e) {
		e.printStackTrace();
		}
		Assert.assertTrue(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterUI.png ", System.getProperty("user.dir")+"\\Screenshots\\expectedRegisterUI.png "));
		}
}
