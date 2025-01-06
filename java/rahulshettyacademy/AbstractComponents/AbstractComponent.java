package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement submitCartHeader;
	
	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	By submitCartHead = By.cssSelector("button[routerlink='/dashboard/cart']");

	public void waitForElementToAppear(By findBy )
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToAppear(WebElement findBy) throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDesappear(WebElement element) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage subCartHeader() throws InterruptedException
	{
		waitForElementToAppear(submitCartHead);
		submitCartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
}
