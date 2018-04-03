package org.orac.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.orac.pageObjectRepository.PackageCodesPageObjectRepository;

import com.oracle.framework.Asserts;
import com.oracle.framework.BasePage;
import com.oracle.framework.Report;
import com.oracle.framework.Status;
import com.oracle.framework.Utils;
import com.oracle.framework.WaitTypes;
import com.oracle.framework.WrappedWebDriver;

public class PackageCodesPage extends BasePage<PackageCodesPageObjectRepository>
{
	
	public PackageCodesPage(WebDriver driver) {
		super(driver, new PackageCodesPageObjectRepository(driver));
		// TODO Auto-generated constructor stub
	}

	
//	public void verifyTitle() throws Exception
//	{
//		WebElement element =Utils.waitForElement(ObjectRepository.titlePackageCode, 60, WaitTypes.presenceOfElementLocated);
//		System.out.println(element.getText());
//		Asserts.verifyTrue(element.getText().equalsIgnoreCase("Package Codes"), "Veirfy Package Codes titles");
//	}
	
	public void isAt() 
	{   
		
			boolean isAt;
			try 
			{
				isAt = Utils.waitForElement(ObjectRepository.titlePackageCode, 60, WaitTypes.presenceOfElementLocated);
				if (isAt) 
				{
					Asserts.assertTrue(isAt, "The Package code page did open sucessfully");	
				}
				else
				{
					Asserts.assertTrue(isAt, "The Package code page did not open sucessfully");	
				}
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
			//	Report.log(Status.FAIL, "Failed while verifying Package code page");
				e.printStackTrace();
			}
				
		
	}
	
}
