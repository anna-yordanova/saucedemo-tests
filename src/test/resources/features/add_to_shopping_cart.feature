Feature: Add product to the shopping cart

  In order to purchase a product
  As a customer
  I want to be able to add products in a shopping cart

    Scenario: Add products to shopping cart via Products page
      Given STUARD is logged in
      And has added the following products in his shopping cart
      |Sauce Labs Bolt T-Shirt|
      |Sauce Labs Fleece Jacket|
      When he opens the shopping cart
      Then in his shopping cart are listed
      |Sauce Labs Bolt T-Shirt|
      |Sauce Labs Fleece Jacket|

  Scenario Outline: Add product to shopping cart via Products page
    Given STUARD is logged in
    And has added the following product in the shopping cart: <productName>
    When he opens the shopping cart
    Then in the shopping cart is listed: <productName>

    Examples:
        | productName |
        | Sauce Labs Fleece Jacket |

