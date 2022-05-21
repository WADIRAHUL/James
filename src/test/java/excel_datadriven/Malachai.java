package excel_datadriven;

import java.math.BigDecimal;

public class Malachai {
	public static void main(String[] args) {
		String sheetName = "Reg";
		int rowNumber = 1;
		String name = ExcelLibrary.getStringData(sheetName, rowNumber, 0);
		String lastName = ExcelLibrary.getStringData(sheetName, rowNumber, 1);
		String email = ExcelLibrary.getStringData(sheetName, rowNumber, 2);
		double number = ExcelLibrary.getNumericalData(sheetName, rowNumber, 3);
		String phone = BigDecimal.valueOf(number).toString();
		String country = ExcelLibrary.getStringData(sheetName, rowNumber, 4);
		String password = ExcelLibrary.getStringData(sheetName, rowNumber, 5);
		
		System.out.println(name);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(country);
		System.out.println(password);
		}
}
