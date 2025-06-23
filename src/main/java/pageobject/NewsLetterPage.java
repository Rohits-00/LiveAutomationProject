package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterPage {
 WebDriver driver;
   public NewsLetterPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	   }
   
   @FindBy(linkText = "Newsletter")
   private WebElement newsletterBreadcrumb;
   
   @FindBy(xpath = "//input[@name=\"newsletter\"][@value='1']")         
   private WebElement yesNewsletterOption;
   
   @FindBy(xpath = "//input[@type=\"radio\"][@value='0']")
   private WebElement noNewsletterOption;
   
   public boolean didWeNavigateToNewsletterBreadCrumb() {
	   return newsletterBreadcrumb.isDisplayed();
   }
	   public boolean isYesNewsletterOptionSelected() {
		   return yesNewsletterOption.isSelected();
	   
   }
	   public boolean isNoNewsletterOptionSelected() {
		   return noNewsletterOption.isSelected();
	   }
   }
