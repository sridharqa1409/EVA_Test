package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.TestBase;

public class EVA_Creditcards extends TestBase {
	@FindBy(xpath = "//div[@class='pl-2 py-1'])[1]")
	WebElement profileMenu;

	@FindBy(xpath = "//li[@class='profile-item border-bottom']//span[text()='Settings']")
	WebElement Settings;

	@FindBy(xpath = "//div[@class='col-12 col-sm-6 col-lg-4 col-xl-3 mt-3 p-0']//h6[text()='View All Settings']")
	WebElement ViewallSettings;

	@FindBy(xpath = "//div[@class='settings-menu pb-3']")
	WebElement SettingsMenu;
	
	@FindBy(xpath = "//h5[text()='Credit Cards']")
	WebElement Creditcards;
	
	@FindBy(xpath = "//button[@class='btn btn-outline-primary btn-add-new']")
	WebElement Addnewbutton;
	
	@FindBy(xpath = "//input[@class='form-control ico-dropdown ng-pristine ng-invalid ng-touched' and @formcontrolname='card_Type']")
	WebElement CardType;
	
	@FindBy(xpath = "//input[@class='box-shadow mat-autocomplete-trigger']")
	WebElement CardSearch;

	@FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
	WebElement Cardlist;
	
	
	@FindBy(xpath = "//span[@class='mat-option-text']")
	WebElement Service;
	
	@FindBy(xpath = "//input[@class='box-shadow mat-autocomplete-trigger']")
	WebElement ServiceSearch;
	
	@FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
	WebElement Servicelist;
	
	@FindBy(xpath = "//input[@class='form-control ico-dropdown ng-pristine ng-invalid ng-touched' and @formcontrolname='issuing_Brand']")
	WebElement Issuebrand;
	
	@FindBy(xpath = "//input[@class='box-shadow mat-autocomplete-trigger']")
	WebElement BrandSearch;
	
	@FindBy(xpath = "(//span[@class='mat-option-text'])[3]")
	WebElement BrandList;
	
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='bank_Name']")
	WebElement BankName;
	
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='card_Number']")
	WebElement CardNumber;
	
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='name_on_Card']']")
	WebElement NameonCard;
	
	@FindBy(xpath = "//input[@class='form-control calendar-inputbox ng-pristine ng-invalid ng-touched' and @formcontrolname='expiry_Date']")
	WebElement ExpireDate;
	
	@FindBy(xpath = "//tr[@class='ng-star-inserted']")
	WebElement Calendertable;
	
	@FindBy(css = "//td[@class='mat-calendar-body-label']")
	WebElement MonthName;
	
	@FindBy(css = "//button[@class='mat-calendar-next-button mat-icon-button mat-button-base']")
	WebElement next;

	@FindBy(xpath = "//button[@class='btn cta mr-3 ng-star-inserted']")
	WebElement AddNewbutton1;
	
	@FindBy(xpath = "//button[@class='btn btn-light btn-cancel']")
	WebElement CancelButton;
		
public void CreditCards() {

	profileMenu.click();
	Settings.click();
	ViewallSettings.click();
	SettingsMenu.click();
	Creditcards.click();
	Addnewbutton.click();
	CardType.click();
	CardSearch.sendKeys("India");
	Cardlist.click();
	Service.click();
	Servicelist.sendKeys("Fligh");
	Servicelist.click();
	Issuebrand.click();
	BrandSearch.sendKeys("Ame");
	BrandList.click();
	BankName.sendKeys("State Bank Of India");
	CardNumber.sendKeys("9962456434568765");
	NameonCard.sendKeys("P.Raghu");
	ExpireDate.click();
}
	
	public void Calendertable(String month,String day) {

		Calendertable.click();


		while(!MonthName.getText().contains(month))
		{
			next.click();
		}


		//List<WebElement> dates= driver.findElements(By.xpath("//div[@class='mat-calendar-body-cell-content']"));

		int count=driver.findElements(By.xpath("//div[@class='mat-calendar-body-cell-content']")).size();

		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.xpath("//div[@class='mat-calendar-body-cell-content']")).get(i).getText();
		if(text.equalsIgnoreCase(day))
		{
		driver.findElements(By.xpath("//div[@class='mat-calendar-body-cell-content']")).get(i).click();
		break;
		}

		}

		}

	public void Cancelbutton() {
	CancelButton.click();
}
}
