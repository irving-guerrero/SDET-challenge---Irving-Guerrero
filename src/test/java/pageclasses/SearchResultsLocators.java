package pageclasses;

/**
 * @author IRving_Guerrero
 * Search Result Page Locators
 *
 */
public interface SearchResultsLocators {
	String baseItemLinkXpath = 
			"//div[@class = 's-result-list s-search-results sg-row'] //div[@data-index = {INDEX}]//div[@class = 'a-section a-spacing-none']//h2";
	String baseItemPriceXpathNormal = 
			"//div[@class = 's-result-list s-search-results sg-row'] //div[@data-index = {INDEX}]//div[@class='a-section a-spacing-none a-spacing-top-mini']//span[2]";
	String baseItemPriceXpathOffer = 
			"//div[@class='s-result-list s-search-results sg-row']//div[@data-index = {INDEX}]//span[@class = 'a-price']";


}
