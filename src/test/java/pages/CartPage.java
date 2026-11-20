package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** Page Object for the Cart page. */
public class CartPage {

    private final WebDriver driver;

    private final By cartItemNames = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (WebElement element : driver.findElements(cartItemNames)) {
            names.add(element.getText());
        }
        return names;
    }

    public void removeItem(String productId) {
        driver.findElement(By.id("remove-" + productId)).click();
    }

    public CheckoutPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }

    public ProductsPage continueShopping() {
        driver.findElement(continueShoppingButton).click();
        return new ProductsPage(driver);
    }
}
