package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductPage;

public class LoginTest extends BaseClass {

	@Test
	public void LoginFailure() throws Exception {
		// test = report.startTest("LoginFailure");
		LoginPage Login = new LoginPage();
		Login.LoginFunction("standard_user", "test@123");
		WebElement ErrorMsg = driver.findElement(By.xpath(("//h3")));
		String ActualErrorMsg = ErrorMsg.getText();
		String ExpectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
		// report.endTest(test);
	}

	@Test
	public void LoginSuccess() throws Exception {
		// test = report.startTest("LoginSuccess");
		LoginPage Login = new LoginPage();
		Login.LoginFunction("standard_user", "secret_sauce");

		ProductPage Product = new ProductPage();
		String ActualHeader = Product.ProductPageLoad();
		String ExpectedHeader = "PRODUCTS";
		Assert.assertEquals(ActualHeader, ExpectedHeader);
		// report.endTest(test);
	}

	// this test to be run as XML Suite and not individual
	@Test
	@Parameters({ "ParamUsr", "ParamPwd" })
	public void ParameterFromTestNGFile(String Usr, String Pwd) throws Exception {
		// test = report.startTest("ParameterFromTestNGFile");
		LoginPage Login = new LoginPage();
		Login.LoginFunction(Usr, Pwd);

		ProductPage Product = new ProductPage();
		String ActualHeader = Product.ProductPageLoad();
		String ExpectedHeader = "PRODUCTS";
		Assert.assertEquals(ActualHeader, ExpectedHeader);
		// report.endTest(test);
	}

	@Test
	public void DataFromExcelFile() throws Exception {
		// test = report.startTest("DataFromExcelFile");
		String Usr = sheet.getRow(1).getCell(0).getStringCellValue();
		String Pwd = sheet.getRow(1).getCell(1).getStringCellValue();
		LoginPage Login = new LoginPage();
		Login.LoginFunction(Usr, Pwd);

		ProductPage Product = new ProductPage();
		String ActualHeader = Product.ProductPageLoad();
		String ExpectedHeader = "PRODUCTS";
		Assert.assertEquals(ActualHeader, ExpectedHeader);
		// report.endTest(test);
	}
}
