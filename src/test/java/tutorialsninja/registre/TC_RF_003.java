package tutorialsninja.registre;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {

		
@Test
	public void VerifyRegistreAccountWithAllFields() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Rohit");
		driver.findElement(By.id("input-lastname")).sendKeys("Sathe");
        driver.findElement(By.id("input-email")).sendKeys(generatenewemail());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("Rohit@12");
        driver.findElement(By.id("input-confirm")).sendKeys("Rohit@12");
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
       driver.quit();
        
        
        
	}

	 public  String generatenewemail() {
	 return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
				
}
}
