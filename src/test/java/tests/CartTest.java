package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    private ProductsPage products;

    @BeforeMethod
    public void login() {
        products = new LoginPage(driver).login(VALID_USER, PASSWORD);
    }

    @Test(description = "TC_023: Add a single product to cart")
    public void addSingleProduct() {
        products.addToCart("sauce-labs-backpack");

        Assert.assertEquals(products.getCartCount(), 1);
    }

    @Test(description = "TC_024: Add multiple products to cart")
    public void addMultipleProducts() {
        products.addToCart("sauce-labs-backpack");
        products.addToCart("sauce-labs-bike-light");
        products.addToCart("sauce-labs-onesie");

        Assert.assertEquals(products.getCartCount(), 3);
    }

    @Test(description = "TC_025: Remove product from Products page")
    public void removeFromProductsPage() {
        products.addToCart("sauce-labs-backpack");
        products.removeFromCart("sauce-labs-backpack");

        Assert.assertEquals(products.getCartCount(), 0);
    }

    @Test(description = "TC_026 and TC_027: Cart page shows the product and it can be removed")
    public void cartPageShowsAndRemovesProduct() {
        products.addToCart("sauce-labs-backpack");
        products.addToCart("sauce-labs-bike-light");
        CartPage cart = products.openCart();

        Assert.assertTrue(cart.getItemNames().contains("Sauce Labs Backpack"));
        Assert.assertEquals(cart.getItemNames().size(), 2);

        cart.removeItem("sauce-labs-backpack");
        Assert.assertEquals(cart.getItemNames().size(), 1);
    }
}
