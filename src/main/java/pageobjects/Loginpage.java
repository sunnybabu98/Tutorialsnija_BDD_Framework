package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
     
	@FindBy(id="input-email")
    private WebElement emailAddressField;
	

	@FindBy(id="input-password")
    private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
    private WebElement mylogin;
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	public void enterpassword(String passwordtext) {
		passwordField.sendKeys(passwordtext);
	}
	public AccountPage clickonloginbutton() {
		mylogin.click();
		return new AccountPage(driver);
	}
}
