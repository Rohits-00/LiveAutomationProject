package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNamefiled;
	
	@FindBy(id="input-email")
	private WebElement emailFiled;
	
	@FindBy(id="input-telephone")
	private WebElement telePhoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(css = "input[type='checkbox']")
	private WebElement privacyPolicyField;
	
	@FindBy(css = "input[type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[text()=\"First Name must be between 1 and 32 characters!\"]")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//input[@id=\"input-lastname\"]/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//input[@id=\"input-email\"]/following-sibling::div")
	private WebElement emailWarningMessage;
	
	
	@FindBy(xpath = "//input[@id=\"input-telephone\"]/following-sibling::div")
	private WebElement phoneNumberWarningMessage;
	
	@FindBy(xpath = "//input[@id=\"input-password\"]/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	@FindBy(xpath = "//div[text()='Warning: You must agree to the Privacy Policy!']")
	private WebElement privacyPolicyWarningMessage;
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNamefiled.sendKeys(lastNameText);
	}
	public void enterEmail(String emailText) {
		emailFiled.sendKeys(emailText);
	}
	public void enterPhoneNumber(String phoneNumberText) {
		telePhoneField.sendKeys(phoneNumberText);
     }
    public void enterPassword(String passwordText) {
    	passwordField.sendKeys(passwordText);
    }
    public void enterConfirmPassword(String confirmPasswordText) {
    	confirmPasswordField.sendKeys(confirmPasswordText);
    }
    public void selectPrivacyPolicy() {
    	privacyPolicyField.click();
    }
    public AccountSuccessPage clickContinueButton() {
    	continueButton.click();
    	return new AccountSuccessPage(driver);
    }
    public String getFirstNameWarning() {
      return firstNameWarningMessage.getText();
    }
    public String getLastNameaWarning() {
    	return lastNameWarningMessage.getText();
    }
    public String getEmailWarning() {
    	return emailWarningMessage.getText();
    }
    public String getPhoneNumberWarning() {
    	return phoneNumberWarningMessage.getText();
    }
    public String getPasswordWarning() {
    	return passwordWarningMessage.getText();
    }
    public String getPrivacyPolicyWarning() {
    	return privacyPolicyWarningMessage.getText();
    }
}
