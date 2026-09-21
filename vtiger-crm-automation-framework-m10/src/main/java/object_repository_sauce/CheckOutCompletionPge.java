package object_repository_sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletionPge {

	// ============================================================
	// CHECKOUT OVERVIEW PAGE
	// ============================================================

	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	private WebElement ConfirmationMessage;

	// ============================================================
	// CONSTRUCTOR
	// ============================================================

	public CheckOutCompletionPge(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// GETTER METHODS
	// ============================================================

	public WebElement getConfirmationMessage() {
		return ConfirmationMessage;
	}


}