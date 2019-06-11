package extentReport;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(ExtentReports extent) {

        if (extent == null) {
            //Set HTML reporting file location
            // initialize the HtmlReporter

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

            // create ExtentReports and attach reporter(s)
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
