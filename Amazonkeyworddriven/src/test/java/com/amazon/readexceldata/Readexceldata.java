package com.amazon.readexceldata;

import java.io.FileInputStream;

import java.util.Properties;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.amazon.tests.UIOperation;


public class Readexceldata {

	static WebDriver driver;

	
	public Readexceldata(WebDriver driver) {
		UIOperation.driver = driver;
	}
	
	

	public XSSFWorkbook workbook = null;

	public void readexcel(String filePath, Properties Repository) throws Exception {

		FileInputStream inputStream = new FileInputStream(filePath);

		workbook = new XSSFWorkbook(inputStream);

		Sheet naghme = workbook.getSheet("KeywordFramework");

		// Find number of rows in excel file
		int rowCount = naghme.getLastRowNum() - naghme.getFirstRowNum();
		// Create a loop over all the rows of excel file to read it
		for (int i = 1; i < rowCount + 1; i++) {
			// Loop over all the rows
			Row row = naghme.getRow(i);
			// Check if the first cell contain a value, if yes, That means it is the new
			// testcase name
			if (row.getCell(0).toString().length() == 0) {
               
				// Print testcase detail on console
				System.out.println(row.getCell(1).toString() + "-" + row.getCell(2).toString() + "-"
						+ row.getCell(3).toString() + "-" + row.getCell(4).toString());
				// Call perform function to perform operation on UI

				UIOperation.perform(Repository, row.getCell(1).toString(), row.getCell(2).toString(),
						row.getCell(3).toString(), row.getCell(4).toString());

			} else {
				// Print the new testcase name when it started
				System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
			}
		}

	}
}
