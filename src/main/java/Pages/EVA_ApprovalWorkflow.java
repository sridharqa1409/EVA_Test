package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.TestBase;

public class EVA_ApprovalWorkflow extends TestBase {
	
	@FindBy(xpath = "//div[@class='pl-2 py-1'])[1]")
	WebElement profileMenu;

	@FindBy(xpath = "//li[@class='profile-item border-bottom']//span[text()='Settings']")
	WebElement Settings;

	@FindBy(xpath = "//div[@class='col-12 col-sm-6 col-lg-4 col-xl-3 mt-3 p-0']//h6[text()='View All Settings']")
	WebElement ViewallSettings;

	@FindBy(xpath = "//div[@class='settings-menu pb-3']")
	WebElement SettingsMenu;
	
	@FindBy(xpath = "//h5[text()='Approval Workflows']")
	WebElement ApprovalWorkfllow;

	@FindBy(xpath = "//button[@class='btn btn-outline-primary btn-add-new']")
	WebElement Addnewbutton;
	
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched' and @formcontrolname='name']")
	WebElement WorkFlowName;
	
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched' and @formcontrolname='description']")
	WebElement Description;
	
	@FindBy(xpath = "//button[@class='btn cta btn-next']")
	WebElement Next;
	

	
	
	
	
	
	

}
