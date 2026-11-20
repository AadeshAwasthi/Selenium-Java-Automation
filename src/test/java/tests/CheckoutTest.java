package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    private CheckoutPage checkout;

    @BeforeMethod
    public void addProductsAndStartCheckout() {
        ProductsPage products = new LoginPage(driver).login(VALID_USER, PASSWORD);
        products.addToCart("sauce-labs-backpack");    // $29.99
        products.addToCart("sauce-labs-bike-light");  // $9.99
        checkout = products.openCart().clickCheckout();
    }

    @Test(description = "TC_034: Checkout with empty First Name")
    public void firstNameIsRequired() {
        checkout.enterInformation("", "Awasthi", "452001");

        Assert.assertTrue(checkout.getErrorMessage().contains("First Name is required"));
    }

    @Test(description = "TC_036: Checkout with empty Postal Code")
    public void postalCodeIsRequired() {
        checkout.enterInformation("Aadesh", "Awasthi", "");

        Assert.assertTrue(checkout.getErrorMessage().contains("Postal Code is required"));
    }

    @Test(description = "TC_038 and TC_039: Item total, tax and total are correct")
    public void totalsAreCalculatedCorrectly() {
        checkout.enterInformation("Aadesh", "Awasthi", "452001");

        Assert.assertEquals(checkout.getItemTotal(), 39.98, 0.001);
        Assert.assertEquals(checkout.getTotal(), checkout.getItemTotal() + checkout.getTax(), 0.001);
    }

    @Test(description = "TC_040: End-to-end order placement")
    public void completeOrder() {
        checkout.enterInformation("Aadesh", "Awasthi", "452001");
        checkout.clickFinish();

        Assert.assertEquals(checkout.getConfirmationMessage(), "Thank you for your order!");
    }
}
