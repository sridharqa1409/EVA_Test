package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.EVA_FlightsPage;
import Pages.EVA_LoginPage;
import Pages.EVA_SearchFlightResultsPage;
import TestBase.TestBase;

public class EVA_SearchFlightResultsPageTest extends TestBase {

	EVA_LoginPage LoginPage;
	EVA_SearchFlightResultsPage FlightsResultsPage;
	EVA_FlightsPage flightspage;

	public EVA_SearchFlightResultsPageTest() {

		super();
	}

	@BeforeClass
	public void SetUp() throws InterruptedException {
		initBrowserAndGotoUrl(property.getProperty("Url"));
		LoginPage = new EVA_LoginPage();
		FlightsResultsPage = new EVA_SearchFlightResultsPage();
		flightspage = new EVA_FlightsPage();

	}

	@Test(priority = 1)
	public void TripTypeSelection() throws InterruptedException {
		LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));
		flightspage.searchFromFlight("ben", "Bengaluru");
		Thread.sleep(2000);
		flightspage.searchToFlight("del", "New Delhi");
		Thread.sleep(2000);
		flightspage.calendar("April", "10");
		Thread.sleep(2000);
		flightspage.searchFlightButtonClick();
		Thread.sleep(5000);
		FlightsResultsPage.SelectTripType("Round Trip");

	}

	@AfterClass
	public void tear() {
		driver.close();
		driver = null;
	}

}
