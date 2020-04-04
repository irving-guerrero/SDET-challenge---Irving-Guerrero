package testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTestSuit;
import pageclasses.AmazonDetailsPage;
import pageclasses.AmazonMainPage;
import pageclasses.AmazonSearchResultsPage;
import pageclasses.AmazonSignIn;

public class AmazonTest extends BaseTestSuit{
	private WebDriver driver;
	AmazonMainPage amazonMainPage;
	AmazonSearchResultsPage searchResultPgae;
	AmazonDetailsPage detailsPage;
	AmazonSignIn signInPage;


	@BeforeClass
	@Parameters({ "browser" })
	public void beforeClass(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.firefox.driver",".\\.\\.\\src\\drivers\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",".\\.\\.\\src\\drivers\\\\chromedriver.exe");
					//"C:\\Users\\devno\\Documents\\JAva jars\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		amazonMainPage = new AmazonMainPage(driver);
		searchResultPgae = new AmazonSearchResultsPage(driver);
		detailsPage = new AmazonDetailsPage(driver);
		signInPage = new AmazonSignIn(driver);

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		
	}
	@Test(priority = 0)
	public void searchItemAndAddToCart() {
		//Go to Amazon.com
		amazonMainPage.goToMainPage();
		
		//Search for Samsung Galaxy S9 
		String searchString = "huawei p30 pro";
		amazonMainPage.search(searchString);

		//store the price of first element in results
		String itemPriceSearchResult;
		String elementIndex = "0";
		itemPriceSearchResult = searchResultPgae.getPriceFromItem(elementIndex).trim();

		//Click on the First Result
		searchResultPgae.clickOnItem(elementIndex);
		
		//Once in the details page compare this price vs the above one
		String itemPriceInDetails;
		itemPriceInDetails = detailsPage.getPrice();
		Assert.assertEquals(itemPriceSearchResult, itemPriceInDetails);
		
		//Click on Add to Cart. 
		detailsPage.clickAddToCart();
		
		
	}

	@Test(priority = 1)
	@Parameters({ "customerName","customerEmail","customerPassword" })
	public void createAccount(String customerName, String customerEmail, String customerPassword) {

		//Go to Amazon main page
		amazonMainPage.goToMainPage();
		
		//Click on "Your Amazon.com" button
		amazonMainPage.clickYourAmazon();
		
		//Click on "Create Your Amazon Account"
		signInPage.clickCreateAccount();
		
		//Fill all the fields
		//NAme
		signInPage.fillCustomerName(customerName);
		//Email
		signInPage.fillEmail(customerEmail);
		//Password
		signInPage.fillPassword(customerPassword);
		//Re-Enter password
		signInPage.fillReEnterPassword(customerPassword);
		
		//Validate that the text is preset: "Create account"
		String text = "Create account";
		Assert.assertTrue(signInPage.isTextPresent(text));
	}
}
