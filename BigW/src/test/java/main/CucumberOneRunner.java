package main;

//import BrowserDriverInitializer;
//import com.yan.automator.utility.Reporting;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"},
        features = {"src/SampleRestAssured/resources/storyFiles"},
        glue = {"com/auto/bigw/step/def"},
        tags = {"@AddCart1"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target2/cucumber-reports/report.html"},
        monochrome = true
)
public class CucumberOneRunner {

//    @AfterClass
//    public static void afterClass() throws Throwable {
//        BrowserDriverInitializer.closeDriver();
//        //DriverFactory.appiumTearDown();
//        Reporting rt = new Reporting();
//        rt.terminatingReportGeneration();
//
//    }
}
