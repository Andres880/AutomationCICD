package rahulshettyacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombProduct = "IPHONE 13 PRO";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Codigo para espera de 10 segundos y así poder ingresar al navegador con la URL descrita en el codigo
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		LandingPage landing = new LandingPage(driver);
		landing.landingPage("correo@gmail.com", "Camilo.880*");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> prodList = driver.findElements(By.cssSelector(".mb-3"));
	WebElement producto = prodList.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
	
	producto.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));	
	
	driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	
	List<WebElement> nombListProd = driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match = nombListProd.stream().anyMatch(listprod -> listprod.getText().equalsIgnoreCase(nombProduct));
	
	Assert.assertTrue(match);
	
	driver.findElement(By.cssSelector("li.totalRow button")).click();
	
	Actions a = new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Country']")), "india").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.ta-results")));
	
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	
	//Click al botón
	driver.findElement(By.cssSelector("div.actions a")).click();
	
	String respuesta = driver.findElement(By.cssSelector("h1.hero-primary")).getText();
	Assert.assertTrue(respuesta.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	
	}
 
}
