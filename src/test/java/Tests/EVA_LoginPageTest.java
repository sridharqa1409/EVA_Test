package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.EVA_LoginPage;
import TestBase.TestBase;
import Utility.UtilClass;

public class EVA_LoginPageTest extends TestBase {

	EVA_LoginPage LoginPage;

	@BeforeMethod
	public void SetUp() {

		initBrowserAndGotoUrl(property.getProperty("Url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		LoginPage = new EVA_LoginPage();

	}

	@DataProvider
	public Object[][] getExcelTestData() {

		Object[][] data = UtilClass.getTestData("LoginTestData");

		return data;

	}

	@Test(priority = 1, dataProvider = "getExcelTestData")
	public void loginTest_Negative(String Username, String Password) throws InterruptedException {

		LoginPage.login(Username, Password);

		String ActUrl = property.getProperty("Url");

		String ExpUrl = driver.getCurrentUrl();

		Assert.assertEquals(ActUrl, ExpUrl);

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void loginTest_Positive() throws InterruptedException {

		WebElement ele = LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));

		Thread.sleep(2000);

		Assert.assertTrue(ele.isDisplayed());

		WebElement dft = LoginPage.defaultpage();

		Assert.assertTrue(dft.isSelected());

	}

	@AfterMethod
	public void teardown() {

		driver.close();
		driver = null;
	}

}
