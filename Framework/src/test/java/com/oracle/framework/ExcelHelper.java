package com.oracle.framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.LogStatus;

public class ExcelHelper 
{
	
	private static XSSFWorkbook excelWorkBook;
	private static XSSFSheet excelSheet;
	private static int rowNumbers=100000;
	
	/**
	 * This method get data from particular cell
	 * @param row
	 * @param column
	 * @return
	 */
	public static String getCellData(int row ,int column)
	{
		String cellData="";
		try
		{
		XSSFRow rowCell=excelSheet.getRow(row);
		XSSFCell colCell=rowCell.getCell(column);
		if (colCell!=null)
		{
		    cellData=colCell.getStringCellValue();
		}
		}
		catch(Exception e)
		{
			Report.log(Status.Fail, "Failed while getting data from: "+row+" :"+column);
			return null;
		}
		return cellData;
	}
	/**
	 * Get Date value from excel sheet
	 * @param row
	 * @param column
	 * @return
	 */
	public static String getDateCellData(int row,int column)
	{
		 String dateStringFormat="";
		try
		{
			XSSFCell colCell=excelSheet.getRow(row).getCell(column);
			DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		    Date	dateValue=colCell.getDateCellValue();
		    dateStringFormat=dateFormat.format(dateValue);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while getting cell date value because of exception: "+e);
			return "";
		}
		return dateStringFormat;
		
	}
	
	/**
	 * This method return the row number of test case
	 * @param testName
	 * @return
	 */
	public static int getTestRowNumber(String testName)
	{
		int rowNumber=-1;
		try 
		{
			for (int row = 0; row < rowNumbers; row=row+4)
			{
				String cellValue=getCellData(row,0);
                if (cellValue.equalsIgnoreCase(testName))
                {
                	rowNumber=row;
                	break;
				}
			}			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			return -1;
		}
		
		return rowNumber;
		
	}
	/**
	 * This method read the data from excel sheet from particular row
	 * @param row
	 * @return
	 */
	public static DataProvider load(int row)
	{
		DataProvider dp=new DataProvider();
		boolean isDataRead=false;
		int column=2;
		if (row==-1) 
		{
			return dp;
		}
		while (!isDataRead) 
		{
			String key=getCellData(row,column);
			String value=getCellData(row+1,column);
            if ((key!=null&&value!=null)&&(!key.isEmpty()&&!value.isEmpty())) 
            {
            	dp.setData(key, value);
			}
			if (getCellData(row, 0).equalsIgnoreCase(getCellData(row+2, column)))
			{
				isDataRead=true;
			}
			column++;
		}
		return dp;
	}
	
	
	/**
	 * This method load excel and set to excel sheet
	 * @param path
	 * @param sheet
	 */
	public static void	 setExcelFile(String path,String sheet)
	{
		try
		{
			FileInputStream file=new FileInputStream(path);
			excelWorkBook=new XSSFWorkbook(file);
			excelSheet=excelWorkBook.getSheet(sheet);
			
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while connecting and getting sheet name: "+e);
		}		
	}	
	/**
	 * Write String data to excel sheets
	 * @param data
	 * @param row
	 * @param column
	 */
	public static void writeToExcel(String data,int row,int column)
	{
		FileOutputStream fileStream=null;
		try 
		{
			XSSFRow cellRow=excelSheet.getRow(row);
			XSSFCell cell=cellRow.getCell(column);
			if (cell==null) 
			{
				cell=cellRow.createCell(column);
				cell.setCellValue(data);
			}
			else
			{
				cell.setCellValue(data);
			}
			
		    fileStream=new FileOutputStream("excelFile"+"sheetName");
			excelWorkBook.write(fileStream);
			fileStream.flush();
			fileStream.close();
			
		} 
		catch (Exception e) 
		{
			Report.log(Status.Fail, "Failed while writing data to file: "+e);
		}
		
		
	}
	/**
	 * This method write data into excel
	 * @param data
	 * @param row
	 * @param column
	 */
	public static void writeDateToExcel(double data,int row,int column)
	{
		FileOutputStream fileStream=null;

		try 
		{
			XSSFRow rowCell=excelSheet.getRow(row);
			XSSFCell colCell=rowCell.getCell(column);
			if (colCell==null) 
			{
				colCell=rowCell.createCell(column);
				colCell.setCellValue(data);
			} 
			else
			{
				colCell.setCellValue(data);
			}			
	
		
		fileStream=new FileOutputStream("excelFile"+"sheetName");
		excelWorkBook.write(fileStream);
		fileStream.flush();
		fileStream.close();
	}
		catch (Exception e) 
		{
			// TODO: handle exception
			Report.log(Status.Fail, "Failed while writing data to file: "+e);
		}
	}
	
	
	
	
}
