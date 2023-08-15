package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ACLoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public ACLoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(id = "ap_email")
	WebElement emailField;

	public void enterEmailAddress(String emailText) {

		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	@FindBy(id = "continue")
	WebElement continueButton;

	public void clickContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(id = "ap_password")
	WebElement password;

	public void enterPassword(String passwordText) {

		elementUtils.typeTextIntoElement(password, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	@FindBy(id = "signInSubmit")
	WebElement signInSubmit;

	public ACHomePage clicksignInSubmit() {

		elementUtils.clickOnElement(signInSubmit, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new ACHomePage(driver);

	}

	@FindBy(xpath = "//span[@class='a-list-item']")
	private WebElement warningMessage;

	public String getWarningMessageText() {

		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	@FindBy(xpath = "(//div[@class='a-alert-content'])[3]")
	private WebElement warningMsg;

	public String getWarningMessageinText() {

		return elementUtils.getTextFromElement(warningMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

}
