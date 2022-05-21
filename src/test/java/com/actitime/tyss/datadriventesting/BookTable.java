package com.actitime.tyss.datadriventesting;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookTable {
	public static void main(String[] args) throws IOException {
		//STEP-1 LAUNCH THE CHROME BROWSER
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//STEP-2  ENTER THE URL
		driver.get("https://www.bellaitalia.co.uk/");
		//STEP-3 TO ACCEPT THE COOKIES
		driver.findElement(By.id("gdpr-cookie-accept")).click();
		//STEP-4 TO CLICK ON BOOK NOW BUTTON
		driver.findElement(By.xpath("//a[contains(text(),'Book Now')]")).click();
		//STEP-5 TO ENTER LONDON IN SEARCH BAR
		driver.findElement(By.cssSelector("input[title=\"Find a restaurant\"]")).sendKeys("London");
		//STEP-6 TO CLICK ON THE CALENDAR BUTTON
		driver.findElement(By.cssSelector("span[class='vdp-datepicker__calendar-button']")).click();
		//STEP-7 TO SELECT THE CURRENT DATE
		LocalDateTime ldt = LocalDateTime.now();
		int day = ldt.getDayOfMonth();
		String month = ldt.getMonth().name();
		int year = ldt.getYear();
		month = month.substring(0, 1).toUpperCase() + month.substring(1, 3).toLowerCase();
		driver.findElement(By.xpath("//span[text()='"+month+" "+year+"']/../..//span[text()='"+day+"']")).click();
		//STEP-8 TO SELECT NUMBER OF PEOPLES
		WebElement peopleList = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select s1 = new Select(peopleList);
		s1.selectByValue("3");
		//STEP-9 TO SELECT HOURS
		//(//div[@class=\"form-row mb-2\"]/child::div[@class=\"col-6 col-sm-3 \"])
		WebElement hoursList = driver.findElement(By.cssSelector("select[class='form-control form-padding']"));
		Select s2 = new Select(hoursList);
		s2.selectByValue("21");
		//STEP-10 TO SELECT MINUTES
		//(//div[@class=\"form-row mb-2\"]/child::div[@class=\"col-6 col-sm-3\"])
		WebElement minutesList = driver.findElement(By.xpath("(//select[@class='form-control form-padding'])[2]"));
		Select s3 = new Select(minutesList);
		s3.selectByValue("45");
		//STEP-11 TO CLICK ON SEARCH BUTTON
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		//STEP-12 TO VERIFY ALL 5 RESTAURANTS ARE SIPLAYED OR NOT
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Wellington Street')]")));
		List<WebElement> hotelList = driver.findElements(By.cssSelector("div[class=\"title\"]"));
		//wait.until(ExpectedConditions.visibilityOfAllElements(hotelList));
		System.out.println("The Restaurant List Is As Follows");
		for (WebElement ele : hotelList) {
			System.out.println(ele.getText());
		}
		int count = hotelList.size();
		System.out.println("Total Restaurant Count= "+count);
		if (count==5) {
			System.out.println("Pass::The Restaurant Count Is Correct");
		} else {
			System.out.println("Fail::The Restaurant Count Is Not Correct");
		}
		//STEP-13 IN IRVING STREET RESTARUANT TO SELECT BELLA SET MENU
		WebElement menu = driver.findElement(By.xpath("//div[contains(text(),'10 Irving Street')]/../..//select[@class=\"form-control\"]"));
		Select s4 = new Select(menu);
		s4.selectByVisibleText("Bella Set Menu - 2 courses £13.99 or 3 courses £17.99");
		//TO SELECT THE TIME
		driver.findElement(By.xpath("//div[contains(text(),'10 Irving Street')]/../..//label[text()='22:00']")).click();
		//
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='booking-details row mb-3']")));
			System.out.println("Pass:: The Booking Details has Displayed");
		} catch (NoSuchElementException e) {
			System.out.println("Fail:: The Booking Details Has Not Displayed");
		}
		/*FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(3);
		Cell cell = row.getCell(5);
		String url = cell.getStringCellValue();*/
		
		
		driver.quit();
	}
}
