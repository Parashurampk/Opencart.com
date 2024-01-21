package opencart.com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import opencart.com.base.BaseClass;
import opencart.com.pages.LoginPage;
import opencart.com.utility.Log;

public class TC_002_LoginTest extends BaseClass {

	private	LoginPage loginpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}

	@Test(priority = 1, groups = {"Smoke","Sanity"})
	public void verify_login() {
		Log.startTestCase("verify_login");
		loginpage = new LoginPage();
		loginpage.clickMyAccount();
		loginpage.clickLogin();
		loginpage.setEmail(prop.getProperty("username"));
		Log.info("Enter username");
		loginpage.setPassword(prop.getProperty("password"));
		Log.info("Enter password");
		loginpage.Account();
		Log.info("Click on account");
		Log.endTestCase("verify_login");
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
