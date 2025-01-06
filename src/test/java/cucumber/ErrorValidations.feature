
@tag
Feature: Error validation
  I want to use this template for my feature file
  
  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given He aterrizado en la página de Ecommerce
    When Logeado con el usuario <name> y contraseña <password>
 		Then "Incorrect email or password." Aparece un mensaje
 		
    Examples: 
      | name               | password    |
      | correo@gmail.com   | Camilo88*   |
