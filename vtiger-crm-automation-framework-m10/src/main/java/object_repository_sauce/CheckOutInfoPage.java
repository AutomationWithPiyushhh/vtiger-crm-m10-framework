package object_repository_sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInfoPage {

	// ============================================================
	// CHECKOUT INFORMATION PAGE
	// ============================================================

	@FindBy(id = "first-name")
	private WebElement firstNameField;

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "postal-code")
	private WebElement postalCodeField;

	@FindBy(id = "continue")
	private WebElement continueButton;

	// ============================================================
	// CONSTRUCTOR
	// ============================================================

	public CheckOutInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// GETTER METHODS
	// ============================================================

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getPostalCodeField() {
		return postalCodeField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

}