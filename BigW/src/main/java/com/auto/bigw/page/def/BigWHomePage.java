package com.auto.bigw.page.def;

import com.auto.bigw.commonFunction.ExcelReader;
import com.auto.bigw.commonFunction.GenericFunction;
import com.auto.bigw.step.def.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BigWHomePage {

    public WebDriver driver;
    public String testCaseName;

    @FindBy(xpath = "//button[@id='signUpPopupCloseButton']")
    WebElement bigWsignUpPopUP;

    @FindBy(xpath = "//input[@placeholder='Search bigw.com.au']")
    WebElement bigWSearchField;

    @FindBy(xpath = "//button[@class='siteSearchSubmit btn']")
    WebElement bigWSearchButton;


    public BigWHomePage(WebDriver _driver){
        driver = _driver;
        testCaseName = BaseTest.testCaseName;
        PageFactory.initElements(_driver, this);
    }

    public void enterProductNameInSearchResult()throws Throwable{
        GenericFunction genericFunction = new GenericFunction(driver);
        genericFunction.waitForElementPresent(bigWsignUpPopUP);
        //bigWsignUpPopUP.click();
        String searchProduct= ExcelReader.getTestDataSheet1UI(testCaseName,"SearchField");
        bigWSearchField.sendKeys(searchProduct);
    }
    public void clickOnSearchButton(){
        bigWSearchButton.click();
    }
}
