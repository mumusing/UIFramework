package org.orac.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oracle.framework.BasePageObjectRepository;

public class TransactionGroupsPageObjectRepository extends BasePageObjectRepository
{

	
	public TransactionGroupsPageObjectRepository(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
       //Transaction group title
	   public By transactionGroupTitle=By.xpath("//h1[text()='Transaction Groups']");
	    //Template Tab
	   public By templateTab=By.xpath("//div[contains(@id,'oc_scrn_tmpl:template::ti::_afrTabCnt')]//a[text()='Template']");
	
	   
	
	
	
	
}
