package excel_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleDataType2 {
//HERE WE CONVERTING ALL DATA INTO STRING FORMAT
	public static void main(String[] args) throws IOException {
		String path = "./src/test/resources/TestData.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		
		String name = wb.getSheet("TC002").getRow(1).getCell(0).toString();
		String age = wb.getSheet("TC002").getRow(1).getCell(1).toString();
		String passed = wb.getSheet("TC002").getRow(1).getCell(2).toString();
		String date = wb.getSheet("TC002").getRow(1).getCell(3).toString();
		
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		System.out.println("passed: "+passed);
		System.out.println("date: "+date);
		System.out.println("====== AFTER PARSING ========");
		int myAge = (int) Double.parseDouble(age);
		boolean pass = Boolean.parseBoolean(passed);
		System.out.println("myAge= "+myAge);
		System.out.println("pass= "+pass);
	}
}
