package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * @author Irving_Guerrero
 *
 */
public class AmazonDetailsPage extends AmazonMainPage{
	
	@FindBy(xpath = "//span[@id='priceblock_ourprice']")
	WebElement detailsPrice;
	
	@FindBy(id = "add-to-cart-button")
	WebElement addToCart;
	

	/**
	 * The constructor will initialize the object factory
	 * @param driver
	 */
	public AmazonDetailsPage(WebDriver driver) {
		super(driver);
		super.logToConsol =true;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method will return the price of a product in the details page
	 * @return
	 * returns the item price
	 */
	public String getPrice() {
		String price;
		try {
			price = detailsPrice.getText();
			Reporter.log("Trying to get price in Details page: " + price,super.logToConsol);
			return price;
			
		} catch (Exception e) {
			Reporter.log(e.getMessage(),super.logToConsol);
			return "";
			// TODO: handle exception
		}
	}
	/**
	 * This methos will click on "Add to cart" button
	 */
	public void clickAddToCart() {
		addToCart.click();
		
	}

}
