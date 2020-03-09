package main;

import com.cucumber.listener.Reporter;

import com.auto.bigw.utility.BrowserDriverInitializer;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
//import


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"},
        features = {"src/test/resources/storyFiles"},
        glue = {"com/auto/bigw/step/def"},
        tags = {"@AddCart"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target1/cucumber-reports/report.html"},
        monochrome = true
)
public class CucumberRunner {


//    @AfterClass
//    public static void afterClass() throws Throwable {
//        System.out.println( "this is after class");
//        //BrowserDriverInitializer.closeDriver();
//
//
//       /* //DriverFactory.appiumTearDown();
//        Reporting rt = new Reporting();
//        rt.terminatingReportGeneration();*/
//        Reporter.loadXMLConfig(System.getProperty("user.dir")+"/src/SampleRestAssured/resources/config/extent-config.xml");
//        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//        Reporter.addScenarioLog("this is Big W SampleRestAssured");
//
//        BrowserDriverInitializer.closeDriver();
//
//    }
}
