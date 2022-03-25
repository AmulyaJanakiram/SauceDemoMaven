package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestCases.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;

	// Elements
	@FindBy(id = "user-name")
	WebElement UserName;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(id = "login-button")
	WebElement Login;

	// Page Class Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Functionality
	public void LoginFunction(String UsrName, String Pwd) throws Exception {

		UserName.sendKeys(UsrName);
		test.log(LogStatus.PASS, "Enter UserName", "Accepted the data");
		Password.sendKeys(Pwd);
		test.log(LogStatus.PASS, "Entered Password", "accepted");
		Login.click();
		test.log(LogStatus.PASS, "Login Button click", "successful");
		Thread.sleep(2000);
	}

}
