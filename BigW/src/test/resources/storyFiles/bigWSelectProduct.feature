Feature: Select Big W product

  @AddCart
  Scenario Outline: Add to cart Big W product

    Given I enter test case "<TestCase Number>" to execute scenario "<TestScenario Name>" test
    When I navigate to Big W website
    And I enter the product name and and search the product
    And I select the product on search result page
    And I click on add to cart button
    Then I see product is available in add to cart page
    When I click on proceed to checkout button


    Examples:
      |TestCase Number| TestScenario Name           |
      |  UI_TC_02     | Checkout with Zippay payment|




