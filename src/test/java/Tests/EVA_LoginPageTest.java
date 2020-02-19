package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.EVA_LoginPage;
import TestBase.TestBase;

public class EVA_LoginPageTest extends TestBase{

	EVA_LoginPage LoginPage;
	
	
	@BeforeClass
	public void SetUp() {

		initBrowserAndGotoUrl("https://aq5z5o4vcj.execute-api.ap-south-1.amazonaws.com/production/login");
		LoginPage = new EVA_LoginPage(); 
	}

	
	@Test(priority=1)
	public void loginTest() {
		
		LoginPage.login();
			
	}
	
	
	@AfterClass
	public void teardown() {
		
		//driver.close();
	}
	
	
}
