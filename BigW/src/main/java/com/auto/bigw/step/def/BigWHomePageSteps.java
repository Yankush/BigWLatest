package com.auto.bigw.step.def;

import com.auto.bigw.page.def.BigWHomePage;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import com.auto.bigw.commonFunction.GenericFunction;

public class BigWHomePageSteps {

    private WebDriver driver;

    public BigWHomePageSteps(){
        this.driver =  BaseTest._driver;
    }

    @When("^I navigate to Big W website$")
    public void i_navigate_to_Big_W_website() {
        GenericFunction genericFunction= new GenericFunction(driver);
        driver.manage().window().fullscreen();
        driver.navigate().to(genericFunction.getValueFromSystemConfigProperty("url"));
    }

    @When("^I enter the product name and and search the product$")
    public void i_enter_the_product_name_and_and_search_the_product() throws Throwable {

        BigWHomePage bHomePage = new BigWHomePage(driver);
        bHomePage.enterProductNameInSearchResult();
        bHomePage.clickOnSearchButton();
    }
}
