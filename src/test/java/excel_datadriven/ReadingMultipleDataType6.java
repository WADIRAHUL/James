package excel_datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingMultipleDataType6 {
//TO ACCESS MULTIPLE DATA
	public static void main(String[] args) throws IOException {
		String path = "./src/test/resources/TestData.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("TC003");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		String [] [] sarr = new String [rowCount] [colCount];
		//iterate rows
		for(int i=0; i<=rowCount-1; i++) {
			//iterate col
			for(int j=0; j<=colCount-1; j++) {
				sarr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
			System.out.println();
		}
		
		for(int i=0; i<=sarr.length-1; i++) {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(sarr[i][0]);
		driver.findElement(By.name("pwd")).sendKeys(sarr[i][1]);
		}
	}
}
