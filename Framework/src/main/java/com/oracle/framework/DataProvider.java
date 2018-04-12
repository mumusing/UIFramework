package com.oracle.framework;

import java.util.HashMap;

public class DataProvider 
{
	
	
    protected HashMap<String, String>dataProvider=new HashMap<String, String>();
    
    /**
     * Set data to data provider
     * @param key
     * @param value
     */
    public void setData(String key,String value)
    {
    	if (!dataProvider.containsKey(key)) 
    	{
    		dataProvider.put(key, value);
		}
    	
    }
    /**
     * This method get data from data provider
     * @param key
     * @return
     */
	public String getData(String key)
	{
		if (dataProvider.containsKey(key))
		{
			return dataProvider.get(key);
		}
		return null;
	}
	/**
	 * This method load test data for given test case row
	 * @param testName
	 * @return
	 */
	public static DataProvider readTestData(String testName)
	{
		DataProvider dp=null;		
		String excelName=Config.getExcelPath();
		ExcelHelper.setExcelFile(excelName, "testData");
		int row=ExcelHelper.getTestRowNumber(testName);
		if (row==-1) 
		{
			Report.log(Status.Info, "Test case with name: "+testName+" :does not found in Data Sheet: "+testName);
			//return;
		}
		dp=ExcelHelper.load(row);	
		return dp;
	}		
}
