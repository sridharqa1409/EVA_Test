package Pages;


import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;
import Utility.UtilClass;

public class EVA_companysettings extends TestBase {
	
	@FindBy(xpath = "//div[@class='profile-section-drop-down']/img")
	WebElement setting;
	
	@FindBy(xpath = "//ul[@class='list-unstyled']/li[3]/img")
	WebElement settingsIcon;
	
	@FindBy(css = "[class='col-12 col-sm-6 col-lg-4 col-xl-3 mt-3 p-0'] [class='link-text']")
	WebElement Viewallsetting;
	
	@FindBy(xpath = "//h5[text()='Account Details']")
	WebElement accountdetails;
	
	@FindBy(xpath = "//input[@class='form-control big-font ng-pristine ng-valid ng-touched']")
	WebElement corporateBooking;
	
	@FindBy(css = "[formcontrolname='pan_Name']")
	WebElement panNumber;
	
	@FindBy(xpath = "//input[@class='form-control big-font ng-untouched ng-pristine ng-valid']")
	WebElement LegalEntityCode;
	
public EVA_companysettings() 
	
	{

		PageFactory.initElements(driver, this);

	}



public void settings() throws InterruptedException {
	
	setting.click();
	
	Thread.sleep(1000);
	settingsIcon.click();
	Thread.sleep(1000);
	Viewallsetting.click();
	Thread.sleep(1000);
	
}

public void accountDetails() throws IOException, InterruptedException {
	ArrayList<String> data=UtilClass.ReadData("AccountDetails");
	
	Thread.sleep(1000);
	accountdetails.click();
	Thread.sleep(1000);
	System.out.println(data.get(1));
	panNumber.sendKeys(data.get(1));
	Thread.sleep(1000);
	
	
}


	

}
