package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ACAccountPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public ACAccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement accountName;
	
	public boolean displayAccountName() {
		
		return elementUtils.displayStatusOfElement(accountName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}

}
