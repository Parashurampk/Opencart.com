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
import opencart.com.pages.LoginPage;
import opencart.com.pages.SearchPage;
import opencart.com.utility.Log;

public class TC_005_SearchPageTest extends BaseClass {

	private SearchPage searchPage;
	private LoginPage loginPage;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}

	@Test(priority = 1, groups = {"Smoke","Regression"})
	public void validSerachProductTest() {
		Log.startTestCase("validSerachProductTest");
		searchPage = new SearchPage();
		boolean searchStatus = searchPage.serachValidProduct();
		Assert.assertTrue(searchStatus);
		Log.endTestCase("validSerachProductTest");
	}

	@Test(priority = 2,groups = "Regression")
	public void InvalidSerachProductTest() {
		Log.startTestCase("InvalidSerachProductTest");
		searchPage = new SearchPage();
		boolean searchStatus = searchPage.serachInValidProduct();
		Assert.assertTrue(searchStatus);
		Log.endTestCase("InvalidSerachProductTest");
	}

	@Test(priority = 3, groups = "Regression")
	public void emptySerachProductTest() {
		Log.startTestCase("emptySerachProductTest");
		searchPage = new SearchPage();
		boolean searchStatus = searchPage.emptySerachProduct();
		Assert.assertTrue(searchStatus);
		Log.endTestCase("emptySerachProductTest");

	}

	@Test(priority = 4,groups = "Regression")
	public void searchAfterLogin() {
		Log.startTestCase("searchAfterLogin");
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		loginPage.loginAccount("walikindi@gmail.com", "6362772735");
		boolean searchResults = searchPage.serachInValidProduct();
		Assert.assertTrue(searchResults);
		Log.endTestCase("searchAfterLogin");
	}

	@Test(priority = 5,groups = "Regression")
	public void serachProductBySearchCriteriaTest() {
		Log.startTestCase("serachProductBySearchCriteriaTest");
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		loginPage.loginAccount("walikindi@gmail.com", "6362772735");
		searchPage.serachValidProduct();
		searchPage.serachProductBySearchCriteria();
		Log.endTestCase("serachProductBySearchCriteriaTest");
	}

	@Test(priority = 6,groups = "Regression")
	public void searchUsingTextFrmProductDescriptionTest() {
		Log.startTestCase("searchUsingTextFrmProductDescriptionTest");
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		loginPage.loginAccount("walikindi@gmail.com", "6362772735");
		searchPage.emptySerachProduct();
		searchPage.serachProductBySearchCriteria();
		Log.endTestCase("searchUsingTextFrmProductDescriptionTest");
	}

	@Test(priority = 7, groups = "Regression")
	public void serachProductByCategoriesTest() {
		Log.startTestCase("serachProductByCategoriesTest");
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		loginPage.loginAccount("walikindi@gmail.com", "6362772735");
		searchPage.emptySerachProduct();
		searchPage.serachProductByCategories();
		Log.endTestCase("serachProductByCategoriesTest");
	}

	@Test(priority = 8, groups = "Regression")
	public void valiadtelistAndgridviewTest() {
		Log.startTestCase("valiadtelistAndgridviewTest");
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		loginPage.loginAccount("walikindi@gmail.com", "6362772735");
		searchPage.emptySerachProduct();
		searchPage.serachProductByCategories();
		boolean results = searchPage.listAndgridview();
		Assert.assertTrue(results);
		Log.endTestCase("valiadtelistAndgridviewTest");
	}

	@Test(priority = 9, groups = "Regression")
	public void serachProductByCategoriesAndSortTest() {
		Log.startTestCase("serachProductByCategoriesAndSortTest");
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		loginPage.loginAccount("walikindi@gmail.com", "6362772735");
		searchPage.emptySerachProduct();
		searchPage.serachProductByCategories();
		searchPage.serachProductByCategoriesAndSort();
		Log.endTestCase("serachProductByCategoriesAndSortTest");

	}

	@Test(priority = 10, groups = "Regression")
	public void getProductNameTest() {
		Log.startTestCase("getProductNameTest");
		searchPage = new SearchPage();
		List<String> actualnames = searchPage.getProductName();
		System.out.println(actualnames);
		List<String> expectednames=Arrays.asList("MacBook", "iPhone","Apple Cinema 30\"","Canon EOS 5D");
		Assert.assertEquals(actualnames, expectednames);
		Log.endTestCase("getProductNameTest");
	}
	
	@Test(priority = 11, groups = "Regression")
	public void getProductPriceTest() {
		Log.startTestCase("getProductPriceTest");
		searchPage = new SearchPage();
		List<Double> actualPrice = searchPage.getProductPrice();
//		List<Double> expectPrice=Arrays.asList("Ex Tax   500 00", "Ex Tax   101 00","110 00"," 98 00");
//		Assert.assertEquals(actualPrice, expectPrice);
		Log.endTestCase("getProductPriceTest");
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
