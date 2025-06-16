package tutorialsninja.registre;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pageobject.AccountPage;
import pageobject.AccountSuccessPage;
import pageobject.HomePage;
import pageobject.RegisterPage;
import utility.CommonUtils;

public class TC_RF_001 extends BasePage{
	   WebDriver Driver;
	   Properties prop;
	   HomePage homePage;
	   RegisterPage registerPage;
	   AccountSuccessPage accountSuccessPage;
	   AccountPage accountpage; 
	   
	   @BeforeMethod
	   public void setup() {
		  Driver= openBrowserAndApplication(); 
		 prop = CommonUtils.loadproperties();
		homePage=new HomePage(Driver);
		homePage.clickOnMyAccount();
	   registerPage = homePage.clickOnRegister();
	   }
	  
	   @AfterMethod
	   public void teardown() {
		if(Driver !=null)
		Driver.quit();
	}
	@Test
     public  void VerifyRegistreWithMandatoryField() {
	  
	 registerPage.enterFirstName(prop.getProperty("firstName"));
	 registerPage.enterLastName(prop.getProperty("lastName"));
     registerPage.enterEmail(CommonUtils.generatenewemail());
     registerPage.enterPhoneNumber(prop.getProperty("phoneNumber"));
     registerPage.enterPassword(prop.getProperty("validPassword"));
     registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
     registerPage.selectPrivacyPolicy();
     accountSuccessPage = registerPage.clickContinueButton();
     Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
     String expectedHeading= "Your Account Has Been Created!";
      
     
     //System.out.println("---------------------------------------------------------------------"+Driver.findElement(By.xpath("//div[@id='common-success']//h1']")).getText());
      
     Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading );
     String expectedProperDetailsOne = "Congratulations! Your new account has been successfully created!";
     String expectedProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
     String expectedProperDetailThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
     String expectedProperDetailFour = " contact us.";
     String actualProperDetail = accountSuccessPage.getPageContent();
     Assert.assertTrue(actualProperDetail.contains(expectedProperDetailsOne));
     Assert.assertTrue(actualProperDetail.contains(expectedProperDetailsTwo));
     Assert.assertTrue(actualProperDetail.contains(expectedProperDetailThree));
     Assert.assertTrue(actualProperDetail.contains(expectedProperDetailFour));
     accountpage = accountSuccessPage.clickOnContinueButton();
     Assert.assertTrue(accountpage.didWeNavigateToAccountpage());
    }
 }

