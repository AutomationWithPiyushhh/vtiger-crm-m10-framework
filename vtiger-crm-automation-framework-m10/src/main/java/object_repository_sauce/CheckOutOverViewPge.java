package object_repository_sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverViewPge {

	// ============================================================
	// CHECKOUT OVERVIEW PAGE
	// ============================================================

	@FindBy(id = "finish")
	private WebElement finishButton;

	// ============================================================
	// CONSTRUCTOR
	// ============================================================

	public CheckOutOverViewPge(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// GETTER METHODS
	// ============================================================

	public WebElement getFinishButton() {
		return finishButton;
	}

}