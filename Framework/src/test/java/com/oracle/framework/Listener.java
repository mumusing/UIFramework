package com.oracle.framework;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class Listener  implements IInvokedMethodListener 
{
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
		try {
			BaseTest.initialize(method.getTestMethod().getMethodName(), method.getTestMethod().getDescription(), testResult.getClass().getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		// TODO Auto-generated method stub
		System.out.println("Excecuting after listener class");
		if (testResult.getStatus()==ITestResult.FAILURE)
		{
			Report.log(Status.FAIL, testResult.getName()+" Failed");
		}
		BaseTest.quit();
		BaseTest.endReport();	
	}
}
