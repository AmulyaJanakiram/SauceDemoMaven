package TestCases;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public static WebDriver driver;

	XSSFWorkbook wbook;
	XSSFSheet sheet;

	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeTest
	public void ExcelDataAndReportSetUp() throws Exception {
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		report = new ExtentReports("reports/ExtentReport1.html");
	}

	@AfterTest
	public void tearDownExcelReport() throws Exception {
		wbook.close();
		report.flush();
		report.close();
	}

	@BeforeMethod
	public void SetUp(Method method) {
		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
