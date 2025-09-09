package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingConfirmationPage extends PageObject {

    @FindBy(id = "order_no")
    WebElement orderIdField;

    public String getOrderId() {
        return orderIdField.getAttribute("value");
    }

    public boolean isOrderIdDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), java.time.Duration.ofSeconds(10)); // wait up to 10 seconds        wait.until(ExpectedConditions.visibilityOf(orderIdField));
        return orderIdField.isDisplayed();    }
}

