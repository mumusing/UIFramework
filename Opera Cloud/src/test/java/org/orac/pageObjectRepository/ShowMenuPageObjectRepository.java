package org.orac.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oracle.framework.BasePageObjectRepository;

public class ShowMenuPageObjectRepository extends BasePageObjectRepository
{
    
	public ShowMenuPageObjectRepository(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	 //Administration menu
	public By linkAdministration=By.xpath("//a[contains(@id,'pt1:oc_pg_pt:pt_pt1:oc_pg_sdmn')]//span[text()='Administration']");	

}
