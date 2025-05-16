package tutorialsninja.registre;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_011 {
	
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
	
	public void VerifyRegisteringAccountByProvidingInvalidPhoneNumber () {
		
	     driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.cssSelector("input[id=\"input-firstname\"]")).sendKeys("rohit");
		driver.findElement(By.cssSelector("input[id=\"input-lastname\"]")).sendKeys("sathe");
		driver.findElement(By.cssSelector("input[id=\"input-email\"]")).sendKeys(newemailgenerate ());
		driver.findElement(By.cssSelector("input[id=\"input-telephone\"]")).sendKeys("abcd");
		driver.findElement(By.cssSelector("input[id=\"input-password\"]")).sendKeys("rohit");
		driver.findElement(By.cssSelector("input[id=\"input-confirm\"]")).sendKeys("rohit");
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		 String expectedwarningmessage = "Telephone number does not appear to be valid";
		 Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-telephone\"]/following-sibling::div")).getText(), expectedwarningmessage);
		driver.quit();
		 
	}
	
	public String newemailgenerate () {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		
		
	}

}
