package tutorialsninja.registre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_009 {
	@Test
	public void VerifyingRegisteringAccountWithExistingEmail() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("rohit");
		driver.findElement(By.id("input-lastname")).sendKeys("sathe");
		driver.findElement(By.id("input-email")).sendKeys("rohitsathe@globussoft.in");
		driver.findElement(By.id("input-telephone")).sendKeys("123984858");
		driver.findElement(By.id("input-password")).sendKeys("rohit12");
		driver.findElement(By.id("input-confirm")).sendKeys("rohit12");
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		String expectedwarningmessage="Warning: E-Mail Address is already registered!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(), expectedwarningmessage);
		driver.quit();
		
		
		
	}

}
