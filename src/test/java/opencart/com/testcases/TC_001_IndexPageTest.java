/**
 * 
 */
package opencart.com.testcases;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import opencart.com.base.BaseClass;
import opencart.com.pages.IndexPage;
import opencart.com.utility.Log;

/**
 * @author Parashuram
 *
 */
public class TC_001_IndexPageTest extends BaseClass {

	private IndexPage indexPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}

	@Test(priority = 1, groups = {"Smoke","Sanity","Regression"})
	public void validatelogoTest() {
		Log.startTestCase("validatelogoTest");
		indexPage = new IndexPage();
		boolean logo = indexPage.logoElement();	
		Assert.assertTrue(logo);
		Log.info("Verifying logo");
		Log.endTestCase("LoginTest");
	}

	@Test(priority = 2, groups = {"Smoke","Sanity","Regression"})
	public void validateIndexElementPresent() {
		Log.startTestCase("validateIndexElementPresent");
		indexPage = new IndexPage();
		boolean indexEmts = indexPage.indexElements();
		Assert.assertTrue(indexEmts);
		Log.info("Verifying indexElemet");
		Log.endTestCase("validateIndexElementPresent");
	}

	@Test(priority = 3, groups = {"Smoke","Sanity",})
	public void validateIndexElementsListTest() {
		Log.startTestCase("validateIndexElementsListTest");
		indexPage = new IndexPage();
		List<String> actualValues = indexPage.indexElementsList();
		List<String> expectedValues = Arrays.asList("Desktops", "Laptops & Notebooks", "Components", "Tablets",
				"Software", "Phones & PDAs", "Cameras", "MP3 Players");
		Assert.assertEquals(actualValues, expectedValues);
		Log.info("Verifying validateIndexElementsList");
		Log.endTestCase("validateIndexElementsListTest");
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
