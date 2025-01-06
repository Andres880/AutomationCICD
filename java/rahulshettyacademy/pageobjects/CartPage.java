package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}		
	
	//List<WebElement> prodList = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".cartSection h3")
	List<WebElement> nombListProd;
	
	@FindBy(css="li.totalRow button")
	WebElement submitPageGoto;

	//driver.findElement(By.cssSelector("li.totalRow button")).click();
	
	public Boolean VerifyProductDisplay(String nombProduct)
	{
		Boolean match = nombListProd.stream().anyMatch(listprod -> listprod.getText().equalsIgnoreCase(nombProduct));
		return match;
	}
	
	public checkoutPage checkgoTo()
	{
		submitPageGoto.click();
		return new checkoutPage(driver);
	}
}
