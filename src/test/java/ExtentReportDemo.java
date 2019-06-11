import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.security.Key;

public class ExtentReportDemo {

    static  WebDriver driver = null;

    public static void main(String[] args) {
        new ExtentReportDemo().ExtentReport();
    }

    public  void  ExtentReport(){
        // initialize the HtmlReporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it

        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

        String projectPath =  System.setProperty("webdriver.gecko.driver","C:\\Users\\AmanBathla\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.get("https://www.google.com");
        test.pass("Browsers open succesfully");
        driver.findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
        test.pass("Enter in the search key");

//
//        driver.close();
//        driver.quit();
        // log(Status, details)

        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");


        test.fail("Failure testing");

        try {
            // log with snapshot

            if(test.getStatus().toString() == "pass"){
                test.addScreenCaptureFromPath("screenshot.png");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
            }
            else
            {

                // test with snapshot
                test.addScreenCaptureFromPath("screenshot.jpeg");
                test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.jpeg").build());
            }

        }
        catch (Exception ex){

        }

        // calling flush writes everything to the log file
        extent.flush();
    }
}
