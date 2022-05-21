package excel_datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	private static final String FILEPATH = "./src/test/resources/testdat.xlsx";

	private static Workbook workbook;

	static{
		System.out.println("CREATING THW WORKBOOK TYPE OBJECT");
		try {
			workbook = WorkbookFactory.create(new FileInputStream(FILEPATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getStringData(String sheetName , int rowNumber, int cellNumber) {
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).toString();
	}

	public static double getNumericalData(String sheetName , int rowNumber, int cellNumber) {
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
	}

	public static boolean getBooleanData(String sheetName , int rowNumber, int cellNumber) {
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getBooleanCellValue();
	}

	public static Date getDateData(String sheetName , int rowNumber, int cellNumber) {
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getDateCellValue();
	}

	public static String[][] getMultipleDate(String sheetName){
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		String [] [] sarr = new String [rowCount] [colCount];

		//iterate rows
		for(int i=0; i<=rowCount-1; i++) {
			//iterate column
			for(int j=0; j<=colCount-1; j++) {
				sarr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return sarr;
	}
}

