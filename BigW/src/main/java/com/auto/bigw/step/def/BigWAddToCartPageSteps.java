package com.auto.bigw.step.def;

import com.auto.bigw.page.def.BigWAddToCartPage;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class BigWAddToCartPageSteps {

    public WebDriver driver;

    public BigWAddToCartPageSteps(){
        this.driver = BaseTest._driver;
    }

    @When("^I click on add to cart button$")
    public void i_click_on_add_to_cart_button() throws Throwable {
        BigWAddToCartPage bigWAddToCartPage = new BigWAddToCartPage(driver);
        bigWAddToCartPage.validateSelectedProduct();
        bigWAddToCartPage.addTOCart();
    }
}
