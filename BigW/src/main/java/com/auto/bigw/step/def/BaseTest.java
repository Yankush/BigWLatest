package com.auto.bigw.step.def;

import com.auto.bigw.utility.BrowserDriverInitializer;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import java.io.File;
import java.io.IOException;


public class BaseTest {

    public static WebDriver _driver;
    public static String testCaseName;

    @Before
    public void startUp(Scenario scenario){
        System.out.println("This is before method");
        _driver =  new BrowserDriverInitializer().initializeAndGetDriver();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) _driver).getScreenshotAs(OutputType.FILE);

                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");

                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);

                //This attach the specified screenshot to the SampleRestAssured
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
            }
        }
    }

    @After(order = 0)
    public void tearDown(){
        System.out.println("This is After method");
        Reporter.loadXMLConfig(System.getProperty("user.dir")+"/src/SampleRestAssured/resources/config/extent-config.xml");
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        //Reporter.addScenarioLog("this is Big W SampleRestAssured");

        BrowserDriverInitializer.closeDriver();

    }

//    public BaseTest(){
//
//        _driver =  new BrowserDriverInitializer().initializeAndGetDriver();
//    }
    @Given("^I enter test case \"([^\"]*)\" to execute scenario \"([^\"]*)\" test$")
    public void i_enter_test_case_to_execute_scenario_test(String testNumber, String testName)  {
        testCaseName = testNumber + "_" + testName;
    }

}
