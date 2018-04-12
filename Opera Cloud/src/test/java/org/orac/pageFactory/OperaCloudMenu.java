package org.orac.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.oracle.framework.Asserts;
import com.oracle.framework.Report;
import com.oracle.framework.Status;
import com.oracle.framework.Utils;
import com.oracle.framework.WaitTypes;
import com.oracle.framework.WrappedWebDriver;

public class OperaCloudMenu 
{
	
	
	
     WrappedWebDriver driver;
	 public OperaCloudMenu(WrappedWebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
//	 //Administration menu
//	 By linkAdministration=By.xpath("//a[contains(@id,'pt1:oc_pg_pt:pt_pt1:oc_pg_sdmn')]//span[text()='Administration']");
//	 public void clickAdministrationMenu() throws Exception
//	 {
//		 WebElement element= Utils.waitForElement(linkAdministration, 20, WaitTypes.elementToBeClickable);
//		 driver.findElement(linkAdministration).click();
//		 Report.log(Status.Info, "Clicked on Administration menu");
//	 }
//	 
//	 public void verifyMenuOpen() throws Exception
//	 {
//			WebElement element =Utils.waitForElement(linkAdministration, 60, WaitTypes.presenceOfElementLocated);
//              Asserts.verifyTrue(element.getText().equalsIgnoreCase("Administration"), "Verify Opera control menu");
//	 }
	 
}
