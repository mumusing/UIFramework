package org.orac.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.orac.pageObjectRepository.ShowMenuPageObjectRepository;

import com.oracle.framework.Asserts;
import com.oracle.framework.BasePage;
import com.oracle.framework.Report;
import com.oracle.framework.Status;
import com.oracle.framework.Utils;
import com.oracle.framework.WaitTypes;
public class ShowMenuPage extends BasePage<ShowMenuPageObjectRepository> {

	
	
	public ShowMenuPage(WebDriver driver) {
		super(driver, new ShowMenuPageObjectRepository(driver));
		// TODO Auto-generated constructor stub
	}

	public void isAt() {
		boolean isAt;
		try {
			isAt = Utils.waitForElement(ObjectRepository.linkAdministration, 60, WaitTypes.presenceOfElementLocated);
			
			if (isAt)
			{
				Asserts.assertTrue(isAt, "The Show Menu Popup did open sucessfully");
			} 
			else 
			{
				Asserts.assertTrue(isAt, "The Show Menu Popup did not open sucessfully");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//Report.log(Status.FAIL, "Failed while verifying Show Menu Popup");
			e.printStackTrace();
		}

	}

	public AdminNavigationPage clickAdministrationMenu() throws Exception
	 {
		  boolean isAvailable=Utils.waitForElement(ObjectRepository.linkAdministration, 20, WaitTypes.visibilityOfElementLocated);
		  if (isAvailable)
		  {
			  driver.findElement(ObjectRepository.linkAdministration).click();
			  Report.log(Status.Info, "Clicked on Administration menu");			 
		  }
	      else
	      {
		     Report.log(Status.FAIL, "Did not find Administration menu");
	      }
		 return new AdminNavigationPage(driver);


	 }

}
