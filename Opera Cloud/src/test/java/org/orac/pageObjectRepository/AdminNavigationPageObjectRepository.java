package org.orac.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oracle.framework.BasePageObjectRepository;

public class AdminNavigationPageObjectRepository extends BasePageObjectRepository
{
   
	
	
	
	public AdminNavigationPageObjectRepository(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	  //Financial Link
        public	  By linkFinancial=By.xpath("//a[text()='Financial']");
	   //Rate Management
        public    By linkRateManagement=By.xpath("//tr[contains(@id,'pt1:oc_pg_pt:pt_pt1:dm1:j_idt')]//td[text()='Rate Management']");
	   //Package Code
        public    By linkPackageCode=By.xpath("//tr[contains(@id,'pt1:oc_pg_pt:pt_pt1:dm1:j_idt')]//td[text()='Package Codes']");
	   //OPERA Cloud Administration
	    public By OperaCloudAdministration=By.xpath("//h1[text()='OPERA Cloud Administration']");	    
	    //Navigate to Transaction Management
	    public By  linkTransactionManagement=By.xpath("//div[contains(@id,'odec_drpmn_mb_mn::ScrollBox')]//td[text()='Transaction Management']");
        //Navigate to Transaction Group
	    public By linkTransactionGroup=By.xpath("//tr[contains(@id,'pt1:oc_pg_pt:pt_pt1:dm1:j_idt')]//td[text()='Transaction Groups']");







}
