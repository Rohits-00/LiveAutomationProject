package tutorialsninja.registre;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_008 {

	@Test
	public  void VerifyRegisteringAccountByProvidingMissMatchPassword() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("rohit");
		driver.findElement(By.id("input-lastname")).sendKeys("sathe");
		
		driver.findElement(By.id("input-email")).sendKeys(generatenewemail());
		
		driver.findElement(By.id("input-telephone")).sendKeys("234098776");
		driver.findElement(By.id("input-password")).sendKeys("rohit123");
		driver.findElement(By.id("input-confirm")).sendKeys("rohit12");
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
	    String expectedwarningmessage="Password confirmation does not match password!";
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-confirm\"]/following-sibling::div")).getText(), expectedwarningmessage);
	    Thread.sleep(3000);
	 driver.quit();
	    
	    }

	 public String generatenewemail() {
		 return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		 
		
	 }
}
