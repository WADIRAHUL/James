 package excel_datadriven;

import java.io.IOException;
import java.util.Date;

public class ReadingMultipleData {
	public static void main(String[] args) throws IOException {
				
		String sheetName="TC002";
		String name = ExcelLibrary.getStringData(sheetName, 1, 0);
		double age = ExcelLibrary.getNumericalData(sheetName, 1, 1);
		boolean passed = ExcelLibrary.getBooleanData(sheetName, 1, 2);
		Date date = ExcelLibrary.getDateData(sheetName, 1, 3);
			
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		System.out.println("passed: "+passed);
		System.out.println("date: "+date);
		
	}
}
