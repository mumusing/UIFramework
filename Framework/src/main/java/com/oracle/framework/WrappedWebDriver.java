package com.oracle.framework;

import java.nio.file.WatchEvent.Kind;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByLinkText;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByTagName;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.hash.HashingInputStream;

public class WrappedWebDriver implements WebDriver,JavascriptExecutor,FindsById,FindsByClassName,FindsByCssSelector,FindsByLinkText,FindsByName,FindsByTagName,FindsByXPath,HasCapabilities,HasInputDevices,TakesScreenshot
{

	
	
    private	WebDriver WebDriver;
	EventFiringWebDriver driver ;
	EnvDetails envDetails;
	String browser;
	public WrappedWebDriver()
	{
		envDetails=Config.getEnvDetails();
		browser=envDetails.getBrowser();
		try
		{
		if (browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("disable-infobars"); 
		//	options.addArguments("chrome.switches","--disable-extensions");
//			DesiredCapabilities capabilities=DesiredCapabilities.chrome();
//			capabilities.setBrowserName(browser);
//			capabilities.setPlatform(Platform.WINDOWS);
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.out.println(System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
           // driver=new ChromeDriver(options);
			WebDriver=new ChromeDriver(options);
	         		
		}
		else if (browser.equalsIgnoreCase("Firefox")) 
		{
			System.out.println(System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
//			DesiredCapabilities caps = DesiredCapabilities.firefox();
//			caps.setBrowserName("firefox");
//			caps.setPlatform(Platform.WINDOWS); 
			WebDriver = new FirefoxDriver();			
		}
		else if (browser.equalsIgnoreCase("IE")) 
		{
			//Set Desired Capabilities
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			WebDriver=new InternetExplorerDriver(caps);
		}
		driver=new EventFiringWebDriver(WebDriver);
		WrappedWebDriverEventListener eventListener=new WrappedWebDriverEventListener();
		driver.register(eventListener);	
		}
		catch(Exception e)
		{
			Report.log(Status.Fail, "Failed while loading driver");
		}
		
	}
	
	
	
	public void get(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}

	public String getCurrentUrl()
	{
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return driver.findElements(by);
	}

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return driver.findElement(by);
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}

	public void close() {
		// TODO Auto-generated method stub
		driver.close();
	}

	public void quit() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return driver.switchTo();
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return driver.navigate();
	}

	public Options manage() {
		// TODO Auto-generated method stub
		return driver.manage();
	}

	public Object executeScript(String script, Object... args) {
		// TODO Auto-generated method stub
		return ((JavascriptExecutor)driver).executeScript(script, args);
	}

	public Object executeAsyncScript(String script, Object... args) {
		// TODO Auto-generated method stub
		return ((JavascriptExecutor)driver).executeAsyncScript(script, args);
	}

	public WebElement findElementById(String using) {
		// TODO Auto-generated method stub
		return driver.findElement(By.id(using));
	}

	public List<WebElement> findElementsById(String using) {
		// TODO Auto-generated method stub
		return driver.findElements(By.id(using));
	}

	public WebElement findElementByXPath(String using) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath(using));
	}

	public List<WebElement> findElementsByXPath(String using) {
		// TODO Auto-generated method stub
		return driver.findElements(By.xpath(using));
	}

	public WebElement findElementByTagName(String using) {
		// TODO Auto-generated method stub
		return driver.findElement(By.tagName(using));
	}

	public List<WebElement> findElementsByTagName(String using) {
		// TODO Auto-generated method stub
		return driver.findElements(By.tagName(using));
	}

	public WebElement findElementByName(String using) {
		// TODO Auto-generated method stub
		return driver.findElement(By.name(using));
	}

	public List<WebElement> findElementsByName(String using) {
		// TODO Auto-generated method stub
		return driver.findElements(By.name(using));
	}

	public WebElement findElementByLinkText(String using) {
		// TODO Auto-generated method stub
		return driver.findElement(By.linkText(using));
	}

	public List<WebElement> findElementsByLinkText(String using) {
		// TODO Auto-generated method stub
		return driver.findElements(By.linkText(using));
	}

	public WebElement findElementByPartialLinkText(String using) {
		// TODO Auto-generated method stub
		return driver.findElement(By.partialLinkText(using));
	}

	public List<WebElement> findElementsByPartialLinkText(String using) {
		// TODO Auto-generated method stub
		return driver.findElements(By.partialLinkText(using));
	}

	public WebElement findElementByCssSelector(String using) {
		// TODO Auto-generated method stub
		return driver.findElement(By.cssSelector(using));
	}

	public List<WebElement> findElementsByCssSelector(String using) {
		// TODO Auto-generated method stub
		return driver.findElements(By.cssSelector(using));
	}

	public WebElement findElementByClassName(String using) {
		// TODO Auto-generated method stub
		return driver.findElement(By.className(using));
	}

	public List<WebElement> findElementsByClassName(String using) {
		// TODO Auto-generated method stub
		return driver.findElements(By.className(using));
	}

	public Capabilities getCapabilities() {
		// TODO Auto-generated method stub
		HasCapabilities capabilities=null;
		capabilities=(HasCapabilities)driver;
		return capabilities.getCapabilities();
	}

	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		return screenShot.getScreenshotAs(target);
	}

	public Keyboard getKeyboard() {
		// TODO Auto-generated method stub
		return ((HasInputDevices)driver).getKeyboard();
	}

	public Mouse getMouse() {
		// TODO Auto-generated method stub
		return ((HasInputDevices)driver).getMouse();
	}

}
