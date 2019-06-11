package listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNgListner implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("******** Test Started***** :" + iTestResult.getName() );
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("******** Test Succeeded***** :" + iTestResult.getName() );
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("******** Test failed***** :" + iTestResult.getName() );
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("******** Test Skipped***** :" + iTestResult.getName() );
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("******** Test temporay failed***** :" + iTestResult.getName() );
    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("******** Test Finished***** :" + iTestContext.getName() );
    }
}
