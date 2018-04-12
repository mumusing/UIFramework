package org.orac.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.orac.pageObjectRepository.AdminNavigationPageObjectRepository;

import com.oracle.framework.Asserts;
import com.oracle.framework.BasePage;
import com.oracle.framework.Report;
import com.oracle.framework.Status;
import com.oracle.framework.Utils;
import com.oracle.framework.WaitTypes;
import com.oracle.framework.WrappedWebDriver;

public class AdminNavigationPage extends BasePage<AdminNavigationPageObjectRepository> {

	public AdminNavigationPage(WebDriver driver) {
		super(driver, new AdminNavigationPageObjectRepository(driver));
		// TODO Auto-generated constructor stub
	}

	
	
	
	public void isAt()
	{
		boolean isAt;
		try 
		{
			isAt = Utils.waitForElement(ObjectRepository.OperaCloudAdministration, 60, WaitTypes.presenceOfElementLocated);
			Asserts.assertTrue(isAt, "The Home page did open sucessfully");	
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			//Report.log(Status.FAIL, "Failed while verifying Home Page");
			e.printStackTrace();
		}
		
	}
	/**
	 * This method navigate to Package Code Page
	 * @return
	 */
	public PackageCodesPage navigateToPackageCode() {
		driver.findElement(ObjectRepository.linkFinancial).click();
		Report.log(Status.Pass, "Click on Financial");
		// Move to Rate Management link
		Actions action = new Actions(driver);
		WebElement webRateManagement = driver.findElement(ObjectRepository.linkRateManagement);
		action.moveToElement(webRateManagement).click().perform();
		Report.log(Status.Pass, "Move to Financial->Rate Management and click Rate Management");

		// Click Package Code
		WebElement webPackageCode = driver.findElement(ObjectRepository.linkPackageCode);
		action.moveToElement(webPackageCode).click().perform();
		Report.log(Status.Pass, "Move to Financial->Rate Management->Package Code and click Package Code");
        return new PackageCodesPage(driver);
	}
    /**
     * This method navigate user to Transcation group page
     * @return
     */
	public TransactionGroupsPage navigateToTranscationGroupPage()
	{
		driver.findElement(ObjectRepository.linkFinancial).click();
		Report.log(Status.Pass, "Click on Financial");
		// Move to Rate Management link
		Actions action = new Actions(driver);
		WebElement webRateManagement = driver.findElement(ObjectRepository.linkTransactionManagement);
		action.moveToElement(webRateManagement).click().perform();
		Report.log(Status.Pass, "Move to Financial->Transaction Management and click Transaction Management");

		// Click Transaction Group
		WebElement webPackageCode = driver.findElement(ObjectRepository.linkTransactionGroup);
		action.moveToElement(webPackageCode).click().perform();
		Report.log(Status.Pass, "Move to Financial->Transaction Management->Transaction Group and click Transaction Group");
		return new TransactionGroupsPage(driver);
	}
	
	
	
	
}
