package com.oracle.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WrappedWebDriverEventListener implements WebDriverEventListener
{
    
	private String elementText;
	private String elementValue;
	private String elementTitle;
	
	
	private String txtElementName;
	private String txtElementPlaceholder;
	private String txtElementTitle;
	
	
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver)
	{
		// TODO Auto-generated method stub
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver)
	{
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) 
	{
		// TODO Auto-generated method stub
		//Report.log(Status.Info, "Executing before click on method");
		elementText=element.getText();
		elementValue=element.getAttribute("value");
		elementTitle=element.getAttribute("title");
	}

	public void afterClickOn(WebElement element, WebDriver driver)
	{
		if (elementText!=null)
		{
			Report.log(Status.Info, "Clicked element: "+elementText);
		} 
		else if(elementTitle!=null)
		{
			Report.log(Status.Info, "Clicked element: "+elementValue);
		}
		else if(elementValue!=null)	
		{
			Report.log(Status.Info, "Clicked element: "+elementTitle);
		}
			
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		element.clear();
		
		txtElementName=element.getAttribute("name");
		txtElementPlaceholder=element.getAttribute("placeholder");
		txtElementTitle=element.getAttribute("title");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) 
	{
		if (txtElementPlaceholder!=null)
		{
			Report.log(Status.Info, "Entered "+element.getAttribute("placeholder")+" : "+keysToSend[0]);
		} 
		else if(elementTitle!=null)
		{
			Report.log(Status.Info, "Entered "+element.getAttribute("placeholder")+" : "+keysToSend[0]);
		}
		else if(txtElementName!=null)	
		{
			Report.log(Status.Info, "Entered "+element.getAttribute("placeholder")+" : "+keysToSend[0]);
		}
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		Report.log(Status.FAIL, "Exception occured: "+throwable.toString());
	}

}
