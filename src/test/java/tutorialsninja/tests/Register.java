package tutorialsninja.tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pageobject.AccountPage;
import pageobject.AccountSuccessPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.NewsLetterPage;
import pageobject.RegisterPage;
import utility.CommonUtils;

public class Register extends BasePage{
	   WebDriver driver;
	   Properties prop;
	   HomePage homePage;
	   RegisterPage registerPage;
	   AccountSuccessPage accountSuccessPage;
	   AccountPage accountpage; 
	   NewsLetterPage newsletterPage;
	   LoginPage loginPage;
	   
	   @BeforeMethod
	   public void setup() {
		   driver= openBrowserAndApplication(); 
		 prop = CommonUtils.loadproperties();
		homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
	   registerPage = homePage.clickOnRegister();
	   }
	  
	   @AfterMethod
	   public void teardown() {
		if(driver !=null)
			driver.quit();
	}
	@Test(priority = 1)
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

	
	
	   @Test(priority = 2)
       public void VerifyRegistreAccountWithAllFields() {
	   registerPage.enterFirstName(prop.getProperty("firstName"));
	   registerPage.enterLastName(prop.getProperty("lastName"));
	   registerPage.enterEmail(CommonUtils.generatenewemail());
       registerPage.enterPhoneNumber(prop.getProperty("phoneNumber"));
       registerPage.enterPassword(prop.getProperty("validPassword"));
       registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
       registerPage.selectPrivacyPolicy();
       accountSuccessPage =registerPage.clickContinueButton();
       Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
       Assert.assertTrue(accountSuccessPage.didWeNavigateToAccountSuccessPage());
    
       String expecteddetailone="Your Account Has Been Created!";
       String expecteddetiltwo="Congratulations! Your new account has been successfully created!";
       String expecteddetailthree="You can now take advantage of member privileges to enhance your online shopping experience with us.";
       String expecteddetailfour="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
       String expecteddetailfive="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
       String expecteddetailsix="contact us";
    
       String actualdetails =accountSuccessPage.getPageContent();
       Assert.assertTrue(actualdetails.contains(expecteddetailone));
       Assert.assertTrue(actualdetails.contains(expecteddetiltwo));
       Assert.assertTrue(actualdetails.contains(expecteddetailthree));
       Assert.assertTrue(actualdetails.contains(expecteddetailfour));
       Assert.assertTrue(actualdetails.contains(expecteddetailfive));
       Assert.assertTrue(actualdetails.contains(expecteddetailsix));
       accountpage=accountSuccessPage.clickOnContinueButton();
       Assert.assertTrue(accountpage.didWeNavigateToAccountpage());
 }
	
	   
	    @Test(priority = 3)
	    public  void VerifyAccountFieldWithoutMandatoryField() {  
		
	    	
       registerPage.clickContinueButton();
		
		String expectedFristNameWarning="First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning="Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning="E-Mail Address does not appear to be valid!";
		String expectedTellPhoneWarning="Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning="Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarning="Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(registerPage.getFirstNameWarning(), expectedFristNameWarning);
		Assert.assertEquals(registerPage.getLastNameaWarning(), expectedLastNameWarning);
		Assert.assertEquals(registerPage.getEmailWarning(),expectedEmailWarning);
		Assert.assertEquals(registerPage.getPhoneNumberWarning() , expectedTellPhoneWarning);
		Assert.assertEquals(registerPage.getPasswordWarning() ,expectedPasswordWarning);
		Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), expectedPrivacyPolicyWarning);
        }
	    
	    @Test(priority = 4)
	    public  void VerifyingRegisteringAccountBySubscribingToNewLetter() {
	    registerPage.enterFirstName(prop.getProperty("firstName"));
	    registerPage.enterLastName(prop.getProperty("lastName"));	
	    registerPage.enterEmail(CommonUtils.generatenewemail()); 
	    registerPage.enterPhoneNumber(prop.getProperty("phoneNumber"));  
	    registerPage.enterPassword(prop.getProperty("validPassword"));  
	    registerPage.enterConfirmPassword(prop.getProperty("validPassword"));  
	    registerPage.selectPrivacyPolicy();
	    accountSuccessPage=registerPage.clickContinueButton();
	    accountpage= accountSuccessPage.clickOnContinueButton();
	    // driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
	    newsletterPage = accountpage.selectSubscribeUnsubscribeNewsletterOption();
	    //driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
	    Assert.assertTrue(newsletterPage.didWeNavigateToNewsletterBreadCrumb());
	    Assert.assertTrue(newsletterPage.isYesNewsletterOptionSelected());
}
	    
	    @Test(priority = 5)
		public  void VerifyRegistretingAccountBySayingNoToNewletter () {
	    	
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generatenewemail());
		registerPage.enterPhoneNumber(prop.getProperty("phoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
	    registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
	    registerPage.selectYesNewsletterOption();
		registerPage.selectPrivacyPolicy();
	    accountSuccessPage= registerPage.clickContinueButton();
		accountpage=accountSuccessPage.clickOnContinueButton();
		newsletterPage=accountpage.selectSubscribeUnsubscribeNewsletterOption();
	    Assert.assertTrue(newsletterPage.didWeNavigateToNewsletterBreadCrumb());
		Assert.assertFalse(newsletterPage.isNoNewsletterOptionSelected());
}
	    
	    @Test(priority = 6)            
		public  void VerifyNavigationToRegisterAccountBusingMultipleWays() {   
	    	
	   
			Assert.assertTrue(registerPage.didWeNagigateToRegisterAccountPage());
			registerPage.clickOnMyAccountDropMenu();
	        loginPage = registerPage.selectloginOption();
			loginPage.clickOnContinueButton();
		    Assert.assertTrue(registerPage.didWeNagigateToRegisterAccountPage());
		    registerPage.clickOnMyAccountDropMenu();
	        loginPage = registerPage.selectloginOption();
		    loginPage.clickOnRegisterOption();
		     Assert.assertTrue(registerPage.didWeNagigateToRegisterAccountPage());
}
	    @Test(priority = 7)
		public  void VerifyRegisteringAccountByProvidingMissMatchPassword() throws InterruptedException {
		
	    	registerPage.enterFirstName(prop.getProperty("firstName"));
			registerPage.enterLastName(prop.getProperty("lastName"));
			registerPage.enterEmail(CommonUtils.generatenewemail());
			registerPage.enterPhoneNumber(prop.getProperty("phoneNumber"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("massMatchPassword"));			
			registerPage.selectYesNewsletterOption();
			registerPage.selectPrivacyPolicy();
			registerPage.clickContinueButton();
            String expectedwarningmessage="Password confirmation does not match password!";
		    Assert.assertEquals(registerPage.getPasswordConfirmWarring(), expectedwarningmessage);
	    }
	    
	    @Test(priority = 8)
		public void VerifyingRegisteringAccountWithExistingEmail() {
	    	registerPage.enterFirstName(prop.getProperty("firstName"));
	    	registerPage.enterLastName(prop.getProperty("lastName"));
			registerPage.enterEmail(prop.getProperty("existingemail"));
		    registerPage.enterPhoneNumber(prop.getProperty("phoneNumber"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
		    registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		    registerPage.selectYesNewsletterOption();
			registerPage.selectPrivacyPolicy();
		    registerPage.clickContinueButton();	
			String expectedwarningmessage="Warning: E-Mail Address is already registered!";
			Assert.assertEquals(registerPage.getExistingEmailWarning(), expectedwarningmessage);
}
	    @Test(priority = 9)
	    public void VerifyRegisteringAccountByProvidingInvalidPhoneNumber () {
			registerPage.enterFirstName(prop.getProperty("firstName"));
			registerPage.enterLastName(prop.getProperty("lastName"));
			registerPage.enterEmail(CommonUtils.generatenewemail());
			registerPage.enterPhoneNumber(prop.getProperty("invalidNumber"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			registerPage.selectYesNewsletterOption();
			registerPage.selectPrivacyPolicy();
		    registerPage.clickContinueButton();	
			String expectedwarningmessage = "Telephone number does not appear to be valid";
			Assert.assertEquals(registerPage.getPhoneNumberWarning(), expectedwarningmessage);
} 
	    @Test(priority = 10)
		public void VerifyingRegisteringAccountUsingKeyboardKeys () {
		Actions action = new Actions(driver);	
		  for (int i = 1; i<=23; i++) {
			action.sendKeys(Keys.TAB).perform();
			}
		  action.sendKeys(prop.getProperty("firstName")).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).sendKeys(prop.getProperty("lastName")).sendKeys(Keys.TAB).sendKeys(CommonUtils.generatenewemail())
			.sendKeys(Keys.TAB).sendKeys(prop.getProperty("phoneNumber")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB)
			.sendKeys(Keys.LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
			.sendKeys(Keys.ENTER).build().perform();
		  Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
	    
}
	    @Test(priority = 11)
		public void VerifyPlaceHoldersOfTextfiledInRegisterAccountField () {
			
			String expectedfirstnameplaceholdertext = "First Name";
			
			Assert.assertEquals(registerPage.getPlaceHolderTextFromFirstNameFiled(), expectedfirstnameplaceholdertext);
			String expectedlastnameplaceholdertext = "Last Name";
			Assert.assertEquals(registerPage.getPlaceHolderTextFromLastNameFiled(), expectedlastnameplaceholdertext);
			String expectedemailplaceholdertext="E-Mail";
			Assert.assertEquals(registerPage.getPlaceHolderTextFromEmailFiled(), expectedemailplaceholdertext);
			String expectedtelephoneplaceholdertext="Telephone";
			Assert.assertEquals(registerPage.getPlaceHolderTextFromPhonenumberField(), expectedtelephoneplaceholdertext);
			String expectedpasswordplaceholdertextfield="Password";
			Assert.assertEquals(registerPage.getPlaceHolderTextFromPasswordField(), expectedpasswordplaceholdertextfield);
			String expectedconfirmpasswordplaceholdertext="Password Confirm";
			Assert.assertEquals(registerPage.getPlaceHolderTextFromConfirmPasswordFiled(), expectedconfirmpasswordplaceholdertext);
}
}
