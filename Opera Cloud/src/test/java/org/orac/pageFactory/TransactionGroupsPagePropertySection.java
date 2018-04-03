package org.orac.pageFactory;

import org.openqa.selenium.WebDriver;
import org.orac.pageObjectRepository.TransactionGroupsPagePropertySectionObjectRepository;

import com.oracle.framework.BasePage;
import com.oracle.framework.BasePageObjectRepository;

public class TransactionGroupsPagePropertySection extends BasePage<TransactionGroupsPagePropertySectionObjectRepository>
{

	public TransactionGroupsPagePropertySection(WebDriver driver) {
		super(driver, new TransactionGroupsPagePropertySectionObjectRepository(driver));
		// TODO Auto-generated constructor stub
	}



}
