package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.EVA_FlightsPage;
import Pages.EVA_LoginPage;
import TestBase.TestBase;

public class EVA_FlightsPageTest extends TestBase {

	EVA_LoginPage LoginPage;
	EVA_FlightsPage flightsPage;

	@BeforeMethod
	public void SetUp() throws InterruptedException {

		initBrowserAndGotoUrl(property.getProperty("Url"));
		LoginPage = new EVA_LoginPage();
		flightsPage = new EVA_FlightsPage();

	}

	@Test(priority = 1)
	public void defaultselection() throws InterruptedException {
		LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));
		boolean d1 = flightsPage.defaultSelection();

		Assert.assertTrue(d1);

	}

	@AfterMethod
	public void tear() {

		driver.close();
	}

}
