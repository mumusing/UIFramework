package org.orac.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.oracle.framework.Asserts;
import com.oracle.framework.Utils;
import com.oracle.framework.WaitTypes;
import com.oracle.framework.WrappedWebDriver;

public class OperaCloudAdministration 
{
	WrappedWebDriver driver;
    public OperaCloudAdministration(WrappedWebDriver driver)
    {
    	this.driver=driver;
    }
    
    By AdminTitle=By.xpath("//h1[text()='OPERA Cloud Administration']");
	public void verifyTitle() throws Exception
	{
	//	WebElement element=Utils.waitForElement(AdminTitle, 60, WaitTypes.presenceOfElementLocated);
	//	Asserts.verifyFalse(element.getText().equalsIgnoreCase("OPERA Cloud Administration"), "Verify admin page title");
	}
	
}
