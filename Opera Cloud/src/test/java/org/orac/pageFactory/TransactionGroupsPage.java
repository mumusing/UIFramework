package org.orac.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.orac.pageObjectRepository.TransactionGroupsPageObjectRepository;

import com.oracle.framework.Asserts;
import com.oracle.framework.BasePage;
import com.oracle.framework.Report;
import com.oracle.framework.Status;
import com.oracle.framework.Utils;
import com.oracle.framework.WaitTypes;

public class TransactionGroupsPage extends BasePage<TransactionGroupsPageObjectRepository>
{

	public TransactionGroupsPage(WebDriver driver) 
	{
		super(driver, new TransactionGroupsPageObjectRepository(driver));
		// TODO Auto-generated constructor stub
	}
	
	  public TransactionGroupsPageTemplateSection transactionGroupPagetemp=new TransactionGroupsPageTemplateSection(driver);
	
	/**
	 * This method verify that user is on Transaction Groups Screen
	 */
	public void isAt()
	{
		boolean isAt=false;
		try 
		{
			isAt = Utils.waitForElement(ObjectRepository.transactionGroupTitle, 60, WaitTypes.presenceOfElementLocated);
			if (isAt)
			{
				Asserts.assertTrue(isAt, "The Transaction Groups page did  open sucessfully");	
			} 
			else
			{
				Asserts.assertTrue(isAt, "The Transaction Groups page did not  open sucessfully");	 
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			Report.log(Status.FAIL, "Failed while verifying Transaction Groups Page");
			e.printStackTrace();
		}   	
	}
	
    /**
     * This method click on Template Tab
     */
	public void clickTemplateTab()
	{
		driver.findElement(ObjectRepository.templateTab).click();
	}
}
