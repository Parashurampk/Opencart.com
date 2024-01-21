package opencart.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import opencart.com.actiondriver.Action;
import opencart.com.base.BaseClass;

public class AccountPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement AccCreatedSuccessTexts;

	public boolean AccCreatedSuccessText() {
		return action.isDisplayed(getDriver(), AccCreatedSuccessTexts);

	}

	public String getCurentURL() {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
		
	}
		
		
}
