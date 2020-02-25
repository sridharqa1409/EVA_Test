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

	
	@FindBy(xpath = "//h5[text()='Flights']")
	WebElement flightlogo;
	
	@FindBy(xpath="//input[@id='oneway']")
	WebElement oneway;
	
	public EVA_LoginPage() 
	
	{

		PageFactory.initElements(driver, this);

	}

	public WebElement login(String username, String password) throws InterruptedException {
		Email.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
		Thread.sleep(3000);
		return flightlogo;
	
	}
	
	public WebElement defaultpage() throws InterruptedException {
		
		Thread.sleep(3000);
		
		return oneway;
		
	}

}
