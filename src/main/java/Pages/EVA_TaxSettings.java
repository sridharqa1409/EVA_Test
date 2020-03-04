package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.TestBase;

public class EVA_TaxSettings extends TestBase  {
	
	@FindBy(xpath = "//h5[text()='Hotels']")
	WebElement RoundTrip;

	@FindBy(xpath = "div[class='pl-2 py-1']")
	WebElement profileMenu;

	@FindBy(xpath = "//li[@class='profile-item border-bottom']//span[text()='Settings']")
	WebElement Settings;

	@FindBy(xpath = "//div[@class='col-12 col-sm-6 col-lg-4 col-xl-3 mt-3 p-0']//h6[text()='View All Settings']")
	WebElement ViewallSettings;

	@FindBy(xpath = "//div[@class='settings-menu pb-3']")
	WebElement SettingsMenu;

	@FindBy(xpath = "//h5[text()='Tax Settings']")
	WebElement TaxSettings;

	@FindBy(xpath = "//button[@class='btn btn-outline-primary btn-add-new']")
	WebElement Addnewbutton;

	@FindBy(xpath = "//input[@class='form-control ico-dropdown mat-autocomplete-trigger ng-pristine ng-invalid ng-touched']")
	WebElement GSTState;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	WebElement placeofsupply;

	@FindBy(xpath = "/input[@class='form-control ng-pristine ng-valid ng-touched'and @formcontrolname='taxCategory']")
	WebElement GSTTaxCategory;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched' and @formcontrolname='sacCode']")
	WebElement SACCode;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='gstAccountNumber']]")
	WebElement GSTNumber;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='gstName']")
	WebElement GSTName;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='gstEmail']")
	WebElement GSTEmail;

	@FindBy(xpath = "//input[@class='form-control col-7 ng-pristine ng-invalid ng-touched' and @formcontrolname='gstPhone']")
	WebElement GSTMobileNumber;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched' and @formcontrolname='gstAddress1']")
	WebElement GSTAddressLine1;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched' and @formcontrolname='gstAddress2']")
	WebElement GSTAddressLine2;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='city']")
	WebElement City;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched' and @formcontrolname='postalCode']")
	WebElement Postalcode;

	@FindBy(xpath = "//button[@class='btn cta mr-3 ng-star-inserted']")
	WebElement AddNewbutton1;

	@FindBy(xpath = "//button[@class='btn btn-light btn-cancel']")
	WebElement Cancelbutton;

	public void taxsettings() {
		
//		Actions action=new Actions(driver);
//		action.moveToElement(profileMenu).click().build().perform();
		System.out.println("After Login");
		RoundTrip.click();
		profileMenu.click();
		Settings.click();
		ViewallSettings.click();
		SettingsMenu.click();
		TaxSettings.click();
		Addnewbutton.click();
		GSTState.click();
	}

	public void placeofsupply(String GstState) {

		placeofsupply.click();
		
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='mat-option-text']"));

		for (WebElement str : list) {

			if (str.getText().contains(GstState)) {
				str.click();
			}

		}
	}

	public void Taxcategory() {
		GSTTaxCategory.sendKeys("Reservation Service of Transportation");
		SACCode.sendKeys("998551");
		GSTNumber.sendKeys("16AABCT3518Q1ZZ");
		GSTName.sendKeys("Radhakrishna");
		GSTEmail.sendKeys("Radhakrishna@gmail.com");
		GSTMobileNumber.sendKeys("9000675867");
		GSTAddressLine1.sendKeys("Door No 5-37-69, 1st Floor, Pranavam Plaza,");
		GSTAddressLine2.sendKeys("Lane No 4, Brodipet, Guntur, Beside Syndicate Bank (Map)");
		City.sendKeys("Guntur");
		Postalcode.sendKeys("522002");
		//Addnewbutton.click();
		Cancelbutton.click();
	}

}