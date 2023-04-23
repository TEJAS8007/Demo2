package Other;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner implements ITestListener {
 
	public void onStart(ITestContext c)
	{
		System.out.println(" On----START----ITEST");
	}

	public void onFinish(ITestContext c)
	{
		System.out.println("On------FINISH----TEST");
	}

	public void onTestStart(ITestResult c)
	{
		System.out.println("ON_-----Test_____Start");
	}

	public void onTestSuccess(ITestResult c)
	{
		System.out.println("On----Test---Result");
		System.out.println(c.getName());
	}

	public void onTestFailure(ITestResult c)
	{
		System.out.println("On-----Test----Failure");
	}

	public void onTestSkipped(ITestResult c)
	{
		System.out.println("On-----Test---Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult c)
	{
		System.out.println("ON----Test_Failed_But_Within_Success----Test");
	}





}
