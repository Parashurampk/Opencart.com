package opencart.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import opencart.com.base.BaseClass;
import opencart.com.pages.AccountPage;
import opencart.com.pages.IndexPage;
import opencart.com.pages.RegisterPage;
import opencart.com.utility.Log;
import opencart.com.utility.ReadXLSdata;

public class TC_003_RegisterPageTest extends BaseClass {

	private IndexPage indexPage;
	private RegisterPage registerPage;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@Test(groups = {"Smoke"},dataProviderClass = ReadXLSdata.class, dataProvider = "TestData")
	public void ResisterAccountTest(String fname, String lname, String email, String phoneno, String password,
			String cpassword) {
		Log.startTestCase("ResisterAccountTest");
		indexPage = new IndexPage();
		registerPage = new RegisterPage();
		indexPage.clickMyAccount();
		Log.info("Click on MyAccount");
		indexPage.clickToResister();
		Log.info("Click on Resister");
		AccountPage accountPage = registerPage.resisterAccount(fname, lname, email, phoneno, password, cpassword);
		boolean ActualText = accountPage.AccCreatedSuccessText();
		Log.info("Enter all resister accounts inputs parameters ");
		Assert.assertTrue(ActualText);
		Log.info("Verify the actual text");
		Log.endTestCase("ResisterAccountTest");
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}