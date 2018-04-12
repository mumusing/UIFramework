package com.oracle.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseHelper 
{
	
	
	
	private Connection connection=null;
	private Statement  statement=null;
    private String driver="jdbc.odbc.driver.OracleDriver";
    DbDetails dbDetails=Config.getDbDetails();
	String url="jdbc:oracle:thin:@//"+dbDetails.getDB_HOST()+":"+dbDetails.getDB_PORT()+"/"+dbDetails.getDB_SERVER();

    /**
     * This method load jdbc driver
     */
	public void loadDriver()
	{
		try 
		{
			Class.forName(driver);
			Report.log(Status.Pass, "Driver loaded sucessfully");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while loading sucessfully: "+e);
			e.printStackTrace();
		}
	}
	/**
	 * This method execute select query
	 * @param query
	 * @return
	 */
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet resultSet=null;
		try
		{
			//Load Oracle Driver
			loadDriver();
			//Create Connection to data base
			getConnection(url, dbDetails.getDB_USER(), dbDetails.getDB_PWD());
			//Create Statement
			Statement statement=createStatement();
			//Get Result set
		    resultSet=statement.executeQuery(query);	
		    Report.log(Status.Info, "Query executed sucessfully: "+query);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		    Report.log(Status.Fail, "Failed while executing query: "+query+" :because of exception: "+e);
		}
		return resultSet;
	}
	/**
	 * This Method execute Action Query
	 * @param query
	 * @return
	 */
	public boolean executeActionQuery(String query)
	{
        boolean isSucessfully=false;
		try
		{
			//Load Oracle Driver
			loadDriver();
			//Create Connection to data base
			getConnection(url, dbDetails.getDB_USER(), dbDetails.getDB_PWD());
			//Create Statement
			Statement statement=createStatement();
			//Get Result set
		    int status=statement.executeUpdate(query);	
		    isSucessfully=true;
		    Report.log(Status.Info, "Action Query executed sucessfully: "+query);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		    Report.log(Status.Fail, "Failed while executing ACTION query: "+query+" :because of exception: "+e);
		    isSucessfully=false;
		}
		return isSucessfully;
	}
	
	/**
	 * This method established connection to provided data base and return connection
	 * @param url
	 * @param userName
	 * @param password
	 * @return
	 */
	public Connection getConnection(String url,String userName,String password)
	{
		
		if (connection==null)
		{
			try
			{
				connection=DriverManager.getConnection(url,userName,password);
			} 
			catch (Exception e)
			{
				// TODO: handle exception
				
			}
		}
		return connection;
	}
	/**
	 * This method create statement
	 * @return
	 */
	public Statement createStatement()
	{
		if (statement==null)
		{
			try
			{
				statement=connection.createStatement();
				Report.log(Status.Pass, "--------------Statement created sucessfully-------");
			} 
			catch (Exception e)
			{
				// TODO: handle exception
				Report.log(Status.Fail, "-------Failed while creating Stement-------");
			}			
		}
		return statement;
	}
	
	
	
}
