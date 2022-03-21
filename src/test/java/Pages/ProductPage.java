package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;

public class ProductPage {

	WebDriver driver = BaseClass.driver;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "title")
	WebElement Header;

	public String ProductPageLoad() throws Exception {
		Thread.sleep(2000);
		String txt = Header.getText();
		return txt;
	}
}
