package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.EVA_FlightsPage;
import Pages.EVA_LoginPage;
import TestBase.TestBase;
import Utility.UtilClass;

public class EVA_FlightsPageTest2 extends TestBase {

	EVA_LoginPage LoginPage;
	EVA_FlightsPage FlightsPage;

	public EVA_FlightsPageTest2() {

		super();
	}

	@BeforeClass
	public void SetUp() throws InterruptedException {

		initBrowserAndGotoUrl(property.getProperty("Url"));
		LoginPage = new EVA_LoginPage();
		FlightsPage = new EVA_FlightsPage();

	}
	
	
	@DataProvider
	public Object[][] getExcelData(){
		
		
		Object[][] flighTestData=UtilClass.getTestData("LoginTestData");
		
		return flighTestData;
		
	}

	@Test(priority = 1,dataProvider = "getExcelData")
	public void defaultselection() throws InterruptedException {
		LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));
		Thread.sleep(1000);
		FlightsPage.searchFromFlight("che", "Chennai");
		Thread.sleep(1000);
		FlightsPage.searchToFlight("del", "New Delhi");
		Thread.sleep(1000);
		FlightsPage.calendar("July", "29");
		Thread.sleep(1000);
		FlightsPage.ClickSubmitFlights();

	}

//	@Test(priority = 2)
//	public void searchFrom() throws InterruptedException {
//		Thread.sleep(1000);
//		FlightsPage.searchFromFlight("che", "Chennai");
//
//	}
//
//	@Test(priority = 3)
//	public void searchTo() throws InterruptedException {
//
//		Thread.sleep(1000);
//		FlightsPage.searchToFlight("del", "New Delhi");
//
//	}
//
//	@Test(priority = 4)
//	public void calender() throws InterruptedException {
//
//		Thread.sleep(1000);
//		FlightsPage.calendar("July", "29");
//	}
//
//	@Test(priority = 5)
//	public void uiround() throws InterruptedException {
//		boolean d1 = FlightsPage.roundtrip();
//		Assert.assertTrue(d1);
//
//	}

	@AfterClass
	public void tear() {

		driver.close();
		driver = null;
	}

}
