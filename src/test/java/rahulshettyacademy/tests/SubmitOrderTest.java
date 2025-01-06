package rahulshettyacademy.tests;


import rahulshettyacademy.TestComponents.BaseTests;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.checkoutPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class SubmitOrderTest extends BaseTests {
	
	//String nombProduct = "IPHONE 13 PRO";
	
	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws  IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String countryName = "india";
		String message = "THANKYOU FOR THE ORDER.";
				
		ProductCatalogue  prodCatalogue =  landing.landingPage(input.get("email"), input.get("password"));		
		List<WebElement>prodList = prodCatalogue.getProductList();
		prodCatalogue.addProductToCart(input.get("nombProduct"));
		CartPage cartPage = prodCatalogue.subCartHeader();		
		Boolean match = cartPage.VerifyProductDisplay(input.get("nombProduct"));	
		Assert.assertTrue(match);
		checkoutPage checkPage = cartPage.checkgoTo();
	    checkPage.selectCountry(countryName);
	    ConfirmationPage confirmessage = checkPage.submitOrder();
	    String  confirmMessage = confirmessage.getConfirmationMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	}
	
	@Test(dependsOnMethods={"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue  prodCatalogue =  landing.landingPage("correo@gmail.com", "Camilo.880*");
		OrderPage orderPage =  prodCatalogue.goToOrderPage();		
		Assert.assertTrue(orderPage.VerifyOrderDisplay("IPHONE 13 PRO"));	
	}
	
	//Implementación y parametrización con DataProvider	
	//Integración de HashMap para enviar los datos por DataProvider.
	//Primera forma para poder poder enviar los datos al metodo "submitOrder"	

	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email","correo@gmail.com");
//		map.put("password", "Camilo.880*");
//		map.put("nombProduct", "IPHONE 13 PRO");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "email880@gmail.com");
//		map1.put("password", "Camilo.880*");
//		map1.put("nombProduct", "ADIDAS ORIGINAL");
//		
		List<HashMap<String, String>> data = getJsonDataToMap("C:/Users/alder/eclipse-workspace/SeleniumFrameworkDesign/src/test/java/rahulshettyacademy/data/PurchaseOrder.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
	}
	
	//Segunda forma para poder poder enviar los datos al metodo "submitOrder"
//	@DataProvider
//	public Object[][] getData()
//	{//			
//		return new Object [][] {{"correo@gmail.com","Camilo.880*","IPHONE 13 PRO"},{"email880@gmail.com","Camilo.880*","ADIDAS ORIGINAL"}};
//	}
 
}
