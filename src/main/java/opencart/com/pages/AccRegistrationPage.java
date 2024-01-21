package opencart.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.com.actiondriver.Action;
import opencart.com.base.BaseClass;

public class AccRegistrationPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement txtLasttname;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement chkdPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement msgConfirmation;

	public AccRegistrationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void setFirstName(String fname) {
		action.type(txtFirstname, fname);
	}
	public void setLastName(String lname) {
		action.type(txtLasttname, lname);

	}

	public void setEmail(String email) {
		action.type(txtEmail, email);

	}

	public void setTelephone(String tel) {
		action.type(txtTelephone, tel);

	}

	public void setPassword(String pwd) {
		action.type(txtPassword, pwd);
	}

	public void setConfirmPassword(String pwd) {
		action.type(txtConfirmPassword, pwd);
	}

	public void setPrivacyPolicy() {
		action.click(getDriver(), chkdPolicy);

	}

	public void clickContinue() {
		action.click(getDriver(), btnContinue);

		// sol2
		// btnContinue.submit();

		// sol3
		// Actions act=new Actions(driver);
		// act.moveToElement(btnContinue).click().perform();

		// sol4
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", btnContinue);

		// Sol 5
		// btnContinue.sendKeys(Keys.RETURN);

		// Sol6
		// WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();

	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
}
