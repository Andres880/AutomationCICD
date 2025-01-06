package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTests;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.checkoutPage;

public class StepDefinitionsImpl extends BaseTests {

	public LandingPage landing;
	public ProductCatalogue  prodCatalogue;
	public ConfirmationPage confirmessage;
	@Given("He aterrizado en la página de Ecommerce")
	public void He_aterrizado_en_la_página_de_Ecommerce() throws IOException {
		
		landing = launchApplication();		
	}
	
	@Given("^Logeado con el usuario (.+) y contraseña (.+)$")
	public void logeado_en_usuario_and_contraseña(String userName, String Password) {
		
		prodCatalogue = landing.landingPage(userName, Password);
	}
	
	@When("^Añado el producto (.+) al carrito$")
	public void anado_producto_carrito(String nombProduct) throws InterruptedException {
		List<WebElement>prodList = prodCatalogue.getProductList();
		 prodCatalogue.addProductToCart(nombProduct);
	}
	
	@When("^Compruebe (.+) y envíe el pedido$")
	public void compruebe_envie_pedido(String nombProduct) throws InterruptedException
	{
		CartPage cartPage = prodCatalogue.subCartHeader();
		
		Boolean match = cartPage.VerifyProductDisplay(nombProduct);	
		Assert.assertTrue(match);
		checkoutPage checkPage = cartPage.checkgoTo();
	    checkPage.selectCountry("india");
	    confirmessage = checkPage.submitOrder();
	}
	
	@Then("^\"([^\"]*)\" Aparece un mensaje en la página de confirmación")
	public void mensaje_pagina_confirmacion(String menssage)
	{
		String  confirmMessage = confirmessage.getConfirmationMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase(menssage));
	    driver.close();
	}
	
	@Then("^\"([^\"]*)\" Aparece un mensaje")
	public void aparece_un_mensaje(String strArg1) throws InterruptedException
	{
		Assert.assertEquals(strArg1, landing.getErrorMessage());
	    driver.close();
	}
	
}