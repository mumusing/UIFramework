package org.orac.pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.orac.pageObjectRepository.HomePageObjectRepository;

import com.oracle.framework.Asserts;
import com.oracle.framework.BasePage;
import com.oracle.framework.Report;
import com.oracle.framework.Status;
import com.oracle.framework.Utils;
import com.oracle.framework.WaitTypes;

public class HomePage extends BasePage<HomePageObjectRepository>
{

	public HomePage(WebDriver driver) 
	{
		super(driver,new HomePageObjectRepository(driver));
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method verify that page have appear
	 */
	
	public ShowMenuPage showMenuPage=new ShowMenuPage(driver);
	/**
	 * Verify Home page is Open
	 */
    public void isAt()
    {
    	boolean isAt=false;
		try 
		{
			isAt = Utils.waitForElement(ObjectRepository.homeTitle, 60, WaitTypes.presenceOfElementLocated);
			if (isAt)
			{
				Asserts.assertTrue(isAt, "The Home page did  open sucessfully");	

			} 
			else
			{
				Asserts.assertTrue(isAt, "The Home page did not  open sucessfully");	 
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			Report.log(Status.FAIL, "Failed while verifying Home Page");
			e.printStackTrace();
		}   	
    }
    
	public void clickShowMenu() throws Exception
	{
		Utils.waitForElement(ObjectRepository.link_ShowMenu, 60, WaitTypes.presenceOfElementLocated);
		Utils.waitForElement(ObjectRepository.link_ShowMenu, 60, WaitTypes.elementToBeClickable);
		Utils.clickUsingJavaScript(driver.findElement(ObjectRepository.link_ShowMenu));
		//driver.findElement(ObjectRepository.link_ShowMenu).click();
		Report.log(Status.Info, "Clicked show Menu");
	}
	public void logOut() throws Exception
	{
		//Click On 
		driver.findElement(ObjectRepository.link_ShowUserOptions);
		Utils.waitForElement(ObjectRepository.Logout_Button, 60, WaitTypes.presenceOfElementLocated);
		driver.findElement(ObjectRepository.Logout_Button).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
