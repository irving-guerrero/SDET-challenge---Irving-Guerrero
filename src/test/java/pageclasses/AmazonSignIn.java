package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * @author Irving_Guerrero
 *
 */
public class AmazonSignIn {
	boolean logToConsol;
	WebDriver driver;
	@FindBy(id = "createAccountSubmit")
	WebElement createAccountBtn;
	@FindBy(name = "customerName")
	WebElement customerName;
	@FindBy(name = "email")
	WebElement customerEmail;
	@FindBy(name = "password")
	WebElement customerPass;
	@FindBy(name = "passwordCheck")
	WebElement customerPassCheck;

	
	public AmazonSignIn(WebDriver driver) {
		this.driver = driver;
		this.logToConsol = true;
		PageFactory.initElements(driver, this);
	}
	/**
	 * THis Method activate or deactivate the consol logs
	 * @param logToConsol
	 * true for displaying logs
	 */
	public void logToConsol(boolean logToConsol) {
		this.logToConsol = logToConsol;
	}
	
	/**
	 * This method will click on the create account button
	 * 
	 */
	public void clickCreateAccount() {
		createAccountBtn.click();
		Reporter.log("Create Account button clicked",logToConsol);
	}
	/**
	 * This method will send the given name to the customerName field
	 * @param name
	 */
	public void fillCustomerName(String name) {
		customerName.sendKeys(name);	
		Reporter.log("Customer name: " + name,logToConsol);
		
	}
	/**
	 * This method will send the given email to the customerEmail field
	 * @param name
	 */
	public void fillEmail(String email) {
		customerEmail.sendKeys(email);
		Reporter.log("Customer email: " + email,logToConsol);
	
	}
	/**
	 * This method will send the given password to the customerpassword field
	 * @param name
	 */
	public void fillPassword(String password) {
		customerPass.sendKeys(password);
		Reporter.log("Customer password: " + password,logToConsol);
	}
	
	/**
	 * This method will send the given password to the Re-entry customerpassword field
	 * @param password
	 */
	public void fillReEnterPassword(String password) {
		customerPassCheck.sendKeys(password);
		Reporter.log("Customer passwordCheck: " + password,logToConsol);
	}
	/**
	 * This method will return if the given text is present in signin page
	 * @param text
	 * @return
	 */
	public boolean isTextPresent(String text) {
		boolean isPResent = driver.getPageSource().contains(text);
		Reporter.log("Is '" + text + "' present?: " + isPResent, logToConsol);
		return isPResent;
	}

}
