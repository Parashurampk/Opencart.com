package opencart.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.com.actiondriver.Action;
import opencart.com.base.BaseClass;

public class LoginPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement ClkmyAct;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement clkLogin;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passWrd;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[normalize-space()='Account']")
	private WebElement Account;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// emailAddress and passWrd by passing parameter
	public AccountPage loginAccount(String uname, String pswd) {
		action.click(getDriver(), ClkmyAct);
		action.click(getDriver(), clkLogin);
		action.type(emailAddress, uname);
		action.type(passWrd, pswd);
		action.click(getDriver(), loginBtn);
		return new AccountPage();

	}

	public void clickMyAccount() {
		action.click(getDriver(), ClkmyAct);
	}

	public void clickLogin() {
		action.click(getDriver(), clkLogin);
	}

	public void setEmail(String uname) {
		action.type(emailAddress, uname);
	}

	public void setPassword(String pswd) {
		action.type(passWrd, pswd);
	}

	public AccountPage Account() {
		action.click(getDriver(), loginBtn);
		return new AccountPage();
	}

}
