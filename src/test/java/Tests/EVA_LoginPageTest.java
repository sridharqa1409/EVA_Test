package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.EVA_LoginPage;
import TestBase.TestBase;

public class EVA_LoginPageTest extends TestBase {

	EVA_LoginPage LoginPage;

	@BeforeMethod
	public void SetUp() {

		initBrowserAndGotoUrl("https://aq5z5o4vcj.execute-api.ap-south-1.amazonaws.com/production/login");
		LoginPage = new EVA_LoginPage();
	}

	@DataProvider
	public Object[][] getTestData() {

		Object obj[][] = new Object[4][2];

		obj[0][0] = "test@fastcollab.com";
		obj[0][1] = "Myadmin@123";

		obj[1][0] = "sridhar.moddu@fastcollab.com";
		obj[1][1] = "myadmin@123";

		obj[2][0] = "test@fastcollab.com";
		obj[2][1] = "admin@123";

		obj[3][0] = "sridhar.moddu@fastcollab.com";
		obj[3][1] = "Myadmin@123";

		return obj;

	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void loginTest(String Username, String Password) {

		LoginPage.login(Username, Password);

	}

	@AfterMethod
	public void teardown() {

		driver.close();

	}

}
