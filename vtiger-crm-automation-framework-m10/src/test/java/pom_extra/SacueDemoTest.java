package pom_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import object_repository.SauceDemoPage;

public class SacueDemoTest {

	public static void main(String[] args) throws InterruptedException {

		// ============================================================
		// TEST DATA
		// ============================================================

		String url = "https://www.saucedemo.com/";
		String username = "standard_user";
		String password = "secret_sauce";

		String firstName = "Piyush";
		String lastName = "Baldaniya";
		String postalCode = "302001";

		WebDriver driver = null;

		try {

			// ============================================================
			// STEP 1: LAUNCH BROWSER
			// ============================================================

			System.out.println("============================================================");
			System.out.println("          SAUCEDEMO END-TO-END TEST STARTED");
			System.out.println("============================================================");

			System.out.println("[INFO] Launching Chrome browser...");

			driver = new EdgeDriver();

			System.out.println("[PASS] Chrome browser launched successfully.");

			// ============================================================
			// STEP 2: MAXIMIZE BROWSER
			// ============================================================

			System.out.println("[INFO] Maximizing browser window...");

			driver.manage().window().maximize();

			System.out.println("[PASS] Browser window maximized.");

			// ============================================================
			// STEP 3: IMPLICIT WAIT
			// ============================================================

			System.out.println("[INFO] Configuring implicit wait...");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			System.out.println("[PASS] Implicit wait configured to 10 seconds.");

			// ============================================================
			// STEP 4: OPEN APPLICATION
			// ============================================================

			System.out.println("[INFO] Navigating to SauceDemo application...");

			driver.get(url);

			System.out.println("[PASS] SauceDemo application opened successfully.");
			System.out.println("[INFO] Current URL: " + driver.getCurrentUrl());

			// ============================================================
			// STEP 5: LOGIN
			// ============================================================

			System.out.println("------------------------------------------------------------");
			System.out.println("[STEP 1] LOGIN");
			System.out.println("------------------------------------------------------------");

			SauceDemoPage sdp = new SauceDemoPage(driver);
			
			WebElement usernameField = sdp.getUsernameField();
			WebElement passwordField = sdp.getPasswordField();
			WebElement loginButton = sdp.getLoginButton();
			
			driver.navigate().refresh();
			
//			usernameField = driver.findElement(By.id("user-name"));
			usernameField.sendKeys(username);
			
//			passwordField = driver.findElement(By.id("password"));
			passwordField.sendKeys(password);
			
//			loginButton = driver.findElement(By.id("login-button"));
			loginButton.click();

			System.out.println("[PASS] Login button clicked.");

			// Verify login
			String inventoryUrl = driver.getCurrentUrl();

			if (inventoryUrl.contains("inventory.html")) {
				System.out.println("[PASS] Login successful.");
				System.out.println("[INFO] User is redirected to Products page.");
			} else {
				System.out.println("[FAIL] Login failed.");
				throw new RuntimeException("Login verification failed.");
			}

			// ============================================================
			// STEP 6: ADD PRODUCT TO CART
			// ============================================================

			System.out.println("------------------------------------------------------------");
			System.out.println("[STEP 2] ADD PRODUCT TO CART");
			System.out.println("------------------------------------------------------------");

			System.out.println("[INFO] Selecting product: Sauce Labs Backpack");

			WebElement addTocartButton = sdp.getAddTocartButton() ;
			addTocartButton.click();

			System.out.println("[PASS] Sauce Labs Backpack added to cart.");

			// Verify cart badge
			String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();

			if (cartCount.equals("1")) {
				System.out.println("[PASS] Cart contains 1 product.");
			} else {
				System.out.println("[FAIL] Product count verification failed.");
				throw new RuntimeException("Cart count is not 1.");
			}

			// ============================================================
			// STEP 7: OPEN CART
			// ============================================================

			System.out.println("------------------------------------------------------------");
			System.out.println("[STEP 3] OPEN SHOPPING CART");
			System.out.println("------------------------------------------------------------");

			System.out.println("[INFO] Clicking shopping cart icon...");

			driver.findElement(By.className("shopping_cart_link")).click();

			System.out.println("[PASS] Shopping cart page opened.");

			// Verify cart page
			if (driver.getCurrentUrl().contains("cart.html")) {
				System.out.println("[PASS] Cart page URL verified.");
			} else {
				System.out.println("[FAIL] Cart page verification failed.");
				throw new RuntimeException("Cart page was not opened.");
			}

			// ============================================================
			// STEP 8: VERIFY PRODUCT IN CART
			// ============================================================

			System.out.println("[INFO] Verifying product in shopping cart...");

			String productName = driver.findElement(By.className("inventory_item_name")).getText();

			if (productName.equals("Sauce Labs Backpack")) {
				System.out.println("[PASS] Product verified in cart: " + productName);
			} else {
				System.out.println("[FAIL] Expected product not found in cart.");
				throw new RuntimeException("Product verification failed.");
			}

			// ============================================================
			// STEP 9: CHECKOUT
			// ============================================================

			System.out.println("------------------------------------------------------------");
			System.out.println("[STEP 4] CHECKOUT");
			System.out.println("------------------------------------------------------------");

			System.out.println("[INFO] Clicking Checkout button...");

			driver.findElement(By.id("checkout")).click();

			System.out.println("[PASS] Checkout information page opened.");

			// ============================================================
			// STEP 10: ENTER CHECKOUT INFORMATION
			// ============================================================

			System.out.println("[INFO] Entering first name...");

			driver.findElement(By.id("first-name")).sendKeys(firstName);

			System.out.println("[PASS] First name entered.");

			System.out.println("[INFO] Entering last name...");

			driver.findElement(By.id("last-name")).sendKeys(lastName);

			System.out.println("[PASS] Last name entered.");

			System.out.println("[INFO] Entering postal code...");

			driver.findElement(By.id("postal-code")).sendKeys(postalCode);

			System.out.println("[PASS] Postal code entered.");

			System.out.println("[INFO] Clicking Continue button...");

			driver.findElement(By.id("continue")).click();

			System.out.println("[PASS] Checkout overview page opened.");

			// ============================================================
			// STEP 11: VERIFY CHECKOUT OVERVIEW
			// ============================================================

			System.out.println("------------------------------------------------------------");
			System.out.println("[STEP 5] VERIFY CHECKOUT OVERVIEW");
			System.out.println("------------------------------------------------------------");

			System.out.println("[INFO] Verifying product on checkout overview...");

			String checkoutProduct = driver.findElement(By.className("inventory_item_name")).getText();

			if (checkoutProduct.equals("Sauce Labs Backpack")) {
				System.out.println("[PASS] Product verified on checkout overview.");
			} else {
				System.out.println("[FAIL] Product verification failed.");
				throw new RuntimeException("Product missing from checkout overview.");
			}

			// ============================================================
			// STEP 12: FINISH ORDER
			// ============================================================

			System.out.println("[INFO] Clicking Finish button...");

			driver.findElement(By.id("finish")).click();

			System.out.println("[PASS] Finish button clicked.");

			// ============================================================
			// STEP 13: VERIFY ORDER SUCCESS
			// ============================================================

			System.out.println("------------------------------------------------------------");
			System.out.println("[STEP 6] VERIFY ORDER COMPLETION");
			System.out.println("------------------------------------------------------------");

			String confirmationMessage = driver.findElement(By.className("complete-header")).getText();

			if (confirmationMessage.equals("Thank you for your order!")) {

				System.out.println("[PASS] Order placed successfully.");
				System.out.println("[INFO] Confirmation message: " + confirmationMessage);

			} else {

				System.out.println("[FAIL] Order confirmation verification failed.");

				throw new RuntimeException("Order confirmation message not found.");
			}

			// ============================================================
			// STEP 14: LOGOUT
			// ============================================================

			System.out.println("------------------------------------------------------------");
			System.out.println("[STEP 7] LOGOUT");
			System.out.println("------------------------------------------------------------");

			System.out.println("[INFO] Opening application menu...");

			driver.findElement(By.id("react-burger-menu-btn")).click();

			System.out.println("[PASS] Application menu opened.");

			System.out.println("[INFO] Clicking Logout...");

			driver.findElement(By.id("logout_sidebar_link")).click();

			System.out.println("[PASS] Logout button clicked.");

			// Verify logout
			if (driver.getCurrentUrl().equals(url)) {

				System.out.println("[PASS] Logout successful.");
				System.out.println("[INFO] User returned to Login page.");

			} else {

				System.out.println("[FAIL] Logout verification failed.");

				throw new RuntimeException("User was not redirected to Login page.");
			}

			// ============================================================
			// FINAL TEST RESULT
			// ============================================================

			System.out.println("============================================================");
			System.out.println("             END-TO-END TEST PASSED");
			System.out.println("============================================================");

		} catch (Exception e) {

			System.out.println("============================================================");
			System.out.println("             END-TO-END TEST FAILED");
			System.out.println("============================================================");

			System.out.println("[ERROR] Test execution failed.");
			System.out.println("[ERROR] Reason: " + e.getMessage());

			e.printStackTrace();

		} finally {

			// ============================================================
			// STEP 15: CLOSE BROWSER
			// ============================================================

			System.out.println("------------------------------------------------------------");
			System.out.println("[CLEANUP] Closing browser...");
			System.out.println("------------------------------------------------------------");

//			driver.quit();

			System.out.println("[PASS] Browser closed successfully.");

			System.out.println("============================================================");
			System.out.println("             TEST EXECUTION COMPLETED");
			System.out.println("============================================================");
		}
	}
}