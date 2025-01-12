package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}		
	
	//List<WebElement> prodList = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	@FindBy(css="li.totalRow button")
	WebElement submitPageGoto;

	//driver.findElement(By.cssSelector("li.totalRow button")).click();
	
	public Boolean VerifyOrderDisplay(String nombProduct)
	{
		Boolean match = productNames.stream().anyMatch(listprod -> listprod.getText().equalsIgnoreCase(nombProduct));
		return match;
	}

}
