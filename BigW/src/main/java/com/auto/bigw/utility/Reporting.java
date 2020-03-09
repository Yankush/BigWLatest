//package com.yan.automator.utility;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import com.google.gson.Gson;
//import cucumber.api.Scenario;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//import java.net.URL;
//import java.text.SimpleDateFormat;
//import java.commonFunction.Date;
//
//public class Reporting {
//
//    public static ExtentReports extent;
//    public static ExtentTest SampleRestAssured;
//
//    public String userDir = System.getProperty("user.dir");
//    public String osName = System.getProperty("os.name");
//    public String hostName = System.getProperty("user.name");
//    public String extentConfig = System.getProperty("user.dir")+"/src/SampleRestAssured/resources/config/extent-config.xml";
//    public static Reporting report;
//
//
//public static Reporting getInstance() {
//        if(report == null) {
//            report = new Reporting();
//        }
//        return report;
//    }
//
//
// public ExtentTest getTestObject() {
//        return SampleRestAssured;
//    }
//
//
//
//    public ExtentTest intializereporting() throws Exception {
//
//        String jsonContent =  readContentOfFile();
//        System.out.println("json output " +jsonContent);
//        ReportConfig config = (ReportConfig)new Gson().fromJson(jsonContent, ReportConfig.class);
//        extent = new ExtentReports(checkHTMLReportExistOrNot(), true);
//        extent.addSystemInfo("Host Name", hostName).addSystemInfo(config.getEnvironment(), config.getEnvironmentType()).addSystemInfo(config.getDevelopedBy(), config.getYankushPrasad());
//        //extent.loadConfig(Reporting.class.getClassLoader().getResource(config.getExtentConfigFile()));
//        extent.loadConfig(new File(System.getProperty("user.dir")+"/src/SampleRestAssured/resources/config/extent-config.xml"));
//        SampleRestAssured = extent.startTest("automation testing");
//        SampleRestAssured.log(LogStatus.INFO, "Initializing Reports ");
//        SampleRestAssured.log(LogStatus.INFO, "Report started ");
//        return SampleRestAssured;
//    }
//
//
//    public String readContentOfFile() {
//        //String filePath = Report.class.getClassLoader().getResource("reportConfig.json").getFile();
//        String filePath = System.getProperty("user.dir")+"/src/SampleRestAssured/resources/config/reportConfig.json";
//        StringBuilder contentBuilder = new StringBuilder();
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
//        {
//            String sCurrentLine;
//            while ((sCurrentLine = br.readLine()) != null)
//            {
//                contentBuilder.append(sCurrentLine).append("\n");
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        return contentBuilder.toString();
//
//    }
//    public String checkHTMLReportExistOrNot() throws Exception {
//        String date =  getSystemDate();
//        String  reportPath = System.getProperty("user.dir")+"/src/SampleRestAssured/resources/Reports/Big W Test report"+date+".html";
//        File file = new File(reportPath);
//        if(file.exists()) {
//            // do nothing
//        }else {
//            file.createNewFile();
//        }
//        return reportPath;
//    }
//    public String getSystemDate() {
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        String dateAndTime = formatter.format(date);
//        //System.out.println(formatter.format(date));
//
//        return dateAndTime;
//    }
//
//    public void terminatingReportGeneration() {
//        try {
//            SampleRestAssured.log(LogStatus.INFO, "Terminating Reports");
//            extent.endTest(SampleRestAssured);
//            extent.flush();
//            extent.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//public static void main(String[] args)throws Exception {
//        Reporting rt =new Reporting();
//        rt.intializereporting();
//        rt.terminatingReportGeneration();
//    }
//
//}
