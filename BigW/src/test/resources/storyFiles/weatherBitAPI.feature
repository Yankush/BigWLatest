Feature: Testing weather API
#SAMPLE FEATURE

  @API_Current @API_UAT @All_Test
  Scenario: validating current observation on latitude and longitude

    When I send get request to get current api response
    Then I see status code as two hundred
    And I get the value of state code


  @API_Forecast @API_UAT @All_Test
  Scenario: returns current weather observation when postal code is given

    When I send get request to get current weather forecast response using postal code
    Then I see timestamp_utc and weather value in response

  @API_user @API_UAT @All_Test
  Scenario: Get user details

    When I post user request
    Then I see user details

  @Payment
  Scenario Outline: Create a checkout with zippay payment onlyy

    Given I enter test case "<TestCase Number>" to execute scenario "<TestScenario Name>" test
    When I Send a post request to create a checkout with zippay payment
    Then I validate the response of checkout zippay payment

    Examples:
      |TestCase Number| TestScenario Name           |
      |  API_TC_03    | Checkout with Zippay payment|



