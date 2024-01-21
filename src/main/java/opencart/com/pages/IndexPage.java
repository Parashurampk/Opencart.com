/**
 * 
 */
package opencart.com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.com.actiondriver.Action;
import opencart.com.base.BaseClass;

/**
 * @author Parashuram
 *
 */
public class IndexPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//div[@class='col-sm-4']//a")
	private WebElement logoElement;

	@FindBy(xpath = ".//*[@class='nav navbar-nav']/li")
	private WebElement indexElements;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement clickMyAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement clickResister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement clickLogin;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean logoElement() {
		return action.isDisplayed(getDriver(), logoElement);
	}

	public boolean indexElements() {
		return action.isDisplayed(getDriver(), indexElements);
	}

	public List<String> indexElementsList() {
		List<WebElement> list_webelements = getDriver().findElements(By.xpath(".//*[@class='nav navbar-nav']/li"));
		List<String> actualContents = new ArrayList<String>();
		for (WebElement ref : list_webelements) {
			actualContents.add(ref.getText());
		}
		return actualContents;

	}

	public void clickMyAccount() {
		action.click(getDriver(), clickMyAccount);
	}

	public void clickToResister() {
		action.click(getDriver(), clickResister);
	}

}
