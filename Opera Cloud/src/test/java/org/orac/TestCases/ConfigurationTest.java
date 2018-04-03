package org.orac.TestCases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.orac.pageFactory.AdminNavigationPage;
import org.orac.pageFactory.HomePage;
import org.orac.pageFactory.LoginPage;
import org.orac.pageFactory.OperaCloudAdministration;
import org.orac.pageFactory.OperaCloudMenu;
import org.orac.pageFactory.PackageCodesPage;
import org.orac.pageFactory.TransactionGroupsPage;
import org.orac.pageFactory.TransactionGroupsPageTemplateSection;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.oracle.framework.Listener;
import com.oracle.framework.Report;
import com.oracle.framework.Status;
import com.oracle.framework.BaseTest;
import com.oracle.framework.DataProvider;
import com.oracle.framework.DateHelper;
@Listeners(Listener.class)
public class ConfigurationTest extends BaseTest {

//	@BeforeMethod
//	public void setup(Method method) throws Exception 
//	{
//		//System.out.println(method.getName());
//		initialize(method.getName(),"" , "fghs");
//	}

//	@Test(description="This method use for create transaction method")
//	public void login() throws Exception
//	{
//		try
//		{
//			// initialize("LoginPage", "fsfsd", "fghs");
//			LoginPage loginPage = new LoginPage(driver);
//			HomePage homePage=loginPage.loginToApplication();
//			
//			//Home Page
//			homePage.isAt();
//			homePage.clickShowMenu();
//			homePage.showMenuPage.isAt();
//			//Navigate to Admin Page			
//			AdminNavigationPage adminNavigationPage=homePage.showMenuPage.clickAdministrationMenu();		
//			adminNavigationPage.isAt();
//			PackageCodesPage packageCodePage=adminNavigationPage.navigateToPackageCode();
//			//Package Codes Page
//			packageCodePage.isAt();
//						
//		} 
//		catch (Exception e)
//		{
//			Report.log(Status.FAIL, "Test fail because of exception: " + e);
//			throw e;
//		}
//	}

	@Test(description="This method use for create transaction method")
	public void createTransactionCode() throws Exception
   {
		try 
		{
			//Data Preparation
			//Transaction Group
			String transactionGroup=dataProvider.getData("Transcation Code")+DateHelper.GetRandomCapName(3);
			String description=dataProvider.getData("Transcation Description")+DateHelper.GetRandomCapName(4);
			
			
			// initialize("LoginPage", "fsfsd", "fghs");
			LoginPage loginPage = new LoginPage(driver);
			HomePage homePage = loginPage.loginToApplication();
              
			// Home Page
			homePage.isAt();
			homePage.clickShowMenu();
			homePage.showMenuPage.isAt();
			// Navigate to Admin Page
			AdminNavigationPage adminNavigationPage = homePage.showMenuPage.clickAdministrationMenu();
			adminNavigationPage.isAt();
			
			//Navigate to Transaction Group
			TransactionGroupsPage transcationGroupPage=adminNavigationPage.navigateToTranscationGroupPage();
			transcationGroupPage.isAt();
			transcationGroupPage.clickTemplateTab();
			
			//Click new link
			transcationGroupPage.transactionGroupPagetemp.clicknewLink();
			transcationGroupPage.transactionGroupPagetemp.clickRevenueType();
			transcationGroupPage.transactionGroupPagetemp.enterCode(transactionGroup);
			transcationGroupPage.transactionGroupPagetemp.enterDescription(description);
			transcationGroupPage.transactionGroupPagetemp.clickSequence();
			transcationGroupPage.transactionGroupPagetemp.clickSaveButton();
			
			//
			
			
			
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			Report.log(Status.FAIL, e+"");
			throw e;
		}
	}
	
//	@AfterMethod
//	public void tearDown(ITestResult testResult) 
//	{
//		if (testResult.getStatus()==ITestResult.FAILURE)
//		{
//			Report.log(Status.FAIL, testResult.getName()+" Failed");
//		}
//		driver.quit();
//		endReport();
//	}
}
