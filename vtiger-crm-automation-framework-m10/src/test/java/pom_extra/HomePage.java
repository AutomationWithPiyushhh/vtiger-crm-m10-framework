package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// ============================================================
	// HOME PAGE
	// ============================================================

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addTocartButton;

	@FindBy(className = "shopping_cart_badge")
	private WebElement shoppingCartBadge;

	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingCartLink;

	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuButton;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutButton;

	// ============================================================
	// CONSTRUCTOR
	// ============================================================

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// GETTER METHODS
	// ============================================================

	public WebElement getAddTocartButton() {
		return addTocartButton;
	}

	public WebElement getShoppingCartBadge() {
		return shoppingCartBadge;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getMenuButton() {
		return menuButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
}