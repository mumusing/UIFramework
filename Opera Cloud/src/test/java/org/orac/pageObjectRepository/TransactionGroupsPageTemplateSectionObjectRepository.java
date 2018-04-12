package org.orac.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oracle.framework.BasePageObjectRepository;

public class TransactionGroupsPageTemplateSectionObjectRepository extends BasePageObjectRepository
{
	
	

	public TransactionGroupsPageTemplateSectionObjectRepository(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	       //New Link on Template
			public By NewLink=By.xpath("//span[contains(@id,'oc_pnl_lstng_tmpl:oc_pnl_tmpl:oc_pnl_tlbr_axns:odec_axn_lnks')]//span[text()='New']");
			//Revenue Type
			public By RevenueRadioButton=By.xpath("//input[contains(@id,'oc_pnl_cmp:oc_pnl_tmpl:pt_pt1:fe1:sbr1:odec_sbr_sbr::content')]");
			//Payment Type
			public By PaymentRadioButton=By.xpath("//input[contains(@id,'oc_pnl_cmp:oc_pnl_tmpl:pt_pt1:fe1:sbr2:odec_sbr_sbr::content')]");
			//Payment Type
			public By WrapperRadioButton=By.xpath("//input[contains(@id,'oc_pnl_cmp:oc_pnl_tmpl:pt_pt1:fe1:sbr3:odec_sbr_sbr::content')]");
		    //Code TextBox
			public By CodeTextBox=By.xpath("//input[contains(@id,'oc_pnl_cmp:oc_pnl_tmpl:pt_pt1:fe2:ic1:occ_ic_it:odec_it_it::content')]");
			//Description Text Box
			public By DescriptionTextBox=By.xpath("//input[contains(@id,'oc_pnl_cmp:oc_pnl_tmpl:pt_pt1:fe2:ic1:occ_ic_it:odec_it_it::content')]");
		    //Sequence
			public By Sequence=By.xpath("//a[contains(@id,'oc_pnl_cmp:oc_pnl_tmpl:pt_pt1:fe4:sn1:occ_sn_in:odec_in_it:inc')]");
		    //Save Button
			public By SaveButton=By.xpath("//div[contains(@id,'pt_pt1:oc_pnl_axnbr:odec_axn_br_i:1:odec_axn_br_axn_btn')]");

	
			//Transaction Group Search Page
			public By CodeSearchTextbox=By.xpath("//input[contains(@id,'dc_s2:fe1:lov1:odec_lov_itLovetext::content')]");
			public By TypeDropDown=By.xpath("//select[contains(@id,'dc_s2:fe2:lov2:odec_lov_socLov::content')]");
            public By SearchButton=By.xpath("oc_pnl_lstng_vw_srch_swtchr:dc_s2:odec_srch_swtchr_advncd_srch_btn");
            
	
	
	
	
	
}
