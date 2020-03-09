package com.auto.bigw.page.def;

import com.auto.bigw.commonFunction.ExcelReader;
import com.auto.bigw.commonFunction.GenericFunction;
import com.auto.bigw.step.def.BaseTest;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BigWAddToCartPage {

    public WebDriver driver;
    public String testCaseName;

    @FindBy(xpath = "//h2[@itemprop=\"name\"]")
    WebElement bigWProductName;

    @FindBy(xpath = "//input[@id='productPageLocationInput']")
    WebElement locationField;

    @FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li[1]")
    WebElement firstLocationOption;

    @FindBy(xpath = "//a[contains(text(),'Select')]")
    WebElement selectLocationButton;

    @FindBy(xpath = "//label[text()=\"Large\"]")
    WebElement selectLargeSize;

    @FindBy(xpath = "//form[@id=\"addToCartForm\"]/button[1]")
    WebElement addToCartButtonNew;





    public BigWAddToCartPage(WebDriver _driver){
        driver = _driver;
        testCaseName = BaseTest.testCaseName;
        PageFactory.initElements(_driver, this);
    }

    public void validateSelectedProduct(){
        GenericFunction genericFunction = new GenericFunction(driver);
        genericFunction.waitForElementPresent(bigWProductName);

        String expectedProductHeaderName= ExcelReader.getTestDataSheet1UI(testCaseName,"Product header text on select cart page");
        String actualProductName = bigWProductName.getText();
        Assert.assertTrue(actualProductName.contains(expectedProductHeaderName));

    }
    public void addTOCart(){
        String postalCode= ExcelReader.getTestDataSheet1UI(testCaseName,"PostalCode");
        locationField.clear();
        locationField.sendKeys(postalCode);
        try{
            Thread.sleep(2000);//TODO replace with custom generic function
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        firstLocationOption.click();
        try{
            Thread.sleep(2000);//TODO replace with custom generic function
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //selectLargeSize.click();
        //selectLocationButton.click();
//        try{
//            Thread.sleep(3000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        GenericFunction genFun = new GenericFunction(driver);
        genFun.waitForElementPresent(addToCartButtonNew);
        addToCartButtonNew.click();

    }
}
