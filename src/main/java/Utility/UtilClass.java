package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import TestBase.TestBase;

public class UtilClass extends TestBase {

//	public static long PAGE_LOAD_TIMEOUT = 20;
//	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/TestData/TestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static ArrayList<String> ReadData(String testcasename) throws IOException, InterruptedException {
		 

		ArrayList<String> a=new ArrayList<String>();
		
		FileInputStream fis=new FileInputStream("C://Users//Public//Downloads//TestData.xlsx");
		XSSFWorkbook worbook=new XSSFWorkbook(fis);
		int sheets=worbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			
		if(worbook.getSheetName(i).equalsIgnoreCase("Gilpin")) {
			
			XSSFSheet sheet=worbook.getSheetAt(i);
			Iterator<Row> rows=sheet.iterator();
			Row firstRow=rows.next();
			Iterator<Cell> ce=firstRow.cellIterator();
			int k=0;
			int coloumn=0;
			while(ce.hasNext()) {
				
				Cell value=ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcases")) {
					
					coloumn=k;
				}
				
				k++;
			}
			
			while(rows.hasNext()) 
			{
				Row r=rows.next();
				if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext()) {
						
						a.add(cv.next().getStringCellValue());
						
						
					}
				}
				
			
			}
		}	
		
	  }
		return a;
		
		
	} 


	
	

	public static void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
			
	}
	
	
	
	
	
	
	
	
	
	

