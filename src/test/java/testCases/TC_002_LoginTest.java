package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginTest;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass 
	
	{
		@Test(groups={"sanity","master"})
		public void test_login_Page() throws InterruptedException 
		{
			logger.info(" Starting TC_001_RegistrationPage ");
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			Thread.sleep(5000);
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			hp.clickLogin();
			logger.info("Clicked on Login ");
			
            LoginTest lp=new LoginTest(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("Provided Email ");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password ");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
			Thread.sleep(8000);
			
			
			boolean targetpage=lp.isMyAccountPageExists();
			
			if(targetpage)
			{
				logger.info("Login Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed ");
				captureScreen(driver, "test_Login"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		}	
		catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_Login ");
		}
}
