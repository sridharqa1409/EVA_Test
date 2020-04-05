package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.EVA_FlightsPage;
import Pages.EVA_LoginPage;
import TestBase.TestBase;

public class EVA_LegalEntityTest extends TestBase {

	EVA_LoginPage LoginPage;
	EVA_FlightsPage FlightsPage;

	public EVA_LegalEntityTest() {

		super();
	}

	@BeforeClass
	public void SetUp() throws InterruptedException {

		initBrowserAndGotoUrl(property.getProperty("Url"));
		LoginPage = new EVA_LoginPage();
		FlightsPage = new EVA_FlightsPage();

	}

	@Test(priority = 1)
	public void gotoSettings() throws InterruptedException {
		LoginPage.login("cognizantmanager1@gmail.com", "Myadmin");
		FlightsPage.GotoSettings();

	}
	

	@AfterClass
	public void tear() {

		driver.close();
		driver = null;
	}
	
	
	
	
	

}
