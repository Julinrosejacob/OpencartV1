package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchExistingProduct {
WebDriver driver;
	
	public SearchExistingProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"search\"]/input")
	WebElement searchbox;
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	WebElement clickbutton;
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")
	WebElement productheading;
	public void search(String searchproduct)
	{
		searchbox.sendKeys(searchproduct);
	}
	public void button()
	{
		clickbutton.click();
	}
	public boolean isproductheadingExists()
	{
		try
		{
		return (productheading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
}
