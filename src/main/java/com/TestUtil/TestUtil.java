package com.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.TestBase.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGELOADOUTTIME=20;
	public static long IMPLICITYWAIT=30;
	
	static Workbook book; //import from apache poi
	static Sheet sheet;
	
	//defining path for excel file
	public static String testdata_path= "C:\\Users\\Jeff\\eclipse-workspace\\dell.qa\\src\\main\\java\\com\\TestData\\service.xlsx";
	
	public static Object [][] getTestData(String sheetName){
		FileInputStream file;
		
			try {
				file = new FileInputStream(testdata_path);
				book = WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}

public static void captureScreenShot (WebDriver driver, String screenShotName) {
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(source, new File("./Screenshot/"+screenShotName+".png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}