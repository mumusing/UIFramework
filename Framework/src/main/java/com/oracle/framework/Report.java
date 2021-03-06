package com.oracle.framework;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report 
{
    
	
	
	private static String resultPath=getResultPath();
	private static String file_name="/ExtentReports.html";
	private static  ExtentReports extentReport;
	private static ExtentTest looger;
	private static String testName;
	private static int scrCounter=0;
	private static  String screenShotPath;
	private static String getResultPath()
	{
		resultPath=System.getProperty("user.dir")+"/report/"+"Run"+DateHelper.getCurrentDateTime("yyyyDDmm")+DateHelper.getCurrentDateTime("HHmmss");
		if (!new File(resultPath).isDirectory())
		{
			new File(resultPath).mkdirs();
		}
		
		return resultPath;
	}
	
	public static void startExtentReport(String testCaseName,String description,String...categories)
	{
		testName=testCaseName;
		extentReport=new ExtentReports(resultPath+file_name,false);
		extentReport.addSystemInfo("Host", "Local").addSystemInfo("Env", "Cloud");
		looger=extentReport.startTest(testCaseName, description).assignCategory(categories);
		
	}
	public static void endReport()
	{
		extentReport.endTest(looger);
		extentReport.flush();
	}
	public static void log(Status status,String message)
	{
		switch (status) 
		{
		case PASS:
			screenShotPath=resultPath+"/ScreenShots/"+testName+"/"+"Screen_"+scrCounter+".png";
			Utils.takeScreenShot(screenShotPath);
			looger.log(LogStatus.PASS, message+looger.addScreenCapture(screenShotPath));
			scrCounter++;
			break;
			
		case Pass:
			      looger.log(LogStatus.PASS, message);
			break;
			
		case FAIL:
			screenShotPath=resultPath+"/ScreenShots/"+testName+"/"+"Screen_"+scrCounter+".png";
			Utils.takeScreenShot(screenShotPath);			
			looger.log(LogStatus.FAIL, message+looger.addScreenCapture(screenShotPath));
			scrCounter++;
			break;
			
		case Fail:
			      looger.log(LogStatus.FAIL, message);
			break;
			
		case Info:
		      looger.log(LogStatus.INFO, message);
		break;
			
		default:
			break;
		}
	}
	
}
