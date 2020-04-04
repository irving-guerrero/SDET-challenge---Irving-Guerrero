package pageclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * @author Irving_Guerrero
 *
 */
public class AmazonMainPage {
	String BASE_URL = "https://www.amazon.com/";
	WebDriver driver;
	boolean logToConsol;
	

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchtextbox;
	@FindBy(xpath = "//input[@value='Go']")
	WebElement searchbutton;
	@FindBy(xpath = "//div[@id=\"nav-tools\"]//a[@data-nav-role]")
	WebElement yourAmazon;


	public AmazonMainPage(WebDriver driver) {
		this.driver = driver;
		this.logToConsol = true;
		PageFactory.initElements(driver, this);
	}
	/**
	 * THis Method activate or desactivate the consol logs
	 * @param logToConsol
	 * true for displaying logs
	 */
	public void logToConsol(boolean logToConsol) {
		this.logToConsol = logToConsol;
	}
	/**
	 * THis method will click on your Amazon button
	 */
	public void clickYourAmazon() {
		yourAmazon.click();
	}
	
	/**
	 * This method will open the amazon main page
	 */
	public void goToMainPage() {
		driver.get(BASE_URL);
		Reporter.log("Navigate to:" + BASE_URL, logToConsol);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will return the current driver of the class
	 * @return
	 * webDriver
	 */
	public WebDriver getDriver() {
		return driver;
		
	}
	/**
	 * This method will search the given criteria
	 * @param searchString
	 * Element to be searched
	 */
	public void search(String searchString) {
		searchtextbox.sendKeys(searchString);
		searchbutton.click();
		Reporter.log("Searching for: " + searchString,logToConsol);
	}
	


}
