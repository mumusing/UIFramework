package com.oracle.framework;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oracle.custom.exceptions.ElementNotFoundException;

public class Utils 
{
	
	
   static WebDriver driver;
	public Utils(WebDriver driver)
	{
		this.driver=driver;
	}
	/**
	 * This method 
	 * @param fullPath
	 */
	public static void takeScreenShot(String fullPath)
	{
		try 
		{
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(fullPath));
		}
		catch (Exception e)
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while taking screen shot");
		}		
	}
	/**
	 * This method explicitly wait for elementToBeClickable, presenceOfElementLocated,visibilityOfElementLocated and return the element object
	 * @param locator
	 * @param timeoutInSeconds
	 * @param waitType
	 * @throws Exception 
	 */
	public static boolean waitForElement(By locator,int timeoutInSeconds,WaitTypes waitType) throws Exception
	{
		WebDriverWait explicitWait=new WebDriverWait(driver, timeoutInSeconds);
		WebElement element= null;
		boolean isWaitOver=false;
		try 
		{
			switch (waitType) 
			{
			
            case elementToBeClickable:
            	element=explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
            	isWaitOver=true;
				break;	
		    							
           case presenceOfElementLocated:
        	   element=explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        	   isWaitOver=true;
				break;	
							
           case visibilityOfElementLocated:
        	   element=explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        	   isWaitOver=true;
				break;	
				
			default:
				isWaitOver=false;
				//throw new ElementNotFoundException("Not valid wait Type");
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			Report.log(Status.FAIL, "Element did not appeared on page: "+e);
			isWaitOver=false;
		}
		return isWaitOver;
	}
	
	
	/**
	 * This method switch to frame of nameOrId
	 * @param nameOrId
	 * @throws Exception 
	 */
	public static void switchToFrame(String nameOrId) throws Exception
	{
		try
		{
		driver.switchTo().frame(nameOrId);
		Report.log(Status.Info, "Switched to frame of nameOrId: "+nameOrId);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while switching to frame: "+e.toString());
			throw e;
		}
	}
	/**
	 * This method switch to frame of given index
	 * @param index
	 * @throws Exception 
	 */
	public static void switchToFrame(int index) throws Exception
	{
		try 
		{
			driver.switchTo().frame(index);
			Report.log(Status.Info, "Switched to frame with index: "+index);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while switching to frame of index: "+e.toString());
			throw e;
		}	
	}
	/**
	 * This method switch to frame of web element
	 * @param by
	 * @throws Exception 
	 */
	public static void switchToFrame(By by) throws Exception
	{
		try
		{
			driver.switchTo().frame(driver.findElement(by));
			Report.log(Status.Info, "Switched to frame with by");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while switching to frame with web element: "+e.toString());
			throw e;
		}
	}
	/**
	 * This method switch to default frame
	 * @throws Exception 
	 */
	public static void switchToDefaultFrame() throws Exception
	{
		try 
		{
			driver.switchTo().defaultContent();
			Report.log(Status.Info, "Switched to default frame");
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while switching to default fail: "+e.toString());
			throw e;
		}
	}
	/**
	 * This method switch to 
	 * @param parentHandle
	 * @throws Exception 
	 */
	public static void switchToWindow(String parentHandle) throws Exception
	{
		try
		{
			Set<String>handles=driver.getWindowHandles();
			
			for (String string : handles) 
			{
				if (!string.equals(parentHandle)) 
				{
					driver.switchTo().window(string);
					Report.log(Status.Info, "Switched to window handle: "+string);
					break;
				}
			}
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while switching to window handle: "+e.toString());
			throw e;
		}
		
	}
	/**
	 * Switch to parent window handle
	 * @param parentHandle
	 * @throws Exception
	 */
	public static void switchToParentWindow(String parentHandle) throws Exception
	{
	   try
	   {
		driver.switchTo().window(parentHandle);
		Report.log(Status.Info, "Switched to parent handle");
	   } 
	   catch (Exception e) 
	   {
		// TODO: handle exception
		   Report.log(Status.Fail, "Failed while switching to parent window: "+e.toString());
		   throw e;
	    }	
	}
   /**
    * Accept Alert
    */
	public void acceptAlert()
	{
		try
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
			Report.log(Status.Info, "Accepted Alert");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			
		}
	}
	/**
	 * Dismiss Alert
	 */
	public void dismissAlert()
	{
		try
		{
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
			Report.log(Status.Info, "Accepted Alert");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			
		}
	}
	/**
	 * This method first move to main element and then move to sub element and click
	 * @param mainElement
	 * @param subElement
	 * @throws Exception
	 */
	public static void mouseHoverAndClick(WebElement mainElement,WebElement subElement) throws Exception
	{
		Actions action=new Actions(driver);
		
		try 
		{
			action.moveToElement(mainElement).build();
			Report.log(Status.Info, "Moved to main element");
			Thread.sleep(2000);
			action.moveToElement(subElement).click().perform();
			Report.log(Status.Info, "Moved to sub element and click");
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while performing mouse hover element");
			throw e;
		}
	}
	/**
	 * This method move to given element and perform click operation
	 * @param webElement
	 * @throws Exception
	 */
	public static void moveToElementAndClick(WebElement webElement) throws Exception
	{
		Actions action=new Actions(driver);
		try
		{
			action.moveToElement(webElement).click().perform();			
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while performing mouse hover element");
			throw e;
		}	
	}
	
	
	/**
	 * This method move one drag and drop one element to other
	 * @param source
	 * @param target
	 * @throws Exception
	 */
	public static void dragAndDropElement(WebElement source,WebElement target) throws Exception
	{
		Actions action=new Actions(driver);
        try 
        {
        	action.clickAndHold(source).perform();
        	Thread.sleep(2000);
        	action.moveToElement(target).perform();
        	Thread.sleep(2000);
        	action.release(target).perform();
        	Report.log(Status.Info, "Move element: "+source.getText()+" To "+target.getText());
        	
		} 
        catch (Exception e)
        {
			// TODO: handle exception
        	Report.log(Status.Fail, "Failed while moving one elemet to other: "+e);
        	throw e;
		}		
	}
	/**
	 * Move element to x or y directions
	 * @param element
	 * @param xOffset
	 * @param yOffset
	 * @throws Exception
	 */
	public static void slideElement(WebElement element,int xOffset,int yOffset) throws Exception
	{
		Actions action=new Actions(driver);
		try 
		{
			action.dragAndDropBy(element, xOffset, yOffset);
			Report.log(Status.Info, "Moved elemnt to"+xOffset+" : "+yOffset);
		}
		catch (Exception e)
		{
			// TODO: handle exception
        	Report.log(Status.Fail, "Failed while moving elemet : "+e);
            throw e;
		}
		
	}
	/**
	 * This method clicked element using java script
	 * @param element
	 * @throws Exception
	 */
	public static void clickUsingJavaScript(WebElement element) throws Exception
	{
		try
		{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		Report.log(Status.Info, "Clicked element using script successfully");
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	/**
	 * This method return window window inner height
	 * @return
	 */
	public static long getWindowInnerHeight()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		long height=(Long)js.executeScript("return window.innerHeight;");
		return height;
	}
	/**
	 * This method return window inner width
	 * @return
	 */
	public static long getWindowinnerWidth()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		long width=(Long)js.executeScript("return window.innerWidth;");
		return width;
	}
	
	
}
