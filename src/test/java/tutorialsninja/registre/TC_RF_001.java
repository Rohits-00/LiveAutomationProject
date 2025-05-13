package tutorialsninja.registre;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
    
	@Test
     
	public  void VerifyRegistreWithMandatoryField() {
	    WebDriver Driver = new ChromeDriver();
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Driver.manage().window().maximize();
       Driver.get("https://tutorialsninja.com/demo/");
       Driver.findElement(By.xpath("//span[text()='My Account']")).click();
      // Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       Driver.findElement(By.linkText("Register")).click();
      Driver.findElement(By.id("input-firstname")).sendKeys("Rohit");
      Driver.findElement(By.id("input-lastname")).sendKeys("Sathe");
      Driver.findElement(By.id("input-email")).sendKeys(generatenewemail());
      Driver.findElement(By.id("input-telephone")).sendKeys("123456789");
      Driver.findElement(By.id("input-password")).sendKeys("Rohit@12");
      Driver.findElement(By.id("input-confirm")).sendKeys("Rohit@12");
      Driver.findElement(By.cssSelector("input[type='checkbox']")).click();
      Driver.findElement(By.cssSelector("input[type='submit']")).click();
      
      Assert.assertTrue(Driver.findElement(By.linkText("Logout")).isDisplayed());
      String expectedHeading= "Your Account Has Been Created!";
      
      //System.out.println("---------------------------------------------------------------------"+Driver.findElement(By.xpath("//div[@id='common-success']//h1']")).getText());
     Assert.assertEquals(Driver.findElement(By.xpath("//div[@id=\"content\"]//h1[text()=\"Your Account Has Been Created!\"]")).getText(), expectedHeading );
   
     String ActualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
     String ActualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
     String ActualProperDetailThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
     String ActualProperDetailFour = " contact us.";
     
      String ExpectedProperDetail = Driver.findElement(By.id("content")).getText();
     Assert.assertTrue(ExpectedProperDetail.contains(ActualProperDetailsOne));
     Assert.assertTrue(ExpectedProperDetail.contains(ActualProperDetailsTwo));
     Assert.assertTrue(ExpectedProperDetail.contains(ActualProperDetailThree));
     Assert.assertTrue(ExpectedProperDetail.contains(ActualProperDetailFour));
     
     Driver.findElement(By.linkText("Continue")).click();
     
     Assert.assertTrue(Driver.findElement(By.linkText("Edit your account information")).isDisplayed());
     Driver.quit();
     
	}

	 public String generatenewemail() {
     return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
			
	 }
}
