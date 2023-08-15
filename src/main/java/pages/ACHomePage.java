package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ACHomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public ACHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//div[@class='nav-line-1-container']/span")
	private WebElement signInButton;

	public ACLoginPage clickLoginOption() {

		elementUtils.clickOnElement(signInButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new ACLoginPage(driver);

	}

}
