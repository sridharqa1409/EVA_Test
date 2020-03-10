package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class EVA_CompanyInfoPage extends TestBase{

	@FindBy(xpath = "//input[@id='emailAddress']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginBtn;

	
	@FindBy(xpath = "//h5[text()='Flights']")
	WebElement flightlogo;
	
	@FindBy(xpath="//input[@id='oneway']")
	WebElement oneway;
	
}
