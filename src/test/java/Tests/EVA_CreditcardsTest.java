package Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.EVA_Creditcards;
import Pages.EVA_LoginPage;
import TestBase.TestBase;

public class EVA_CreditcardsTest extends TestBase {
	EVA_LoginPage LoginPage;
	EVA_Creditcards CreditCards;

	public EVA_CreditcardsTest() {

		super();
	}

	@BeforeClass
	public void SetUp() throws Exception {

		initBrowserAndGotoUrl("https://aq5z5o4vcj.execute-api.ap-south-1.amazonaws.com/production/login");

		LoginPage = new EVA_LoginPage();

		CreditCards = new EVA_Creditcards();
	    Thread.sleep(000);
	}
	
	@Test(priority = 1)
	public void selectCreditCards() throws Exception {
		LoginPage.login(property.getProperty("Username"), property.getProperty("Password"));
 		Thread.sleep(1000);
 		CreditCards.CreditCards();
		Thread.sleep(5000);
				
	}
	
	@Test(priority = 2)
	public void selectCalendertable() {
		CreditCards.Calendertable("June","25");

	}
	
	@Test(priority = 3)
	public void TaxFormFilling() {
		CreditCards.Cancelbutton();

	}

}



