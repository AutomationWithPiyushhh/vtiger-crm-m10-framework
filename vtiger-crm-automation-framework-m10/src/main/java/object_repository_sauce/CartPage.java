package object_repository_sauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	// ============================================================
	// CART PAGE
	// ============================================================

	@FindBy(className = "inventory_item_name")
	private WebElement productName;

	@FindBy(id = "checkout")
	private WebElement checkoutButton;

	// ============================================================
	// CONSTRUCTOR
	// ============================================================

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// GETTER METHODS
	// ============================================================

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}

}