package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class SearchHotelPage extends PageObject {

    @FindBy(id = "location")
    WebElement locationDropdown;

    @FindBy(id = "hotels")
    WebElement hotelDropdown;

    @FindBy(id = "room_type")
    WebElement roomTypeDropdown;

    @FindBy(id = "room_nos")
    WebElement numberOfRoomsDropdown;

    @FindBy(id = "datepick_in")
    WebElement checkInDateField;

    @FindBy(id = "datepick_out")
    WebElement checkOutDateField;

    @FindBy(id = "adult_room")
    WebElement adultsDropdown;

    @FindBy(id = "child_room")
    WebElement childrenDropdown;

    @FindBy(id = "Submit")
    WebElement searchButton;

    @FindBy(css = "input[id=\"hotel_name_0\"]")
    WebElement firstHotelName;

    @FindBy(css = "a[href=\"Logout.php\"]")
    WebElement logoutButton;

    public void searchHotel(Map<String, String> params) {
        selectByVisibleText(locationDropdown, params.get("location"));
        selectByVisibleText(hotelDropdown, params.get("hotelName"));
        selectByVisibleText(roomTypeDropdown, params.get("roomType"));
        selectByVisibleText(numberOfRoomsDropdown, params.get("numberOfRooms"));
        checkInDateField.clear();
        checkInDateField.sendKeys(params.get("checkInDate"));
        checkOutDateField.clear();
        checkOutDateField.sendKeys(params.get("checkOutDate"));
        selectByVisibleText(adultsDropdown, params.get("adults"));
        selectByVisibleText(childrenDropdown, params.get("children"));
        searchButton.click();
    }
    public void selectFirstHotel() {
        // Select first result and continue
        $( "#radiobutton_0" ).click();
        $( "#continue" ).click();
    }

    private void selectByVisibleText(WebElement dropdown, String visibleText) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
    public String getSelectedHotelName() {
        // Return hotel name displayed in results
        return (firstHotelName).getAttribute("value");
    }
    public void logout() {
        logoutButton.click();
    }
}

