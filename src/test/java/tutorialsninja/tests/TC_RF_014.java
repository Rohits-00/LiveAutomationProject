package tutorialsninja.tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import utility.CommonUtils;

public class TC_RF_014 extends BasePage {
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
	public void VerifyMandatoryFieldsSymbolAndColourInRegisterePage() {
		
		String expectedcontent = "\"* \"";
		String expectedcolor="rgb(255, 0, 0)";
		
		WebElement firstNamelabel = driver.findElement(By.cssSelector("label[for=\"input-firstname\"]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String fnContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('Content');",firstNamelabel);
		//System.out.println(fnContent);
		String fnColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('Color');",firstNamelabel);
		//System.out.println(fnColor);
        Assert.assertEquals(fnContent, expectedcontent);
        Assert.assertEquals(fnColor, expectedcolor);
        
        WebElement lastNamelabel = driver.findElement(By.cssSelector("label[for=\"input-lastname\"]"));
		String lnContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('Content');",lastNamelabel);
		String lnColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('Color');",lastNamelabel);
		Assert.assertEquals(lnContent, expectedcontent);
        Assert.assertEquals(lnColor, expectedcolor);
        
	}           

}
