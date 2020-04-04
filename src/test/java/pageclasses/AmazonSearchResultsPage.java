package pageclasses;

import java.util.ArrayList;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * @author Irving_Guerrero
 *
 */
public class AmazonSearchResultsPage extends AmazonMainPage implements SearchResultsLocators{
	/**
	 * Constructor to initialize the object
	 * @param driver
	 */
	public AmazonSearchResultsPage(WebDriver driver) {
		super(driver);
		super.logToConsol =true;
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method will return the price of an item in result page
	 * @param itemIndex
	 * @return
	 * Price of the item
	 */
	public String getPriceFromItem(String itemIndex) {
		//String itemXpathFromList = baseXpathResultList.replace("{INDEX}", itemIndex);
		//String itemXpathFromList = getFinalXpath(itemIndex);
		String price;
		try {
			price = super.getDriver().findElement(By.xpath(getFinalXpath(itemIndex,baseItemPriceXpathOffer))).getText().trim();
			price = price.replace("\n", ".");
			Reporter.log("Trying to get price when offer price: " + price,super.logToConsol);
			return price;
			
			
		} catch (Exception e) {
			Reporter.log("FAILED to get price from offer price",true);
			try {
				price = super.getDriver().findElement(By.xpath(getFinalXpath(itemIndex,baseItemPriceXpathNormal))).getText();
				Reporter.log("Trying to get price when normal price: " + price,super.logToConsol);
				return price;
				
			} catch (Exception e2) {
				Reporter.log(e.getMessage(),super.logToConsol);
				return "";

			}
		}
		

	}

	/**
	 * This method will click on an item in search result
	 * @param itemIndex
	 */
	public void clickOnItem(String itemIndex) {
		super.getDriver().findElement(By.xpath(getFinalXpath(itemIndex,baseItemLinkXpath))).click();
		Reporter.log("Click on item with index: " + itemIndex,true);
		
	}
	
	
	/**
	 * This method will return the final xpath after replacing the index in the base xpath
	 * @param itemIndex
	 * @param baseXpath
	 * @return
	 */
	private String getFinalXpath(String itemIndex, String baseXpath) {
		String finalXpath = baseXpath.replace("{INDEX}", "'"+itemIndex+"'");
		Reporter.log("FinalXpath: " + finalXpath,true);
		return finalXpath;
		
	}
	

}
