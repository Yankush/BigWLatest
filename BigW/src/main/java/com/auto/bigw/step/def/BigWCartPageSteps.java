package com.auto.bigw.step.def;

import com.auto.bigw.page.def.BigWCartPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class BigWCartPageSteps {

    public WebDriver driver;

    public BigWCartPageSteps(){
        this.driver = BaseTest._driver;
    }
    @Then("^I see product is available in add to cart page$")
    public void i_see_product_is_available_in_add_to_cart_page() throws Throwable {
        BigWCartPage bigWCartPage = new BigWCartPage(driver);
        bigWCartPage.clickCartIcon();
        bigWCartPage.validateSelectedProduct();
    }

    @When("^I click on proceed to checkout button$")
    public void i_click_on_proceed_to_checkout_button() throws Throwable {
        BigWCartPage bigWCartPage = new BigWCartPage(driver);
        bigWCartPage.clickOnProceedToCheckoutButton();
        Thread.sleep(3000);//TODO Build custome wait function
    }
}
