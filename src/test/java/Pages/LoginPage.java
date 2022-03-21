package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.driver;

	// Page Class Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Elements
	@FindBy(id = "user-name")
	WebElement UserName;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(id = "login-button")
	WebElement Login;

	// Functionality
	public void LoginFunction(String UsrName, String Pwd) throws InterruptedException {
		UserName.sendKeys(UsrName);
		Password.sendKeys(Pwd);
		Login.click();
		Thread.sleep(2000);
	}

}
