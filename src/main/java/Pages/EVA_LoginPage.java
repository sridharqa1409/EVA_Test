package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class EVA_LoginPage extends TestBase {

	@FindBy(xpath = "//input[@id='emailAddress']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginBtn;

	public EVA_LoginPage() {

		PageFactory.initElements(driver, this);

	}

	public void login() {
		Email.sendKeys("sridhar.moddu@fastcollab.com");
		Password.sendKeys("Myadmin@123");
		LoginBtn.click();
	}

}
