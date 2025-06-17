package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterPage {
 WebDriver driver;
   public NewsLetterPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	   }
   
}
