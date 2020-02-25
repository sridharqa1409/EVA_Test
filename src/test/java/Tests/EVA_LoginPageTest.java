package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.EVA_LoginPage;
import TestBase.TestBase;

public class EVA_LoginPageTest extends TestBase {

	EVA_LoginPage LoginPage;

	@BeforeMethod
	public void SetUp() {

		initBrowserAndGotoUrl(property.getProperty("Url"));
		LoginPage = new EVA_LoginPage();
	}

	@DataProvider
	public Object[][] getTestData() {

		Object obj[][] = new Object[6][2];

		obj[0][0] = "test@fastcollab.com";
		obj[0][1] = "Myadmin@123";

		obj[1][0] = "sridhar.moddu@fastcollab.com";
		obj[1][1] = "myadmin@123";

		obj[2][0] = "test@fastcollab.com";
		obj[2][1] = "admin@123";

		obj[3][0] = "";
		obj[3][1] = "";

		obj[4][0] = "";
		obj[4][1] = "Myadmin@123";

		obj[5][0] = "sridhar.moddu@fastcollab.com";
		obj[5][1] = "";

		return obj;

	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void loginTest_Negitive(String Username, String Password) throws InterruptedException {

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

	}

	@AfterMethod
	public void teardown() {

		driver.close();

	}

}
