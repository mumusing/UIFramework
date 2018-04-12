package com.oracle.framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config
{
	
	
   /**
    * This method read all the config data and set those in corresponding classes
    * @param configFile
    * @throws IOException
    */
	private static EnvDetails env;
	private static DbDetails dbDetails;
	private static String excelPath;
	private static String configPath="C:\\workspace\\Opera Cloud\\Input\\Config.properties";
	private static String sheetName;
	public static void readConfigFile() throws IOException
	{
		
		//Load config file				
		//filePath=configFile;
		FileReader reader=new FileReader(configPath);		
		Properties properties=new Properties();
		properties.load(reader);
		
		
		
		//Set Env Details
	    env=new EnvDetails();
		env.setUrl(properties.getProperty("url"));
		env.setUserName(properties.getProperty("userName"));
		env.setPassword(properties.getProperty("password"));
		env.setBrowser(properties.getProperty("browser"));

		//Set Password Details
	    dbDetails=new DbDetails();
		dbDetails.setDB_HOST(properties.getProperty("nplqadb7.us.oracle.com"));
		dbDetails.setDB_PORT(properties.getProperty("1521"));
		dbDetails.setDB_PWD(properties.getProperty("V46_ASP_CLOUD"));
		dbDetails.setDB_SCHEMA(properties.getProperty("V46_ASP_CLOUD"));
		dbDetails.setDB_SERVER(properties.getProperty("opera2"));
		dbDetails.setDB_USER(properties.getProperty("V46_ASP_CLOUD"));
		dbDetails.setSERVICE_NAME(properties.getProperty("O9QA"));		
		
		//Excel path, Config Path
		excelPath=properties.getProperty("ExcelFileLocation");
		sheetName=properties.getProperty("SheetName");
	}
	
	public static EnvDetails getEnvDetails()
	{
		try
		{
		if (env==null) 
		{
			readConfigFile();
			
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return env;
	}
	public static DbDetails getDbDetails()
	{
		try
		{
		if (dbDetails==null)
		{
			 readConfigFile();
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return dbDetails;
	}
	
	public static String getExcelPath()
	{
		try
		{
		if (excelPath==null)
		{
			 readConfigFile();
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return excelPath;
	}
	public static String getSheetName()
	{
		try
		{
		if (sheetName==null)
		{
			 readConfigFile();
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return sheetName;
	}
}
