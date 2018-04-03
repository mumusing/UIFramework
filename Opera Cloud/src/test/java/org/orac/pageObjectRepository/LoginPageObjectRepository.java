package org.orac.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oracle.framework.BasePageObjectRepository;

public class LoginPageObjectRepository extends BasePageObjectRepository
{
	public LoginPageObjectRepository(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    
	
	
	//User Name text Box
  public  By txt_username=By.id("username");     
    //Password text Box
  public  By txt_password=By.id("password"); 
    //Login Button TextBox
  public  By button_Login=By.xpath("//button[@class='form-button']");
	
}
