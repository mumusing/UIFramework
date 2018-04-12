package org.orac.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.orac.pageObjectRepository.LoginPageObjectRepository;

import com.oracle.framework.BasePage;
import com.oracle.framework.Config;
import com.oracle.framework.EnvDetails;
import com.oracle.framework.Report;
import com.oracle.framework.Status;
import com.oracle.framework.WrappedWebDriver;

public class LoginPage extends BasePage<LoginPageObjectRepository>
{
	
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver,new LoginPageObjectRepository(driver));
		// TODO Auto-generated constructor stub
	}
	
    
    
    /**
     * This method enter user name
     * @param userId
     */
    public void enterUserName(String userId)
    {
    	driver.findElement(ObjectRepository.txt_username).sendKeys(userId);
    	
    	//Report.log(Status.Info, "Enter user name: "+userId);
    }
    /**
     * This method enter the password
     * @param password
     */
    public void enterPassword(String password)
    {
    	driver.findElement(ObjectRepository.txt_password).sendKeys(password);
    	//Report.log(Status.Info, "Enter password: "+"*******");
    }
    /**
     * Click Login Button
     */
    public void clickLoginButton()
    {
    	driver.findElement(ObjectRepository.button_Login).click();
    	//Report.log(Status.Info, "Click Sign up Button");
    }
    /**
     * This method login to application by reading user name and password
     */
    
    public HomePage loginToApplication()
    {
    	EnvDetails envDetails=Config.getEnvDetails();
    	//Enter user name
    	enterUserName(envDetails.getUserName());
    	//Enter password
    	enterPassword(envDetails.getPassword()); 	
    	//Click Login Button
    	clickLoginButton();
		return new HomePage(driver);
    }
    
    
    
}
