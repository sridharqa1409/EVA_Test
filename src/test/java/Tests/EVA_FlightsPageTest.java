package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.EVA_FlightsPage;
import Pages.EVA_LoginPage;
import TestBase.TestBase;

public class EVA_FlightsPageTest extends TestBase {

	EVA_LoginPage LoginPage;
	EVA_FlightsPage FlightsPage;
	
	
	public EVA_FlightsPageTest() {
		
		super();
	}
	

	@BeforeClass
	public void SetUp() throws InterruptedException {

		initBrowserAndGotoUrl(property.getProperty("Url"));
		LoginPage = new EVA_LoginPage();
		FlightsPage = new EVA_FlightsPage();

	}

	@Test(priority = 1)
	public void defaultselection() throws InterruptedException {
		LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));
		boolean d1 = FlightsPage.defaultSelection();

		Assert.assertTrue(d1);
		//flightsPage.searchFlight();

	}
	
	@Test(priority = 2)
	public void searchFrom() throws InterruptedException {
		//LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));
		Thread.sleep(1000);
		FlightsPage.searchFromFlight("che","Chennai");
		
	}
	
	@Test(priority = 3)
	public void searchTo() throws InterruptedException {
		//LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));
		Thread.sleep(1000);
		FlightsPage.searchToFlight("del","New Delhi");
		
	}

	@AfterClass
	public void tear() {

		driver.close();
	}

}
