
	@tag
	Feature: comprar el pedido desde el sitio web de comercio electrónico
	  I want to use this template for my feature file
	
	 Background:
	 Given He aterrizado en la página de Ecommerce

  @Regression
  Scenario Outline: Title of your scenario outline
    Given Logeado con el usuario <name> y contraseña <password>
    When  Añado el producto <nombProduct> al carrito
    And Compruebe <nombProduct> y envíe el pedido
    Then "THANKYOU FOR THE ORDER." Aparece un mensaje en la página de confirmación

    Examples: 
      | name               | password    | nombProduct   |
      | correo@gmail.com   | Camilo.880* | IPHONE 13 PRO |

