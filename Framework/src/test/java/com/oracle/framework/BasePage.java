package com.oracle.framework;

import org.openqa.selenium.WebDriver;

public class BasePage<TObjectRepository>
{
 public	TObjectRepository ObjectRepository;
	public  WebDriver driver;
	public BasePage(WebDriver driver,TObjectRepository repository)
	{
		this.driver=driver;
		ObjectRepository=repository;
	}
	
	
}
