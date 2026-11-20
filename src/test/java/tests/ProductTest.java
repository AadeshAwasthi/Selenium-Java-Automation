package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    private ProductsPage products;

    @BeforeMethod
    public void login() {
        products = new LoginPage(driver).login(VALID_USER, PASSWORD);
    }

    @Test(description = "TC_013: All six products are displayed")
    public void sixProductsAreDisplayed() {
        Assert.assertEquals(products.getProductCount(), 6);
    }

    @Test(description = "TC_015: Sort products by Name (Z to A)")
    public void sortByNameDescending() {
        products.sortBy("Name (Z to A)");

        List<String> actual = products.getProductNames();
        List<String> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "TC_016: Sort products by Price (low to high)")
    public void sortByPriceLowToHigh() {
        products.sortBy("Price (low to high)");

        List<Double> actual = products.getProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "TC_017: Sort products by Price (high to low)")
    public void sortByPriceHighToLow() {
        products.sortBy("Price (high to low)");

        List<Double> actual = products.getProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        Assert.assertEquals(actual, expected);
    }
}
