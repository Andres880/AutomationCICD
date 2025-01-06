package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class checkoutPage extends AbstractComponent{

	WebDriver driver;
	
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(css= "input[placeholder*='Country']")
	WebElement country;
	
	@FindBy(css = "(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	@FindBy(css = "div.actions a")
	WebElement submitAction;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement SubmitPlaceOrder;
	
	By sectionResult = By.cssSelector("section.ta-results");
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(sectionResult);
		SubmitPlaceOrder.click();
	}
	
	public ConfirmationPage submitOrder()
	{
		submitAction.click();
		return new ConfirmationPage(driver);
	}
	
}	
