package org.orac.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oracle.framework.BasePageObjectRepository;

public class PackageCodesPageObjectRepository extends BasePageObjectRepository
{
	
	
	public By titlePackageCode=By.xpath("//h1[text()='Package Codes']");
	public PackageCodesPageObjectRepository(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
