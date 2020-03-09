Feature: Testing Payment API


@Payment
Scenario Outline: Create a checkout with zippay payment only

  Given I enter test case "<TestCase Number>" to execute scenario "<TestScenario Name>" test
  When I Send a post request to create a checkout with zippay payment
  Then I validate the response of checkout zippay payment

  Examples:
  |TestCase Number| TestScenario Name           |
  |  API_TC_03    | Checkout with Zippay payment|
  #|  API_TC_03    | Checkout with Zippay payment|
