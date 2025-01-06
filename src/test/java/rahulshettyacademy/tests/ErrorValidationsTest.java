package rahulshettyacademy.tests;


import rahulshettyacademy.TestComponents.BaseTests;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class ErrorValidationsTest extends BaseTests {
	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws  IOException, InterruptedException {
		// TODO Auto-generated method stub
		String nombProduct = "IPHONE 13 PRO";
		
		landing.landingPage("correo@gmail.com", "Camilo88*");
		Assert.assertEquals("Incorrect email or password.", landing.getErrorMessage());
	}
	
	@Test
	public void productErrorValidation() throws  IOException, InterruptedException {
		// TODO Auto-generated method stub
		String nombProduct = "IPHONE 13 PRO";
				
		ProductCatalogue  prodCatalogue =  landing.landingPage("email880@gmail.com", "Camilo.880*");		
		List<WebElement>prodList = prodCatalogue.getProductList();
		prodCatalogue.addProductToCart(nombProduct);
		CartPage cartPage = prodCatalogue.subCartHeader();		
		Boolean match = cartPage.VerifyProductDisplay("IPHONE 13 PRO44");	
		Assert.assertFalse(match);
	}
 
}
