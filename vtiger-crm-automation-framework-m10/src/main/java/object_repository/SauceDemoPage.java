package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoPage {
	
	public SauceDemoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
//	declaration
	@FindBy( id = "user-name")
	private WebElement usernameField;
	
	@FindBy( id = "password")
	private WebElement passwordField;
	
	@FindBy( id = "login-button")
	private WebElement loginButton;
	
	public WebElement getUsernameField() {
		return usernameField;
	}
	
	public WebElement getPasswordField() {
		return passwordField;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack" )
	private WebElement addTocartButton;
	
	public WebElement getAddTocartButton() {
		return addTocartButton;
	}
	
	
	/* create a class in src/test/java => SauceDemoTest.java
	 * There write a test script for end to end scenario for SauceDemo website
	 * 
	 * Then create a package in src/main/java => object_repository
	 * create class inside that package => SauceDemoPage.java
	 * 
	 * here in SauceDemoPage declare every webelement used in script
	 * e.g., usernameField, passwordField, loginButton etc
	 * 
	 *  
	 * initialize them through PageFactory class in constructor
	 * 
	 * utilize them in your test script and all set !!!
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	*/	
	
}
