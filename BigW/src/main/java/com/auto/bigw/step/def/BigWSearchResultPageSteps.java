package com.auto.bigw.step.def;

import com.auto.bigw.page.def.BigWSearchResultPage;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class BigWSearchResultPageSteps {

    public WebDriver driver;

    public BigWSearchResultPageSteps(){
        this.driver =  BaseTest._driver;
    }

    @When("^I select the product on search result page$")
    public void i_select_the_product_on_search_result_page() throws Throwable {

        BigWSearchResultPage searchResultPa = new BigWSearchResultPage(driver);
        searchResultPa.searchResultPage();
        searchResultPa.selectSearchedProduct();
    }
}
