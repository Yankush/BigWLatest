//package com.auto.bigw.step.def;
//
//import com.auto.bigw.page.def.WeatherBitAPIPage;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.apache.http.HttpResponse;
//
//public class WeatherBitAPISteps {
//
//private HttpResponse response;
//
//    @When("^I send get request to get current api response$")
//    public void i_send_get_request_to_get_current_api_response()throws  Throwable {
//
//        WeatherBitAPIPage weatherBitAPIPage = new WeatherBitAPIPage();
//        response = weatherBitAPIPage.executeCurrentAPIGetRequest();
//    }
//
//    @Then("^I see status code as two hundred$")
//    public void i_see_status_code_as_two_hundred()  {
//        WeatherBitAPIPage weatherBitAPIPage = new WeatherBitAPIPage();
//        weatherBitAPIPage.validateCurrentAPIResponseStatus(response);
//    }
//
//    @Then("^I get the value of state code$")
//    public void i_get_the_value_of_state_code()throws  Throwable{
//        WeatherBitAPIPage weatherBitAPIPage = new WeatherBitAPIPage();
//        weatherBitAPIPage.validateCurrentAPIResponsData(response);
//    }
//
//    @When("^I send get request to get current weather forecast response using postal code$")
//    public void i_send_get_request_to_get_current_weather_forecast_response_using_postal_code() throws Throwable {
//        WeatherBitAPIPage weatherBitAPIPage = new WeatherBitAPIPage();
//       response = weatherBitAPIPage.executeForcastAPIGetRequest();
//    }
//
//    @Then("^I see timestamp_utc and weather value in response$")
//    public void i_see_timestamp_utc_and_weather_value_in_response() throws Throwable {
//        WeatherBitAPIPage weatherBitAPIPage = new WeatherBitAPIPage();
//        weatherBitAPIPage.validateForcastAPIResponsData(response);
//    }
//}
