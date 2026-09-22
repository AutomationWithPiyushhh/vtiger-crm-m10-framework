package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;

public class HomePage {
//	constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

// elment
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

//	css = "img[src='themes/softed/images/user.PNG']"
//	xpath = "//td[contains(@onmouseover, 'abc')]/img"
	
//	auto healing
	@FindAll({
				@FindBy(css = "img[src='themes/softed/pics/user.PNG']"),
				@FindBy(xpath = "//td[contains(@onmouseover, 'abc')]/img")
	})
	private WebElement profileIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;


	
//	getters
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
}
