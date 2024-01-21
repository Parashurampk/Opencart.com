package opencart.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import opencart.com.base.BaseClass;
import opencart.com.pages.AccountPage;
import opencart.com.pages.LoginPage;
import opencart.com.utility.Log;
import opencart.com.utility.ReadXLSdata;

public class TC_002_LoginpageDDTTest extends BaseClass {

	private LoginPage loginpage;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}

	@Test(groups = {"Smoke","Sanity"},dataProviderClass = ReadXLSdata.class, dataProvider = "TestData")
	public void LoginTest(String username, String password) {
		Log.startTestCase("LoginTest");
		loginpage = new LoginPage();
		Log.info("enter username and password");
		AccountPage accountPage = loginpage.loginAccount(username, password);
		String actualURL = accountPage.getCurentURL();
		String expectedURL = "https://naveenautomationlabs.com/opencart/index.php?route=account/account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is success");
		Log.endTestCase("LoginTest");
	}
/*
	@DataProvider(name = "testdata")
	public Object[][] tData() {
		return new Object[][] { 
			{ "walikindi@gmail.com", "6362772735" },
			{ "walikindi@gmail.com", "6362772735" } };
	}
*/
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
