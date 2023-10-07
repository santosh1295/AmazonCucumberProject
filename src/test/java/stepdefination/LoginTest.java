package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.ACAccountPage;
import pages.ACHomePage;
import pages.ACLoginPage;

import utils.CommonUtils;

public class LoginTest {
	
	WebDriver driver;
	private ACHomePage homePage;
	private ACLoginPage loginPage;
	private ACAccountPage accountPage;
	private CommonUtils commonUtils;
	
	@Given("User navigate to login page")
	public void user_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		ACHomePage homePage = new ACHomePage(driver);
		loginPage =homePage.clickLoginOption();
		 
	}
	
	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String validemailText) {
		
	    loginPage.enterEmailAddress(validemailText);
	}
	
	@When("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String validpwd) {
		
	    loginPage.enterPassword(validpwd);
	}

	@When("click on continue button")
	public void click_on_continue_button() {
		
	    loginPage.clickContinueButton();
	}

	@When("click on sign in button")
	public void click_on_sign_in_button() {
		
	    loginPage.clicksignInSubmit();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		Assert.assertTrue(accountPage.displayAccountName());
	    
	}

	@When("User enters Invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String InvalidemailText) {
		
		loginPage.enterEmailAddress(InvalidemailText);
	
	}

	@Then("User should get warning message about credentials mismatch")
	public void user_should_get_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.getWarningMessageText().contains("We cannot find an account with that email address"));
		
	}

	@When("User enters Invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPassword) {
		
		loginPage.enterPassword(invalidPassword);
	}
	@Then("User should get warning message about password mismatch")
	public void user_should_get_warning_message_about_password_mismatch() {
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Your password is incorrect"));
		
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginPage.enterEmailAddress("");
	}
	@Then("User should get warning message about credentials")
	public void user_should_get_warning_message_about_credentials() {
		Assert.assertTrue(loginPage.getWarningMessageinText().contains("Enter your email or mobile phone number"));
		
	}

}
