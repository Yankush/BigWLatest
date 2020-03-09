package com.auto.bigw.page.def;

import com.auto.bigw.commonFunction.GenericFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BigWSearchResultPage {

    public WebDriver driver;

    @FindBy(xpath = "//h3[contains(text(),'Search results for')]")
    WebElement bigWSearchResultHeaderText;

    @FindBy(xpath = "//div[@class='product-listing']/div[1]/div[2]/h4/a")
    WebElement bigWFirstSearchedProductName;



    public BigWSearchResultPage(WebDriver _driver){
        driver = _driver;
        PageFactory.initElements(_driver, this);
    }


    public void searchResultPage(){
        GenericFunction genericFunction = new GenericFunction(driver);
        genericFunction.waitForElementPresent(bigWSearchResultHeaderText);
    }

    public void selectSearchedProduct(){
        GenericFunction genericFunction = new GenericFunction(driver);
        genericFunction.waitForElementPresent(bigWFirstSearchedProductName);
        bigWFirstSearchedProductName.click();
    }



}
