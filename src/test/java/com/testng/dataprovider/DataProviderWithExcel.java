package com.testng.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.constants.FrameworkConstants;

public class DataProviderWithExcel {

	// @Test(dataProvider = "getData1")
	public void test1(String username, String password, String fName, String lName) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(fName);
		System.out.println(lName);
	}

	@DataProvider
	public Object[][] getData1() throws IOException {

		FileInputStream fis = new FileInputStream(new File(FrameworkConstants.getExcelpath()));
		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet workSheet = workBook.getSheet("Sheet1");

		int rowNum = workSheet.getLastRowNum();
		System.out.println("The Number of Rows => " + rowNum);

		int coulmnNum = workSheet.getRow(0).getLastCellNum();
		System.out.println("The Number of Columns => " + coulmnNum);

		Object[][] data = new Object[rowNum][coulmnNum];
		for (int i = 1; i <= rowNum; i++) { // Rows
			for (int j = 0; j < coulmnNum; j++) { // Columns
				data[i - 1][j] = workSheet.getRow(i).getCell(j).getStringCellValue();
			}
		}

		return data;

	}

	/*****************************************************************************************************/
	/**
	 * 
	 * 
	 * Jun 28, 2021
	 * 
	 * @author Krishanu
	 * @param map is used to get and store the values from the excel.
	 * 
	 *            <pre>
	 * In this below example we are using Map to hold the Column values. We can have
	 * n number of columns with n number of values. It is not recommended to pass so
	 * many columns in the test parameter like above.
	 *            </pre>
	 * 
	 * 
	 */

	@Test(dataProvider = "getData2")
	public void test2(Map<String, String> map) {
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("fName"));
		System.out.println(map.get("lName"));
	}

	@DataProvider
	public Object[] getData2() throws IOException {

		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "/excel/SampleTestDataWorkbook.xlsx"));
		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet workSheet = workBook.getSheet("Sheet2");

		int rowNum = workSheet.getLastRowNum();
		System.out.println("The Number of Rows => " + rowNum);

		int coulmnNum = workSheet.getRow(0).getLastCellNum();
		System.out.println("The Number of Columns => " + coulmnNum);

		Object[] data = new Object[rowNum];
		Map<String, String> map;

		for (int i = 1; i <= rowNum; i++) { // Rows

			map = new HashMap<>();

			for (int j = 0; j < coulmnNum; j++) { // Columns

				String key = workSheet.getRow(0).getCell(j).getStringCellValue();
				String value = workSheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i - 1] = map;

			}
		}

		return data;

	}
}
