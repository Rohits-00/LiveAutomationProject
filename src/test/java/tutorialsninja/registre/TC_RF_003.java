package tutorialsninja.registre;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Date;
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

public class TC_RF_003 extends BasePage {
	WebDriver driver;
	Properties prop;
	@BeforeMethod
	public void setup() {
	driver=openBrowserAndApplication();
	prop=CommonUtils.loadproperties();
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
@Test(priority=1)
	    public void VerifyRegistreAccountWithAllFields() {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generatenewemail());
        driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("phoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='Success']")).isDisplayed());
        String expecteddetailone="Your Account Has Been Created!";
        String expecteddetiltwo="Congratulations! Your new account has been successfully created!";
        String expecteddetailthree="You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String expecteddetailfour="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String expecteddetailfive="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
        String expecteddetailsix="contact us";
        String actualdetails =driver.findElement(By.id("content")).getText();
        Assert.assertTrue(actualdetails.contains(expecteddetailone));
        Assert.assertTrue(actualdetails.contains(expecteddetiltwo));
        Assert.assertTrue(actualdetails.contains(expecteddetailthree));
        Assert.assertTrue(actualdetails.contains(expecteddetailfour));
        Assert.assertTrue(actualdetails.contains(expecteddetailfive));
        Assert.assertTrue(actualdetails.contains(expecteddetailsix));
        driver.findElement(By.linkText("Continue")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }
}
