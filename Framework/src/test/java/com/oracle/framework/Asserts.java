package com.oracle.framework;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Asserts
{
	static SoftAssert softAssert;
	/**
	 * This method validate condition and stop execution if condition fails
	 * @param condition
	 * @param message
	 * @throws Exception 
	 */
    public static void assertTrue(boolean condition,String message) throws  Exception
    {
    	try
    	{
			Assert.assertTrue(condition, message);
			Report.log(Status.PASS, message);
		} 
    	catch (Exception e)
    	{
			// TODO: handle exception
    		Report.log(Status.FAIL, "Some exception occured while validating condition: "+message+" :because exception: "+e);
    		throw e;
		}
    }
   /**
    * This method compare two string value and stop if condition fails
    * @param actual
    * @param expected
    * @throws Exception
    */
    public static void assertEqual(String actual,String expected) throws Exception
    {
    	try 
    	{
    		Assert.assertEquals(actual, expected);
    		Report.log(Status.PASS, "Sucessfully compared: "+actual+"  :  "+expected );
		}
    	catch (Exception e) 
    	{
			// TODO: handle exception
    		Report.log(Status.FAIL, "Failed while comparing: "+actual+" : "+expected+" because of exception: "+e);
    		throw e;
		}
    }
    
    
    
    
	/**
	 * This method validate condition and stop execution if condition fails
	 * @param condition
	 * @param message
	 * @throws Exception
	 */
    public static void assertFalse(boolean condition,String message) throws Exception
    {
    	try
    	{
			Assert.assertFalse(condition, message);
			Report.log(Status.PASS, message);
		} 
    	catch (Exception e)
    	{
			// TODO: handle exception
    		Report.log(Status.FAIL, "Some exception occured while validating condition: "+message+" :because exception: "+e);
    		throw e;
		}  	
    }
    /**
     * This method verify condition and if condition fail execution will not stop 
     * @param condition
     * @param message
     * @throws Exception 
     */
    public static void verifyTrue(boolean condition,String message) throws Exception
    {
    	if (softAssert==null) 
    	{
    		 softAssert=new SoftAssert();
		}
       
    	try 
    	{
    		softAssert.assertTrue(condition,message);
    		Report.log(Status.Pass, message);
    		
		} 
    	catch (Exception e)
    	{
			// TODO: handle exception
    		Report.log(Status.FAIL, message);
    		throw e;
		}    	
    }
    /**
     * This method verify condition and if condition true execution will not stop 
     * @param condition
     * @param message
     * @throws Exception
     */
    
    public static void verifyFalse(boolean condition,String message) throws Exception
    {
    	if (softAssert==null) 
    	{
    		 softAssert=new SoftAssert();
		}
       
    	try 
    	{
    		softAssert.assertTrue(condition,message);
    		Report.log(Status.Pass, message);
    		
		} 
    	catch (Exception e)
    	{
			// TODO: handle exception
    		Report.log(Status.FAIL, message);
    		throw e;
		}    	
    }
    
    
    
    }
