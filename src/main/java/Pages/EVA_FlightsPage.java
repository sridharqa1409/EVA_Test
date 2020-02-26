package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//div[@class='col-md-6 search-from-city cityairportlist fsw-inputbox'] //input[@placeholder='Select']")
	WebElement from;
	
	@FindBy(xpath = "//div[@class='col-md-6 search-to-city cityairportlist fsw-inputbox'] //input[@placeholder='Select']")
	WebElement to;
	
	@FindBy(xpath = "//input[@class='box-shadow mat-autocomplete-trigger']")
	WebElement fromSearch;
	
	
	
public EVA_FlightsPage() 
	
	{

		PageFactory.initElements(driver, this);

	}


public boolean defaultSelection() {
	
	driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
	
	if((flightlogo.isDisplayed())&&(oneway.isSelected())&&(BusinessTravel.isDisplayed())==true)
	{
	
	//if(flightlogo.isSelected())
	
		
		return true;
		
		}else {
			
		return false;
			
		}
				
}

public void searchFlight(String keyword,String location) throws InterruptedException {
	
	
	from.click();
	Thread.sleep(1000);
	fromSearch.sendKeys(keyword);
	Thread.sleep(1000);
	List<WebElement> list=driver.findElements(By.xpath("//small[@class='d-inline cityairport-name px-2'] //span[@class='d-block cityname']"));
	
	for(WebElement srt:list) {
		
		if(srt.getText().contains(location)){
			srt.click();
			Thread.sleep(3000);
			break;
		}
		
		else {
			
			System.out.println("there is no location as such");
		}
	}
	
}
	
	
	

}
