package opencart.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import opencart.com.actiondriver.Action;
import opencart.com.actioninterface.ActionInterface;
import opencart.com.base.BaseClass;
import opencart.com.pages.AccRegistrationPage;
import opencart.com.pages.IndexPage;
import opencart.com.utility.Log;

public class TC_004_AccountRegistrationTest extends BaseClass {

	private IndexPage indexPage;
	private AccRegistrationPage regpage;
	private Action action;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}

	@Test(priority = 1, groups = "Smoke")
	public void verify_account_registration() {
		Log.startTestCase("verify_account_registration");
		try
		{
		indexPage = new IndexPage();
		regpage = new AccRegistrationPage();
		action = new Action();
		
		indexPage.clickMyAccount();
		Log.info("Click My account");
		indexPage.clickToResister();
		Log.info("Click My Resister");
		
		regpage.setFirstName(action.randomeString().toUpperCase());
		regpage.setLastName(action.randomeString().toUpperCase());
		regpage.setEmail(action.randomeString() + "@gmail.com");// randomly generated the email
		regpage.setTelephone(action.randomeNumber());
		
		String password = action.randomAlphaNumeric();

		regpage.setPassword(password);
		regpage.setConfirmPassword(password);

		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Account creation failed");
		Log.info("Verify Account Has Been Created");
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}	
		Log.endTestCase("verify_account_registration");
	}
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
