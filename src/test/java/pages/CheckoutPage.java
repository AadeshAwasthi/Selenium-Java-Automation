package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Page Object for the three checkout pages: Information, Overview and Complete. */
public class CheckoutPage {

    private final WebDriver driver;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By errorMessage = By.cssSelector("[data-test='error']");
    private final By itemTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By total = By.className("summary_total_label");
    private final By completeHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterInformation(String first, String last, String zip) {
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public double getItemTotal() {
        return amountOf(itemTotal);
    }

    public double getTax() {
        return amountOf(tax);
    }

    public double getTotal() {
        return amountOf(total);
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(completeHeader).getText();
    }

    /** Reads text like "Item total: $39.98" and returns 39.98 */
    private double amountOf(By locator) {
        String text = driver.findElement(locator).getText();
        return Double.parseDouble(text.substring(text.indexOf('$') + 1));
    }
}
