package opencart.com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import opencart.com.actiondriver.Action;
import opencart.com.base.BaseClass;

public class RegisterPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephone;

	@FindBy(xpath = "(//input[@id='input-password'])[1]")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement ConfirmPassword;

	@FindBy(xpath = "(//input[@value='0'])[1]")
	private WebElement selectNoCheckBtn;

	@FindBy(xpath = "(//input[@name='agree'])[1]")
	private WebElement selectPrivacyCheck;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement clickContinueBtn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement AccCreatedSuccessText;

	@FindBy(xpath = "//div[@class='list-group']//a")
	private WebElement accListGrpElemets;

	public RegisterPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	/*
	 * public void createOpencartAccount() {
	 * action.scrollByVisibilityOfElement(driver, ConfirmPassword);
	 * action.type(firstname, "Reshma");
	 * action.type(lastName, "Walikindi");
	 */

	public AccountPage resisterAccount(String fname, String lname, String email, String phoneno, String password,
			String cpassword) {
		action.scrollByVisibilityOfElement(getDriver(), ConfirmPassword);
		action.type(firstname, fname);
		action.type(lastName, lname);
		action.type(emailAddress, email);
		action.type(telephone, phoneno);
		action.type(passwordField, password);
		action.type(ConfirmPassword, cpassword);
		action.click(getDriver(), selectNoCheckBtn);
		action.click(getDriver(), selectPrivacyCheck);
		action.scrollByVisibilityOfElement(getDriver(), clickContinueBtn);
		action.click(getDriver(), clickContinueBtn);
		return new AccountPage();
	}

	public boolean AccCreatedTextPresent() {
		action.explicitWait(getDriver(), AccCreatedSuccessText, 20);
		return action.isDisplayed(getDriver(), AccCreatedSuccessText);
	}

	public List<String> accountListGrpElemets() {
		List<WebElement> ActualWebElements = getDriver().findElements(By.xpath("//div[@class='list-group']//a"));
		List<String> actualContents = new ArrayList<String>();

		for (WebElement ref : ActualWebElements) {
			actualContents.add(ref.getText());
		}
		return actualContents;
	}

}