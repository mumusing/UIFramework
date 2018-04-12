package com.oracle.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrappedWebDriverWait extends WebDriverWait
{
	
	
	
	WebDriverWait webDriverWait;
	public WrappedWebDriverWait(WebDriver driver, long timeOutInSeconds)
	{
		super(driver, timeOutInSeconds);
		// TODO Auto-generated constructor stub
	}
	public void wait2(WebElement element)
	{
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
		
	//	webDriverWait.until(ExpectedConditions.v)
	}
	
	
	
	
	
	
}
