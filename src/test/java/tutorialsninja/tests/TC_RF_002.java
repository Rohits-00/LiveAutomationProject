package tutorialsninja.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_002 {

	public static void main(String[] args) {
		 WebDriver Driver= new ChromeDriver();
		 Driver.manage().window().maximize();
		 Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 Driver.get("https://www.amazon.in/");
		 Driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
		 }

}
