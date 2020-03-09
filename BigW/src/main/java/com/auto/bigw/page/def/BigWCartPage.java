package com.auto.bigw.page.def;

import com.auto.bigw.commonFunction.ExcelReader;
import com.auto.bigw.commonFunction.GenericFunction;
import com.auto.bigw.step.def.BaseTest;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BigWCartPage {

    public WebDriver driver;
    public String testCaseName;

    public BigWCartPage(WebDriver _driver){
        this.driver = _driver;
        testCaseName = BaseTest.testCaseName;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(xpath = "//a[@class='minicart']/span[2]")
    WebElement addToCartIconOnHeader;

    @FindBy(xpath = "//div[@class=\"itemName\"]/a")
    WebElement addProductTypeToCart;

    @FindBy(xpath = "//div[@id=\"cartItems\"]/div/div[1]/button")
    WebElement proceedToCheckoutButtonOne;


    public void clickCartIcon(){
        try{
            Thread.sleep(10000);//TODO replace with custom generic function
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        GenericFunction genericFunction =new GenericFunction(driver);
        genericFunction.waitForElementPresent(addToCartIconOnHeader);
        addToCartIconOnHeader.click();
        try{
            Thread.sleep(10000);//TODO replace with custom generic function function
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void validateSelectedProduct(){
        String expectedProductAddedToCartPage= ExcelReader.getTestDataSheet1UI(testCaseName,"Product name on cart page");
        GenericFunction genericFunction =new GenericFunction(driver);
        genericFunction.waitForElementPresent(addProductTypeToCart);
        String actualProductName = addProductTypeToCart.getText();
        Assert.assertEquals(expectedProductAddedToCartPage, actualProductName);
    }

    public void clickOnProceedToCheckoutButton(){
        proceedToCheckoutButtonOne.click();
    }


}
