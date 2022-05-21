package excel_datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleDataType5 {
//TO ACCESS & PRINT MULTIPLE DATA
	public static void main(String[] args) throws IOException {
		String path = "./src/test/resources/TestData.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("TC003");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("rowCount: "+rowCount);
		System.out.println("colCount: "+colCount);
		System.out.println("=======================");
		String [] [] sarr = new String [rowCount] [colCount];
		
		//iterate rows
		for(int i=0; i<=rowCount-1; i++) {
			//iterate col
			for(int j=0; j<=colCount-1; j++) {
				System.out.print(sheet.getRow(i).getCell(j).toString()+" ");
			}
			System.out.println();
		}
		System.out.println("=====================");
		for(int i=0; i<=sarr.length-1; i++) {
			for(int j=0; j<=sarr[i].length-1; j++) {
				System.out.print(sarr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=============");
		for(int i=0;i<=sarr.length-1;i++) {
			System.out.println(sarr[i][0]+" ");
			System.out.println(sarr[i][1]);
		}
	}
}
