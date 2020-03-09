package com.auto.bigw.commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GenericFunction {

    private WebDriver _driver;
    private static String testConfig = System.getProperty("user.dir") + "/src/test/resources/config/systemConfig.properties";
    //public String systemConfigKey;


    public GenericFunction(WebDriver driver){
        this._driver = driver;
    }

    public void waitForElementPresent(WebElement element){

        WebDriverWait wait = new WebDriverWait(_driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getDataFromExcel(int row, int col){
        String cellData = ExcelReader.getTestDataValueOfTestConfigSheet1(row,col).toString();
        return cellData;
    }

    public static String getValueFromSystemConfigProperty(String propertyKey) {

        Properties properties = new Properties();
        InputStream input = null;
        String systemConfigKey = null;

        try {

            input = new FileInputStream(testConfig);

            // load a properties file
            properties.load(input);

            // get the property value and print it out
            systemConfigKey = properties.getProperty(propertyKey);

            //return systemConfigKey;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return systemConfigKey;
    }

}
