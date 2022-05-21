	package excel_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleDataType3 {

	public static void main(String[] args) throws IOException {
		String path = "./src/test/resources/TestData.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		
		int rowCount = wb.getSheet("TC003").getPhysicalNumberOfRows();
		int colCount = wb.getSheet("TC003").getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("rowCount: "+rowCount);
		System.out.println("colCount: "+colCount);
	}
}
