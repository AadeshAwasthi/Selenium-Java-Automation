package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test(description = "TC_001: Login with valid standard user")
    public void validLogin() {
        ProductsPage products = new LoginPage(driver).login(VALID_USER, PASSWORD);

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        Assert.assertEquals(products.getPageTitle(), "Products");
    }

    // Data-driven test: one test method runs with many sets of data
    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][] {
            { "standard_user", "wrong_pass", "Username and password do not match" },   // TC_002
            { "invalid_user", "secret_sauce", "Username and password do not match" },  // TC_003
            { "", "", "Username is required" },                                        // TC_004
            { "standard_user", "", "Password is required" },                           // TC_005
            { "locked_out_user", "secret_sauce", "this user has been locked out" },    // TC_006
        };
    }

    @Test(dataProvider = "invalidLogins", description = "TC_002 to TC_006: Invalid login shows error")
    public void invalidLogin(String username, String password, String expectedError) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedError),
                "Actual error: " + loginPage.getErrorMessage());
    }

    @Test(description = "TC_046: Logout from the application")
    public void logout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage products = loginPage.login(VALID_USER, PASSWORD);
        products.logout();

        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }
}
