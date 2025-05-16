package tutorialsninja.registre;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_005 {
@Test

	public  void VerifyingRegisteringAccountBySubscribingToNewLetter() {
		WebDriver driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://tutorialsninja.com/demo/");
       driver.findElement(By.xpath("//span[text()='My Account']")).click();
       driver.findElement(By.linkText("Register")).click();
      driver.findElement(By.id("input-firstname")).sendKeys("rohit");
      driver.findElement(By.id("input-lastname")).sendKeys("sathe");
      driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
      driver.findElement(By.id("input-telephone")).sendKeys("12345678");
      driver.findElement(By.id("input-password")).sendKeys("rohit12");
      driver.findElement(By.id("input-confirm")).sendKeys("rohit12");
      driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
      driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
      driver.findElement(By.cssSelector("input[value=\"Continue\"]")).click();
      driver.findElement(By.linkText("Continue")).click();
      driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
     // driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
      
      Assert.assertTrue(driver.findElement(By.linkText("Newsletter")).isDisplayed());
      Assert.assertTrue(driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).isSelected());
      driver.quit();
      
      

	}
      public String generateNewEmail() {
    	  
    	  return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
    	  
    	
    	  
      }
      }

