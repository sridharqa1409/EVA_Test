package Tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.EVA_FlightsPage;
import Pages.EVA_LoginPage;
import Pages.EVA_companysettings;
import TestBase.TestBase;
import Utility.UtilClass;


	public class EVA_companySettingsTest extends TestBase {
		
		EVA_LoginPage LoginPage;
		EVA_FlightsPage FlightsPage;
		EVA_companysettings companysettings;
		
		
		public EVA_companySettingsTest() {
			
			super();
		}
		

		@BeforeClass
		public void SetUp() throws InterruptedException {

			initBrowserAndGotoUrl(property.getProperty("Url"));
			LoginPage = new EVA_LoginPage();
			FlightsPage = new EVA_FlightsPage();
			companysettings=new EVA_companysettings();

		}
		
		@DataProvider
		public Object[][] getExcelTestData() {

			Object[][] data = UtilClass.getTestData("LoginTestData");

			return data;

		}

		@Test(priority = 1)
		public void loginTest_Positive() throws InterruptedException {

			WebElement ele = LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));

			Thread.sleep(2000);

			Assert.assertTrue(ele.isDisplayed());

			WebElement dft = LoginPage.defaultpage();

			Assert.assertTrue(dft.isSelected());
		}

		@Test(priority = 2)
		public void settings() throws InterruptedException {
			
			Thread.sleep(1000);
			
			companysettings.settings();
			
			Thread.sleep(1000);
			
			
		}
		

		@Test(priority = 3)
		public void accountDetails() throws IOException, InterruptedException {
			
			
			companysettings.accountDetails();
			
		}
		
		@AfterClass
		public void tear() {
	        
			driver.close();
			driver =null;
		}
		
}
