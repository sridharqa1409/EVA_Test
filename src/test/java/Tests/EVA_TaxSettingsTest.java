package Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.EVA_LoginPage;
import Pages.EVA_TaxSettings;
import TestBase.TestBase;

public class EVA_TaxSettingsTest extends TestBase {

	EVA_LoginPage LoginPage;
	EVA_TaxSettings taxsetting;

	public EVA_TaxSettingsTest() {

		super();
	}

	@BeforeClass
	public void SetUp() throws Exception {

		initBrowserAndGotoUrl("https://aq5z5o4vcj.execute-api.ap-south-1.amazonaws.com/production/login");

		LoginPage = new EVA_LoginPage();

		taxsetting = new EVA_TaxSettings();
	    Thread.sleep(000);
	}
	
	@Test(priority = 1)
	public void selectTaxSettings() throws Exception {
		LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));
 		Thread.sleep(1000);
		taxsetting.taxsettings();
		Thread.sleep(5000);
				
	}
	
	@Test(priority = 2)
	public void selectGstState() {
		taxsetting.placeofsupply("Andhra Pradesh");

	}
	
	@Test(priority = 3,enabled=false)
	public void TaxFormFilling() {
		taxsetting.Taxcategory();

	}

}
