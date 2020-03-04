package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	
	@FindBy(xpath = "//input[@class='box-shadow mat-autocomplete-trigger']")
	WebElement toSearch;
	
	@FindBy(xpath = "//input[@class='calendar-inputbox']")
	WebElement calender;
	
	@FindBy(css = "[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-month']")
	WebElement First;
	
	@FindBy(css = "[class='ui-icon ui-icon-circle-triangle-e']")
	WebElement next;
	
	@FindBy(css = "[class='col-md-4 return-date calendardatetime-inputbox fsw-inputbox faded-text'] [class='calendar-inputbox']")
	WebElement ret;
	
	@FindBy(xpath = "//input[@id='roundtrip']")
	WebElement roundtrip;
	
	@FindBy(css = "[class='ui-state-default datepicker-content-d41d8cd98f00b204e9800998ecf8427e']")
	WebElement date;
	
public EVA_FlightsPage() 
	
	{

		PageFactory.initElements(driver, this);

	}


public boolean defaultSelection() {
	
	driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
	
	if((flightlogo.isDisplayed())&&(oneway.isSelected())&&(BusinessTravel.isDisplayed())==true)
	{
		
		return true;
		
		}else {
			
		return false;
			
		}
				
}

public void searchFromFlight(String keyword,String location) throws InterruptedException {
	
	
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
	
	
	public void searchToFlight(String keyword,String location) throws InterruptedException {
		
		
		to.click();
		Thread.sleep(1000);
		toSearch.sendKeys(keyword);
		Thread.sleep(5000);
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
	
	
	public void calendar(String month,String day) {

		calender.click();


		while(!First.getText().contains(month))
		{
			next.click();
		}

		int count=driver.findElements(By.cssSelector("[class='ui-state-default datepicker-content-d41d8cd98f00b204e9800998ecf8427e']")).size();
	
		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.cssSelector("[class='ui-state-default datepicker-content-d41d8cd98f00b204e9800998ecf8427e']")).get(i).getText();
		if(text.equalsIgnoreCase(day))
		{
		driver.findElements(By.cssSelector("[class='ui-state-default datepicker-content-d41d8cd98f00b204e9800998ecf8427e']")).get(i).click();
		break;
		}

		}
		
	}

	public boolean roundtrip() throws InterruptedException {
		
		ret.click();
		Thread.sleep(10000);
		
		if(roundtrip.isSelected()) {
			
			System.out.println("Round trip button is enabled");
			return true;
			
			
		}else
		{
			
		return false;
		}
		
	}
	
}
