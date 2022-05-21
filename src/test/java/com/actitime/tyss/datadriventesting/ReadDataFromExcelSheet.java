  package com.actitime.tyss.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String url = wb.getSheet("TC001").getRow(3).getCell(2).getStringCellValue();
		String username = wb.getSheet("TC001").getRow(3).getCell(4).getStringCellValue();
		String password = wb.getSheet("TC001").getRow(3).getCell(5).getStringCellValue();
			
		System.out.println("URL= "+url);
		System.out.println("username= "+username);
		System.out.println("password= "+password);
		wb.close();
	}
}
