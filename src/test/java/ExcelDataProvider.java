import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import excel.ExcelUtil;
import extentReport.ExtentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listner.TestNgListner.class)
public class ExcelDataProvider {

   //Driver
    WebDriver driver  = null;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;

    // Set up Test

    @BeforeTest
    public  void setUpTest(){

        String projectPath =  System.setProperty("webdriver.gecko.driver","C:\\Users\\AmanBathla\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        htmlReporter  = new ExtentHtmlReporter("extentReport.html");

    }

    // test data


    @Test(dataProvider =  "testData")
    public void  test1(String url,String password) throws InterruptedException {


        System.out.println(url + "|" + password);

        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.chord(Keys.CONTROL, "n"));
        System.out.println(driver.getWindowHandles().size());

        driver.get(url);
        if(url == null){
            Assert.assertFalse(true);
        }

        else{
            Assert.assertTrue(true);
        }
        ExtentManager extentManager = new ExtentManager();

//        extentReports =   extentManager.getReporter(extentReports);
//
//
//        ExtentTest reportsTest= extentReports.createTest("current :" + url );
//
//        System.out.println( "Url ********" + driver.getCurrentUrl().toString());
//
//        Thread.sleep(2000);
//        extentReports.flush();

    }

    // data provider for test

    @DataProvider(name = "testData")
    public Object[][] getData(){

       // String projectPath = System.getProperty("user.dir") + "//excel//data.xlsx";
       String excelPath = "C:\\Users\\AmanBathla\\Desktop\\AMHI_salenium_POC\\src\\main\\java\\excel\\data.xlsx";
        Object data[][] = getData(excelPath,"Sheet1");

        return data;
    }


    public static Object[][] getData(String excelPath,String sheetName){

      ExcelUtil excelUtil = new ExcelUtil(excelPath,sheetName);

      int rowCount = excelUtil.getRowCount();
      int columnCount = excelUtil.getColumnCount();

      Object data[][] = new Object[rowCount-1][columnCount];

      for(int i = 1;i < rowCount; i++){

          for(int j=0;j<columnCount;j++){

                String cellData = excelUtil.getCellDataString(i,j);
                data[i-1][j] = cellData;
          }
          System.out.println();
      }
      return data;

    }
}
