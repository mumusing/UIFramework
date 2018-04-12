package org.orac.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.orac.pageObjectRepository.TransactionGroupsPageTemplateSectionObjectRepository;

import com.oracle.framework.BasePage;

public class TransactionGroupsPageTemplateSection extends BasePage<TransactionGroupsPageTemplateSectionObjectRepository>
{

	public TransactionGroupsPageTemplateSection(WebDriver driver) 
	{
		super(driver, new TransactionGroupsPageTemplateSectionObjectRepository(driver));
		// TODO Auto-generated constructor stub
	}
   	

	
	
	
	/**
	 * This method click on new link present on template section
	 */
	public void clicknewLink()
	{
		WebElement newElement=driver.findElement(ObjectRepository.NewLink);
		newElement.click();
	}
	/**
	 * This method click revenue type radio button
	 */
	public void clickRevenueType()
	{
		driver.findElement(ObjectRepository.RevenueRadioButton).click();
	}
	/**
	 * This method select Payment Type radio button
	 */
	public void clickPaymentType()
	{
		driver.findElement(ObjectRepository.PaymentRadioButton).click();
	}
	/**
	 * This method select Wrapper Type radio button
	 */
	public void clickWrapperType()
	{
		driver.findElement(ObjectRepository.WrapperRadioButton).click();
	}
	/**
	 * This method send code
	 */
	public void enterCode(String code)
	{
		driver.findElement(ObjectRepository.CodeTextBox).sendKeys(code);
	}
	/**
	 * This method enter description into method
	 * @param description
	 */
	public void enterDescription(String description)
	{
		driver.findElement(ObjectRepository.DescriptionTextBox).sendKeys(description);
	}
	/**
	 * This method click on Save button
	 */
	public void clickSaveButton()
	{
		driver.findElement(ObjectRepository.SaveButton).click();
	}
	/**
	 * This method click Increase sequence by 1
	 */
	public void clickSequence()
	{
		driver.findElement(ObjectRepository.Sequence).click();
	}
	
}
