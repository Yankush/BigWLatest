package com.auto.bigw.step.def;

import com.auto.bigw.page.def.ApiCheckoutWithZippayPaymentOnlyPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpResponse;

public class ApiCheckoutWithZippayPaymentOnlySteps {


    public HttpResponse response;

    @When("^I Send a post request to create a checkout with zippay payment$")
    public void i_Send_a_post_request_to_create_a_checkout_with_zippay_payment() throws Throwable {
        ApiCheckoutWithZippayPaymentOnlyPage checkoutZipPayPayment = new ApiCheckoutWithZippayPaymentOnlyPage();
        response = checkoutZipPayPayment.sendPostcheckoutZipPayPayment();
    }

    @Then("^I validate the response of checkout zippay payment$")
    public void i_validate_the_response_of_checkout_zippay_payment() throws Throwable {
        ApiCheckoutWithZippayPaymentOnlyPage checkoutZipPayPayment = new ApiCheckoutWithZippayPaymentOnlyPage();
        checkoutZipPayPayment.validateCurrentAPIResponsData(response);
    }
}
