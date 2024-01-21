package opencart.com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.com.actiondriver.Action;
import opencart.com.base.BaseClass;

public class SearchPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchField;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement searchIcon;

	@FindBy(xpath = "//h2[normalize-space()='Products meeting the search criteria']")
	private WebElement productFound;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement productNotFound;

	@FindBy(xpath = "//input[@id='input-search']")
	private WebElement SearchCriteriaField;

	@FindBy(xpath = "//input[@id='description']")
	private WebElement searchProductDescriptionsCheckbox;

	@FindBy(xpath = "//select[@name='category_id']")
	private WebElement selectCategories;

	@FindBy(xpath = "//input[@name='sub_category']")
	private WebElement selectBySubCategories;

	@FindBy(xpath = "//input[@id='button-search']")
	private WebElement SearchCriteriasearchBtn;

	@FindBy(xpath = "//i[@class='fa fa-th-list']")
	private WebElement listView;

	@FindBy(xpath = "//i[@class='fa fa-th']")
	private WebElement gridview;

	@FindBy(xpath = "//select[@id='input-sort']")
	private WebElement sortBy;

	@FindBy(xpath = "//h4//a")
	private WebElement productName;

	@FindBy(xpath = "//p[@class='price']")
	private WebElement productPrce;

	@FindBy(xpath = "//a[normalize-space()='MacBook']")
	private WebElement macbook;

	public SearchPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean serachValidProduct() {
		action.type(searchField, "Book");
		action.click(getDriver(), searchIcon);
		return action.isDisplayed(getDriver(), productFound);

	}

	public boolean serachInValidProduct() {
		action.type(searchField, "Pen");
		action.click(getDriver(), searchIcon);
		return action.isDisplayed(getDriver(), productNotFound);

	}

	public boolean emptySerachProduct() {
		action.type(searchField, "");
		action.click(getDriver(), searchIcon);
		return action.isDisplayed(getDriver(), productNotFound);
	}

	public void serachProductBySearchCriteria() {
		action.click(getDriver(), SearchCriteriaField);
		action.selectBySendkeys("MacBook", SearchCriteriaField);
		action.click(getDriver(), searchProductDescriptionsCheckbox);
		action.click(getDriver(), SearchCriteriasearchBtn);
	}

	public void serachProductByCategories() {
		action.click(getDriver(), SearchCriteriaField);
		action.selectBySendkeys("Book", SearchCriteriaField);
		action.click(getDriver(), selectCategories);
		action.selectByIndex(selectCategories, 0);
		action.click(getDriver(), selectCategories);
		action.click(getDriver(), selectBySubCategories);
		action.click(getDriver(), SearchCriteriasearchBtn);
	}

	public boolean listAndgridview() {
		action.click(getDriver(), listView);
		action.click(getDriver(), gridview);
		return true;
	}

	public void serachProductByCategoriesAndSort() {
		action.click(getDriver(), sortBy);
		action.selectByIndex(sortBy, 5);
		action.click(getDriver(), sortBy);
	}

	public List<String> getProductName() {
		action.scrollByVisibilityOfElement(getDriver(), macbook);
		List<WebElement> pNames = getDriver().findElements(By.xpath("//h4//a"));
		List<String> actualpElement = new ArrayList<String>();
		for (WebElement ref : pNames) {
			actualpElement.add(ref.getText());
		}
		return actualpElement;
	}

	public List<Double> getProductPrice() {
		action.scrollByVisibilityOfElement(getDriver(), macbook);
		List<WebElement> pPrice = getDriver().findElements(By.xpath("//p[@class='price']//span[1]"));
		List<Double> actualpPrice = new ArrayList<Double>();
		
		for (int i = 0; i < pPrice.size(); i++) {
			double price = Double.parseDouble(pPrice.get(i).getText());
			System.out.println(price);
		}
		return actualpPrice;
		
		
		/* for (int i = 0; i < pPrice.size(); i++) {

			String text = pPrice.get(i).getText();
			String str = text.replaceAll("[^a-zA-Z0-9]", " ");
		    int amt = Integer.parseInt(text.replaceAll("[^a-zA-Z0-9]", " ").toString());
		
		
		 public double getUnitPrice() {
		     String unitPrice1=unitPrice.getText();
		     String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		     double finalUnitPrice=Double.parseDouble(unit);
		     return finalUnitPrice/100;   */
		
		 	
	}
}