package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchExistingProduct;
import testBase.BaseClass;

public class SearchProductTest extends BaseClass 
{

	@Test
	public void test_Exisitng_product() throws InterruptedException 
	{
		logger.info(" Starting SearchProductTest ");
	try
	{
		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed ");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		SearchExistingProduct ep=new SearchExistingProduct(driver);
		ep.search((rb.getString("searchproduct")));
		logger.info("searching product ");
		ep.button();
		logger.info("search button is clicked");
		
		boolean targetproduct=ep.isproductheadingExists();
		if(targetproduct)
			{
				logger.info("Product found ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Product Not found ");
				captureScreen(driver, "test_Product"); //Capturing screenshot
				Assert.assertTrue(false);
			}
	}
		catch(Exception e)
		{
			logger.fatal("Product Not exisitng ");
			Assert.fail();
		}
		
		logger.info(" Finished SearchExisitngProduct Test case ");
		
	
	}
}
