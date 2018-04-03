package com.oracle.framework;

public class BaseTest {
	public static WrappedWebDriver driver;
	public static ExcelHelper excelHelper;
	public static Utils utils;
	public static DataProvider dataProvider;
	public static EnvDetails envDetails;
	public static DbDetails dbDetails;
	public static String testName;

	/**
	 * This method initialize driver, read excel, read config file, start extent
	 * report
	 * 
	 * @param testName
	 * @param description
	 * @param categories
	 * @throws Exception
	 */
	public static void initialize(String testName, String description, String categories) throws Exception {
		try {
			// Initialize driver
			testName = testName;
			// This method start extent report
			Report.startExtentReport(testName, description, categories);
			// Read Config file
			Config.readConfigFile();
			envDetails = Config.getEnvDetails();
			dbDetails = Config.getDbDetails();

			// This read excel file
			String sheetName = Config.getSheetName();
			// this.dataProvider=DataProvider.readTestData(testName);
			dataProvider = DataProvider.readTestData(testName);
			// Get driver
			driver = getDriver();
			// new BasePage(driver);
			utils = new Utils(driver);
			driver.manage().window().maximize();
			driver.get(envDetails.getUrl());

		} catch (Exception e) {
			// TODO: handle exception
			Report.log(Status.Fail, "Field while initializing becaus eof exception: " + e);
			throw e;
		}
	}

	/**
	 * This method end extent report
	 */
	public static void endReport() {

		Report.endReport();
	}

	/**
	 * This method Get driver object
	 * 
	 * @return
	 */
	public static WrappedWebDriver getDriver() {
		if (driver == null) {
			driver = new WrappedWebDriver();
		}
		return driver;
	}

	public static void quit() {

		driver.quit();
	}
}
