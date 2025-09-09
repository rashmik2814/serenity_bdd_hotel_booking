package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class BookHotelPage extends PageObject {

    @FindBy(id = "first_name")
    WebElement firstNameField;

    @FindBy(id = "last_name")
    WebElement lastNameField;

    @FindBy(id = "address")
    WebElement billingAddressField;

   // @FindBy(id = "cc_num")
    @FindBy(css = "input[id='cc_num']")
    WebElement creditCardNumberField;

    @FindBy(id = "cc_type")
    WebElement creditCardTypeDropdown;

    @FindBy(id = "cc_exp_month")
    WebElement expiryMonthDropdown;

    @FindBy(id = "cc_exp_year")
    WebElement expiryYearDropdown;

    @FindBy(id = "cc_cvv")
    WebElement cvvField;

    @FindBy(id = "book_now")
    WebElement bookNowButton;

    @FindBy(css = "a[href='Logout.php']")
    WebElement logoutButton;

    public void bookHotel(Map<String, String> details) {
        firstNameField.sendKeys(details.get("firstName"));
        lastNameField.sendKeys(details.get("lastName"));
        billingAddressField.sendKeys(details.get("billingAddress"));
        creditCardNumberField.sendKeys(details.get("creditCardNumber"));
        selectByVisibleText(creditCardTypeDropdown, details.get("creditCardType"));
        selectByVisibleText(expiryMonthDropdown, details.get("expiryMonth"));
        selectByVisibleText(expiryYearDropdown, details.get("expiryYear"));
        cvvField.sendKeys(details.get("cvv"));
        bookNowButton.click();
        waitForBookingConfirmationPage();
    }

    public boolean isLoginConfirmed()
    {
        return logoutButton.isDisplayed();
    }

    public void selectByVisibleText(WebElement dropdown, String visibleText) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    public void waitForBookingConfirmationPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.id("order_no")));
    }
}
