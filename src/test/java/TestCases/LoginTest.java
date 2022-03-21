package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductPage;

public class LoginTest extends BaseClass {

	@Test
	public void LoginFailure() throws Exception {

		LoginPage Login = new LoginPage();
		Login.LoginFunction("standard_user", "test@123");
		WebElement ErrorMsg = driver.findElement(By.xpath(("//h3")));
		String ActualErrorMsg = ErrorMsg.getText();
		String ExpectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
	}

	@Test
	public void LoginSuccess() throws Exception {

		LoginPage Login = new LoginPage();
		Login.LoginFunction("standard_user", "secret_sauce");

		ProductPage Product = new ProductPage();
		String ActualHeader = Product.ProductPageLoad();
		String ExpectedHeader = "PRODUCTS";
		Assert.assertEquals(ActualHeader, ExpectedHeader);

	}
}
