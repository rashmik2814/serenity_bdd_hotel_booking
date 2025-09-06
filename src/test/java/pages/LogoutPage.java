package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class LogoutPage extends PageObject {

    @FindBy(css = "a[href='index.php']")
    WebElement logoutText;
    public boolean isUserLoggedOut() {
        return(logoutText).isDisplayed();
    }

}
