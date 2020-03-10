package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class EVA_SearchFlightResultsPage extends TestBase {

	@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper']")
	WebElement tripTypedropdown;

	@FindBy(xpath = "//*[@id=\"mat-option-211\"]/span")
	WebElement OneWay;

	@FindBy(xpath = "//*[@id=\"mat-option-212\"]/span")
	WebElement Roundtrip;

	@FindBy(xpath = "//*[@id=\"mat-option-213\"]/span")
	WebElement Multicity;

	public EVA_SearchFlightResultsPage()

	{

		PageFactory.initElements(driver, this);

	}

	public void SelectTripType(String triptype) {

		tripTypedropdown.click();

		System.out.println("Hello world");

		if (triptype.equalsIgnoreCase("One Way")) {
			OneWay.click();
		} else if (triptype.equalsIgnoreCase("Round Trip")) {

			Roundtrip.click();

		} else {

			Multicity.click();
		}
	}

}
