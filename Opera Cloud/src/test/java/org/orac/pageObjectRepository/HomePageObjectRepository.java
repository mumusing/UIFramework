package org.orac.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oracle.framework.BasePageObjectRepository;

public class HomePageObjectRepository extends BasePageObjectRepository {

	public HomePageObjectRepository(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Home title
	public By homeTitle = By.xpath("//title[text()='OPERA Cloud']");
	// Show menu link
	public By link_ShowMenu = By.xpath("//img[@title='Show Menu']");

	//Logout locators
	public By link_ShowUserOptions=By.xpath("//a[@title='Show User Options']");
	public By Logout_Button=By.xpath("//div[@id='pt1:oc_pg_pt:pt_pt1:oc_pg_lgout']//span[text()='Logout']");
	
	
	
}
