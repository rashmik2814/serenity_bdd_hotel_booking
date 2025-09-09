package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;



    public void doLogin(String username, String password)
    {
        usernameField.clear();
        usernameField .sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.isDisplayed();
        loginButton.click();

    }

    public  int doAddition (int a, int b)
    {
     int c = a + b;
        System.out.println("Addition is: " + c);
        return c;
    }


}

