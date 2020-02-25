package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class EVA_FlightsPage extends TestBase {
	
	@FindBy(xpath = "//h5[text()='Flights']")
	WebElement flightlogo;
	
	@FindBy(xpath = "//input[@id='oneway']")
	WebElement oneway;
	
	@FindBy(xpath = "//div[text()='Business Travel']")
	WebElement BusinessTravel;
	
	
public EVA_FlightsPage() 
	
	{

		PageFactory.initElements(driver, this);

	}


public boolean defaultSelection() {
	
	//if((flightlogo.isSelected())&&(oneway.isSelected())&&(BusinessTravel.isSelected())==true)
	if(flightlogo.isSelected())
	{
		
		return true;
		
		}else {
			
		return false;
			
		}
			
		
}

	
	
	

}
