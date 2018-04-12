package com.oracle.framework;

import org.openqa.selenium.WebDriver;

public class BasePageObjectRepository 
{
	
	
	
	WebDriver driver;
	public BasePageObjectRepository(WebDriver driver)
	{
		this.driver=driver;
	}
}
